<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>视频添加</title>
 
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    
   <style>
		.mubu{
			width: 1000px; 
			margin: 0 auto;
			text-align: center;
		}
        
        .zhuti{
        	margin: 0 auto;
        	width: 1000px;
        }
        /*input{
        	margin-left: 100px;
        }*/
   </style>
  </head>
  
  <body>
  	<nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div style="margin-left: 300px;" class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div style="margin-left: 300px;" class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li ><a href="${pageContext.request.contextPath }/admin/video_manage/video_list.action">视频管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/lecturer_manage/lecturer_manage.action"">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/course_manage/course_manage.action">课程管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/admin/statement_manage/statement_manage.action">统计分析</a></li>                                
          </ul>          
          <ul class="nav navbar-nav" style="float: right;">
            <li class="fudong"><a  href="#">${admin.loginName }</a></li>
            <li class="fudong"><a href="${pageContext.request.contextPath }/admin/outLogin.action" class="glyphicon glyphicon-log-out" href="#"></a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
            
      </div><!-- /.container-fluid -->
   </nav>	  
    <div  class="jumbotron mubu">
     <h1>统计-统计分析</h1>      
    </div>
    <p></p>
    <!-- 统计图 -->
       <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1000px;height:600px; margin: 0 auto;" ></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text:'课程平均播放次数',
				        subtext: '数据来源:zhiyou.com',
				         x:'center'	
            },
            tooltip: {},
            legend: {
                data:['课程平均播放次数'],
                 y: 'bottom' 
            },
            xAxis: {
                data: ["前端开发与Git入门","每天20分钟轻松入门React","UI基础入门","Phython编程零基础入门","轻松进击PHP基础"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [${statementList[2]}, ${statementList[3]}, ${statementList[4]}, ${statementList[5]}, ${statementList[6]}]
            }]
        }

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
  </body>
</html>

