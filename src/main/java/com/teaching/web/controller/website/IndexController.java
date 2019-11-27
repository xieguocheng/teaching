package com.teaching.web.controller.website;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teaching.enums.CommonStatus;
import com.teaching.enums.ConstsSiteCarouselStatus;
import com.teaching.enums.CourseStatus;
import com.teaching.mapper.*;
import com.teaching.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/3/31 11:06
 */

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ConstsSiteCarouselMapper constsSiteCarouselMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;
    @Autowired
    private UserBehaviorMapper userBehaviorMapper;
    @Autowired
    private AuthUserMapper authUserMapper;

    /**
     * 网站首页
     * @return
     */
    @GetMapping("/website/index")
    public ModelAndView index(Map<String, Object> map,Model model) {
        //免费课程
       List<ConstsSiteCarousel> freeCourse1=new ArrayList<>();
        List<ConstsSiteCarousel> freeCourse2=new ArrayList<>();

        Example example=new Example(ConstsSiteCarousel.class);
        example.createCriteria().andEqualTo("type",ConstsSiteCarouselStatus.TYPE_FREE.getValue());//免费课程
        example.orderBy("status").asc();
        example.orderBy("weight").asc();
        List<ConstsSiteCarousel> freeCourseList=constsSiteCarouselMapper.selectByExample(example);
        for(int i=0;i<4;i++){
            freeCourse1.add(freeCourseList.get(i));
        }
        model.addAttribute("freeCourse1",freeCourse1);
        model.addAttribute("freeCourse2",freeCourse1);

        //实战课程
        List<ConstsSiteCarousel> moneyCourseList1=new ArrayList<>();
        List<ConstsSiteCarousel> moneyCourseList2=new ArrayList<>();
        Example example1=new Example(ConstsSiteCarousel.class);
        example1.createCriteria().andEqualTo("type",3);//实战课程
        example1.orderBy("status").asc();
        example1.orderBy("weight").asc();
        List<ConstsSiteCarousel> moneyCourseList=constsSiteCarouselMapper.selectByExample(example1);
        for(int i=0;i<4;i++){
            moneyCourseList1.add(moneyCourseList.get(i));
        }
        model.addAttribute("moneyCourseList1",moneyCourseList1);
        model.addAttribute("moneyCourseList2",moneyCourseList1);

        //系统推荐
        List<Course> systemCourseList1=new ArrayList<>();
        Example example2=new Example(Course.class);
        example2.createCriteria().andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue());//审核成功
        example2.orderBy("studyCount").asc();
        List<Course> systemCourseList=courseMapper.selectByExample(example2);
        for(int i=0;i<5;i++){
            systemCourseList1.add(systemCourseList.get(i));
        }
        model.addAttribute("systemCourseList1",systemCourseList1);

        return new ModelAndView("website/index", map);
    }

    /**
     * 网站所有课程
     * @return
     */
    @GetMapping("/website/course")
    public ModelAndView course(Map<String, Object> map,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "9")Integer pageSize) {

        //类目
        List<ConstsClassify> treeList=constsClassifyMapper.getTree();
        map.put("treeList", treeList);

        PageHelper.startPage(pageNum, pageSize);

        Example example=new Example(Course.class);
        example.createCriteria().andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue())//审核成功
                .andEqualTo("onsale",CourseStatus.ONSALE_YES.getValue())//上架了
                .andEqualTo("del",CommonStatus.DEL_NO)
        ;
        example.orderBy("weight").desc();
        example.orderBy("studyCount").asc();
        List<Course> courseList=courseMapper.selectByExample(example);

        PageInfo<Course> newsPage = new PageInfo<>(courseList);

        map.put("newsPage", newsPage);
        map.put("currentPage", pageNum);
        map.put("pageSize", pageSize);

        return new ModelAndView("website/course", map);
    }



    /**
     * 网站课程智慧推荐
     * @return
     */
    @GetMapping("/website/recommend")
    public ModelAndView recommend(Map<String, Object> map,Model model,HttpServletRequest request) {

        //获取当前登录的用户
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            if (auth instanceof AnonymousAuthenticationToken) {
                map.put("courseList", null);
                map.put("userList", null);
                return new ModelAndView("website/recommend", map);
            }
        }
        AuthUser authUser= (AuthUser) auth.getPrincipal();

        List<UserBehavior> list=userBehaviorMapper.getUserBehavior();
        Integer N=list.size();
        int[][] sparseMatrix = new int[N][N];//建立用户稀疏矩阵，用于用户相似度计算【相似度矩阵】
        Map<String, Integer> userItemLength = new HashMap<>();//存储每一个用户对应的不同物品总数  eg: A 3
        Map<String, Set<String>> itemUserCollection = new HashMap<>();//建立物品到用户的倒排表 eg: a A B
        Set<String> items = new HashSet<>();//辅助存储物品集合
        Map<String, Integer> userID = new HashMap<>();//辅助存储每一个用户的用户ID映射
        Map<Integer, String> idUser = new HashMap<>();//辅助存储每一个ID对应的用户映射

        //依次处理N个用户
        for(int i = 0; i < N ; i++){
            String userId=String.valueOf(list.get(i).getUserId());
            int length = list.get(i).getUserBehaviorList().size();
            userItemLength.put(userId,length);//eg: A 3

            //用户ID与稀疏矩阵建立对应关系
            userID.put(userId, i);
            idUser.put(i, userId);

            //建立物品--用户倒排表
            for (UserBehavior userBehavior : list.get(i).getUserBehaviorList()) {
                String courseId=String.valueOf(userBehavior.getCourseId());
                if(items.contains(courseId)){//如果已经包含对应的物品--用户映射，直接添加对应的用户
                    itemUserCollection.get(courseId).add(userId);
                }else{
                    items.add(courseId);
                    itemUserCollection.put(courseId, new HashSet<String>());//创建物品--用户倒排关系
                    itemUserCollection.get(courseId).add(userId);
                }
            }

        }
        log.info("建立课程到用户的倒排表 eg: a A B--------"+itemUserCollection.toString());

        //计算相似度矩阵【稀疏】
        Set<Map.Entry<String, Set<String>>> entrySet = itemUserCollection.entrySet();
        Iterator<Map.Entry<String, Set<String>>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Set<String> commonUsers = iterator.next().getValue();
            for (String user_u : commonUsers) {
                for (String user_v : commonUsers) {
                    if(user_u.equals(user_v)){
                        continue;
                    }
                    sparseMatrix[userID.get(user_u)][userID.get(user_v)] += 1;//计算用户u与用户v都有正反馈的物品总数
                }
            }
        }
        log.info("存储每一个用户对应的不同课程总数  eg: A 3--------"+userItemLength.toString());

        log.info("开始进行智能推荐...");
        String recommendUser=String.valueOf(authUser.getId());

        //计算用户之间的相似度【余弦相似性】
        Map<String,String> userMap=new HashMap<>();//用户推荐
        Map<String,String> courseMap=new HashMap<>();//课程推荐
        IndexController test = new IndexController();
        IndexController.ValueComparator userValueComparator = test.new ValueComparator(userMap);
        IndexController.ValueComparator courseValueComparator = test.new ValueComparator(courseMap);
        Map<String, String> userValueSortMap = new TreeMap<>(userValueComparator);//用户排序
        Map<String, String> courseValueSortMap = new TreeMap<>(courseValueComparator);//课程排序
        DecimalFormat df=new DecimalFormat("0.000");


        int recommendUserId = userID.get(recommendUser);
        for (int j = 0;j < sparseMatrix.length; j++) {
            if(j != recommendUserId){
                Double temp=sparseMatrix[recommendUserId][j]
                        /
                        Math.sqrt(userItemLength.get(idUser.get(recommendUserId))*userItemLength.get(idUser.get(j)));
                if(temp!=0.0D){
                    userMap.put(idUser.get(j),df.format(temp));
                }
                //log.info("用户："+idUser.get(recommendUserId)+"--"+"用户："+idUser.get(j)+"相似度:"+df.format(temp));
            }
        }
        userValueSortMap.putAll(userMap);
        log.info("用户："+idUser.get(recommendUserId)+"与各个用户相似度"+userValueSortMap.toString());

        //计算指定用户recommendUser的物品推荐度
        for(String item: items){//遍历每一件物品
            Set<String> users = itemUserCollection.get(item);//得到购买当前物品的所有用户集合
            if(!users.contains(recommendUser)){//如果被推荐用户没有购买当前物品，则进行推荐度计算
                double itemRecommendDegree = 0.0;
                for(String user: users){
                    itemRecommendDegree += sparseMatrix[userID.get(recommendUser)][userID.get(user)]
                            /
                            Math.sqrt(userItemLength.get(recommendUser)*userItemLength.get(user));
                }
                if(itemRecommendDegree!=0.0d){
                    courseMap.put(item,df.format(itemRecommendDegree));
                }
                //log.info("课程："+item+" 对用户： "+recommendUser +"的推荐等级："+itemRecommendDegree);
            }
        }
        courseValueSortMap.putAll(courseMap);
        log.info("所有课程推荐:"+courseValueSortMap.toString());

        log.info("智能推荐结束...");


        List<AuthUser> authUserList= new ArrayList<>();
        Iterator iter = userValueSortMap.keySet().iterator();
        while(iter.hasNext()) {
            String id= (String)iter.next();
            AuthUser temp=authUserMapper.selectByPrimaryKey(new AuthUser(Integer.valueOf(id)));
            authUserList.add(temp);
        }
        map.put("authUserList", authUserList);

        List<Course> courseList= new ArrayList<>();
        Iterator iter1 = courseValueSortMap.keySet().iterator();
        while(iter1.hasNext()) {
            String id= (String)iter1.next();
            Course temp=courseMapper.selectByPrimaryKey(new Course(Integer.valueOf(id)));
            courseList.add(temp);
        }
        map.put("courseList", courseList);

        return new ModelAndView("website/recommend", map);
    }

    /**
     * 网站课程智慧推荐
     * @return
     */
    @GetMapping("/website/bbs")
    public ModelAndView bbs(Map<String, Object> map,Model model) {

        return new ModelAndView("website/bbs", map);
    }

    /**
     * 网站关于
     * @return
     */
    @GetMapping("/website/about")
    public ModelAndView about(Map<String, Object> map,Model model) {

        return new ModelAndView("website/about", map);
    }


    /**
     * 网站登录页面
     * @return
     */
    @GetMapping("/website/login")
    public ModelAndView login(Map<String, Object> map) {


        return new ModelAndView("website/login", map);
    }

    /**
     * 网站注册页面
     * @return
     */
    @GetMapping("/website/register")
    public ModelAndView register(Map<String, Object> map) {


        return new ModelAndView("website/register", map);
}


    /**
     * 网站注册页面
     * @return
     */
    @GetMapping("/website/shopcart")
    public ModelAndView shopcart(Map<String, Object> map) {


        return new ModelAndView("website/shopcart", map);
    }





    class ValueComparator implements Comparator<String> {

        Map<String, String> base;

        //Comparator外部比较器
        public ValueComparator(Map<String, String> base) {
            this.base = base;
        }

        //根据Map的值进行比较,降序
        public int compare(String a, String b) {
            if( base.get(b).equals( base.get(a))){
                return 1;
            }
            return base.get(b).compareTo(base.get(a));
        }
    }


}
