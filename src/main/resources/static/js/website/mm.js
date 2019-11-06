
layui.define(['jquery','element','laytpl','carousel','laypage'],function(exports){
	var $ = layui.$,laytpl = layui.laytpl,element = layui.element,laypage = layui.laypage,carousel = layui.carousel;
	var _mm = {
		request : function(param){
			var _this = this;
			$.ajax({
				type   		: param.method || 'get',
				url    		: param.url    || '',
				dataType 	: param.type || 'json',
				data 		: param.data || '',
				success 	: function(res){
					 // 请求成功
	                if(0 === res.status){
	                	debugger;
	                    typeof param.success === 'function' && param.success(res, res.msg);
	                }
					// 请求数据错误
	                else if(1 === res.status){
                        debugger;
	                    typeof param.error === 'function' && param.error(res.msg);
	                }
				},
				error : function(err){
                    debugger;
					 typeof param.error === 'function' && param.error(err.statusText);	
				}
			});
		},
		renderHtml : function(htmlTemplate, data){
	        var template    = laytpl(htmlTemplate),
	            result      = template.render(data);
	        return result;
	    }
	}
  exports('mm',_mm);

    //关于内容
    $('.main-about').find('.aboutab').children('li').each(function(index){
        $(this).on('click', function(){
            $(this).addClass('layui-this').siblings().removeClass('layui-this');
            $('.aboutab').siblings().fadeOut("fast");
            $('.aboutab').siblings().eq(index).fadeIn("");
        });
    });

   /* exports('mm', {});*/
});