package com.teaching;

import com.teaching.dto.CourseSectionVO;
import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.ConstsClassifyMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.mapper.UserBehaviorMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.Course;
import com.teaching.pojo.UserBehavior;
import com.teaching.service.CommonService;
import com.teaching.service.CourseSectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/28 10:34
 */
@Slf4j
public class Test extends TeachingApplicationTests{

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;
    @Autowired
    private UserBehaviorMapper userBehaviorMapper;
    @Autowired
    private AuthUserMapper authUserMapper;
    @Autowired
    private CourseSectionService courseSectionService;

    @org.junit.Test
    public void test02() throws  Exception{
        List<CourseSectionVO> chaptSections = courseSectionService.queryCourseSection(10);
        System.out.println(chaptSections.toString());
    }

    @org.junit.Test
    public void test01() throws  Exception{

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
            String userId=String.valueOf(list.get(i).getUserId());/////////////////
            int length = list.get(i).getUserBehaviorList().size();
            userItemLength.put(userId,length);//eg: A 3

            //用户ID与稀疏矩阵建立对应关系
            userID.put(userId, i);
            idUser.put(i, userId);

            //建立物品--用户倒排表
            for (UserBehavior userBehavior : list.get(i).getUserBehaviorList()) {
                String courseId=String.valueOf(userBehavior.getCourseId());//////////////////
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
        String recommendUser="1";

        //计算用户之间的相似度【余弦相似性】
        Map<String,String> userMap=new HashMap<>();//用户推荐
        Map<String,String> courseMap=new HashMap<>();//课程推荐
        Test test = new Test();
        Test.ValueComparator userValueComparator = test.new ValueComparator(userMap);
        Test.ValueComparator courseValueComparator = test.new ValueComparator(courseMap);
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

        List<AuthUser> authUserList= new ArrayList<>();
        Iterator iter = userValueSortMap.keySet().iterator();
        while(iter.hasNext()) {
             Integer id= (Integer)iter.next();
            AuthUser authUser=authUserMapper.selectByPrimaryKey(new AuthUser(id));
            authUserList.add(authUser);
        }


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
