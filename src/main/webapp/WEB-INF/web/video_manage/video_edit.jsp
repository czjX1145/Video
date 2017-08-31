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
    <title>视频管理</title>
 
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
   <style>
    /*  
       function deleteAll(){      
    	   var b = "";
    	   $("#checkeeee").each(function(index,i){
    		   if(i.checked==true){    				    			    
   			    b += "&id="+box[i].value;    			   
   			}  
    	   });
    	   alert(b);
        	 document.location = "/video/video_manage/delete.action?" + b.substr(1);
        }  */
        div#div1{ 
			position:fixed; 
			top:0; 
			left:0; 
			bottom:0; 
			right:0; 
			z-index:-1; 
			} 
			div#div1 > img { 
			height:100%; 
			width:100%; 
			border:0; 
			}        
   </style>
  </head>
  
  <body>
  	<div id="div1" ><img src="${pageContext.request.contextPath }/img/xingkong.jpg" /></div>
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
            <li><a href="${pageContext.request.contextPath }/admin/lecturer_manage/lecturer_manage.action">主讲人管理</a></li>
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
    <div class="container">
    <div  class="jumbotron" style="background-image: url(${pageContext.request.contextPath }/img/mubu1.jpg); position: relative; margin-top: -20px;" >
     <h1>视频编辑信息-视频管理</h1>      
    </div>
    <p></p>
    <div style="margin: 0 auto;width: 1140px;">
		  <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/video_manage/updatevideo.action">
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频标题:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" name="videoTitle" value="${video.videoTitle }">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputSmall">主讲人:</label>
		    <div class="col-sm-10">      
		      <select class="form-control" id="formGroupInputSmall" name="speakerId">
		      	<c:forEach items="${findAllSpeaker }" var="list">
			      <option value="${list.id }" ${ list.id==video.speakerId?"selected":"" }>${list.speakerName }</option>			      	
			    </c:forEach>
		      </select>
		    </div>
		  </div>
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputSmall">所属课程:</label>
		    <div class="col-sm-10">      
		      <select class="form-control" id="formGroupInputSmall" name="courseId">
		      	<c:forEach items="${findAllCoursr }" var="list">
			     <option value="${list.id }" ${list.id==video.courseId?"selected":"" }>${list.courseName }</option>			      	
			    </c:forEach>
		      </select>
		    </div>
		  </div>
		
		   
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频时长:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" name="videoLength" value="${video.videoLength }">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">封面图片:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" name="videoImageUrl" value="${video.videoImageUrl }">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频播放地址:</label>
		    <div class="col-sm-10">
		      <input class="form-control" type="text" id="formGroupInputSmall" name="videoUrl" value="${video.videoUrl }">
		    </div>
		  </div>
		  
		  <div class="form-group form-group-sm">
		    <label class="col-sm-2 control-label" for="formGroupInputLarge">视频简介:</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="formGroupInputSmall" name="videoDescr">${video.videoDescr }</textarea>
		    </div>
		  </div>
		  <input type="hidden" name="id" value="${video.id }">
		  <input type="submit" value="保存" class="btn btn-primary" style="margin-left: 175px;"/>
		  <a href="javascript:history.go(-1)" type="button" class="btn btn-default">返回列表</a>
		  </form>
		  
     </div>
  </div>
  </body>
</html>

