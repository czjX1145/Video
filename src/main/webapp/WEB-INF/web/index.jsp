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
    <title>登录</title>
 
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>
    <script type="text/javascript">
    $(function(){
  	  $("#checkForm").validate({
  		  rules:{
  			loginName:{
  				  required:true,
  				  minlength:5
  			  },
  			loginPwd:{
  	        	  required:true,
  	        	  minlength:5
  	          }
  		  },
  	      messages:{
  	    	loginName:{
  	    		  required:"用户名不能为空",
  	    		  minlength:"长度不能少于6位"
  	    		  },
  	    	loginPwd:{
  		    	  required:"密码不能为空",
  		    	  minlength:"长度不能小于6位" 
  		      }
  	      }
  	  });
    });
   
    </script>
   <style>
		
		.container{						
			margin: 0 auto;
			margin-top: 300px;
			height:200px;
			width: 350px;			
		}
   </style>
  </head>
  
  <body>
  	<div class="container">
  		<img src="${pageContext.request.contextPath }/img/logo.png"/>
  	<form id="checkForm" action="${pageContext.request.contextPath }/admin/adminLogin.action">
  	    
	    <input type="text" class="form-control" placeholder="用户登录" name="loginName" value="admin">
	    <p></p>
	    <input type="password" class="form-control"  placeholder="登录密码" name="loginPwd" value="admin">
	    <p></p>
	    <input type="submit" class="btn btn-primary btn-lg btn-block" style="background-color: limegreen;" value="登录"/>
    </form>
    </div>
  </body>
</html>