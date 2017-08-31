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
            <li class="active"><a href="${pageContext.request.contextPath }/admin/video_manage/video_list.action">视频管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/lecturer_manage/lecturer_manage.action"">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/course_manage/course_manage.action">课程管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/statement_manage/statement_manage.action">统计分析</a></li>                                
          </ul>
          
          <ul class="nav navbar-nav" style="float: right;">
            <li class="fudong"><a  href="#">${admin.loginName }</a></li>
            <li class="fudong"><a href="${pageContext.request.contextPath }/admin/outLogin.action" class="glyphicon glyphicon-log-out" href="#"></a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
            
      </div><!-- /.container-fluid -->
   </nav>	  
    <div  class="jumbotron mubu">
     <h1>视频编辑信息-视频管理</h1>      
    </div>
    <p></p>
    <div class="zhuti">
		  <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/video_manage/addvideo.action">
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频标题:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="视频标题" name="videoTitle">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputSmall">主讲人:</label>
		    <div class="col-sm-10">      
		      <select class="form-control" id="formGroupInputSmall" name="speakerId">
		          <option>选择主讲人</option>	
			      <c:forEach items="${findAllSpeaker }" var="list">
			      <option value="${list.id }">${list.speakerName }</option>			      	
			      </c:forEach>
		      </select>
		    </div>
		  </div>
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputSmall">所属课程:</label>
		    <div class="col-sm-10">      
		      <select class="form-control" id="formGroupInputSmall" name="courseId">
		      	<option>请选择课程</option>
		      	<c:forEach items="${findAllCoursr }" var="list">
			    <option value="${list.id }">${list.courseName }</option>			      	
			    </c:forEach>
		      </select>
		    </div>
		  </div>
		
		   
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频时长:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="视频时长(秒)" name="videoLength">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">封面图片:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="课程封面图片地址,网络图片" name="videoImageUrl">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频播放地址:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="视频播放地址,网络地址" name="videoUrl">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频简介:</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="formGroupInputSmall" name="videoDescr"></textarea>
		    </div>
		  </div>
		  <input type="submit" value="保存" class="btn btn-primary" style="margin-left: 175px;"/>
		  <!-- <a class="btn btn-default" href="javascript:history.go(-1)">返回</a> -->
		  <a href="javascript:history.go(-1)" type="button" class="btn btn-default">返回列表</a>
		  </form>
  </div>
  
  </body>
</html>

