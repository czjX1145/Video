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
    <title>主讲人管理</title>
 
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
          	 <li><a href="${pageContext.request.contextPath }/admin/video_manage/video_list.action">视频管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/admin/lecturer_manage/lecturer_manage.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/course_manage/course_manage.action">课程管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/statement_manage/statement_manage.action">统计分析</a></li>                                
          </ul>
          
          <ul class="nav navbar-nav" style="float: right;">
            <li class="fudong"><a  href="#">${admin.loginName }</a></li>
            <li class="fudong"><a href="${pageContext.request.contextPath }/admin/outLogin.action" class="glyphicon glyphicon-log-out","fudong" href="#"></a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
            
      </div><!-- /.container-fluid -->
   </nav>	  
    <div  class="jumbotron mubu">
     <h1>主讲人列表-主讲人管理</h1>      
    </div>
    <div class="zhuti">                   
    	<form class="form-inline" action="${pageContext.request.contextPath }/admin/lecturer_manage/lecturer_manage.action">   	    
	    	    <a href="${pageContext.request.contextPath }/admin/lecturer_manage/skipaddlecturer.action" class="btn btn-primary btn-lg active" role="button">添加主讲人</a> 
	    	    <div style="float: right;">
                   <form class="form-inline">
						  <div class="form-group">
						    <label for="exampleInputName2">名称:</label>
						    <input type="text" class="form-control" id="exampleInputName2" placeholder="主讲人名称" name="speakerName" value="${speakerName}">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail2">职位:</label>
						    <input type="text" class="form-control" id="exampleInputEmail2" placeholder="主讲人职位" name="speakerJob" value="${speakerJob}">
						  </div>
						  <input type="submit" value="查询" class="btn btn-primary"/>
                   </form>
                 </div>
           
        </form>
       </div>
    
    <div class="bs-example" data-example-id="striped-table" style="width: 1000px; margin:0 auto;">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>序号</th>
          <th>名称</th>
          <th>职位</th>
          <th>简介</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${page.rows }" var="list" varStatus="status">
        <tr> 
          <th >${ status.count }</th>
          <td>${list.speakerName }</td>
          <td>${list.speakerJob }</td>
          <td>${list.speakerDescr }</td>
          <td><a href="${pageContext.request.contextPath }/admin/lecturer_manage/skip_lecturer_edit.action?id=${list.id}" class="glyphicon glyphicon-edit"></a></td>
          <td><a href="${pageContext.request.contextPath }/admin/lecturer_manage/updatelecturer.action?id=${list.id}" class="glyphicon glyphicon-trash"></a></td>
        </tr>
    </c:forEach>      
      </tbody>
    </table>
    <cj:page url="${pageContext.request.contextPath }/admin/lecturer_manage/lecturer_manage.action"/>
  </div>
   
  </body>
</html>
