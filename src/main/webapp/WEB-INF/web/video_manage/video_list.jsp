<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cj" uri="http://zhiyou100.com/common/"%>
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
      <script type="text/javascript">
      var a = 0; 
       window.onload = function(){
    	  
      } 
        function quanxuan(Check){
        	a = 0;  	    		 		
    		$(".checkeeee").each(function(index,i){    			
    		    i.checked=Check.checked;
    			a++;    			
    			if(Check.checked==false){a=0;}
    		});
    		$("#addint").text(a); 		
    	 }  

        function danxuan(Check,id){        	
        	if(Check.checked==true){
        		a++;
        	}else{
        		a--;
        	}    		
        	$("#addint").text(a); 		
    	} 
       
        function deleteAll(){         	
     	   var b = "";     	  
     	  $(".checkeeee").each(function(index,i){
     		   if(i.checked==true){    				    			    
    			    b += "&id="+i.value;
    			    alert(b);
    			}  
     	   });
     	   alert(b);
         	 document.location = "/video/video_manage/delete.action?" + b.substr(1);
         }  
      </script>
   <style>       
        .zhuti{ 
        	margin: 0 auto;
        	width: 1140px;
            }       
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
    <div  class="jumbotron mubu" style="background-color: wheat;position: relative; margin-top: -20px;">
     <h1>视频列表-视频管理</h1>      
    </div>
   </div>
    <p></p>
    <div class="zhuti">                                                     
    	<form class="form-inline" action="${pageContext.request.contextPath }/admin/video_manage/video_list.action">    	        
	    	    <a href="${pageContext.request.contextPath }/admin/video_manage/video_add.action" class="btn btn-primary btn-lg active" role="button">添加视频</a>   	 
		        <button class="btn btn-primary btn-lg active" type="button" onclick="deleteAll()">批量删除 <span id="addint" class="badge">0</span></button>
		            
                    <div style="float: right;">                    
                    <input type="text"  class="form-control" placeholder="视频标题" name="videoTitle" value="${video.videoTitle }">
                     
		            <select class="form-control" name="speakerName">
		        	<option value="">请选择主讲人</option>
		        	<c:forEach items="${findAllSpeaker }" var="list" >
		        	<option ${video.speakerName == list.speakerName?"selected":"" }>${list.speakerName }</option>		        	
		        	</c:forEach>
		            </select>
                    
		            <select class="form-control" name="courseName">
		            <option value="">请选择课程</option>
		        	<c:forEach items="${findAllCoursr }" var="list">
		        	<option ${video.courseName == list.courseName?"selected":"" }>${list.courseName}</option>		        	
		        	</c:forEach>
		            </select>
		           <input type="submit" value="查询" class="btn btn-primary"/>
		           </div>		        		          		                    
        </form> 
    </div>
    <div class="bs-example" data-example-id="striped-table" style="width: 1140px; margin:0 auto;">
    <table class="table table-striped">
      <thead>
        <tr>
          <th><input type="checkbox" onclick="quanxuan(this)" id="all"/></th>
          <th>序号</th>
          <th>名称</th>
          <th>介绍</th>
          <th>讲师</th>
          <th>课程</th>
          <th>时长(秒)</th>
          <th>播放次数</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${page.rows }" var="list" varStatus="status">
	        <tr>                                               
	          <th><input type="checkbox" class="checkeeee" value="${list.id}" onclick="danxuan(this,${list.id})"/></th>
	          <th>${status.count}</th>
	          <td>${list.videoTitle }</td>
	          <td>${list.videoDescr}</td>
	          <td>${list.speakerName }</td>
	          <td>${list.courseName }</td>
	          <td>${list.videoLength }</td>
	          <td>${list.videoPlayTimes }</td>
	          <td><a href="${pageContext.request.contextPath }/admin/video_manage/find_video_edit.action?id=${list.id}" class="glyphicon glyphicon-edit"></a></td>
	          <td><a href="${pageContext.request.contextPath }/admin/video_manage/delete_video.action?id=${list.id}" class="glyphicon glyphicon-trash"></a></td>
	        </tr>
     </c:forEach>
      </tbody>
    </table>
    <cj:page url="${pageContext.request.contextPath }/admin/video_manage/video_list.action"/>
  </div>  
  </body>
</html>
