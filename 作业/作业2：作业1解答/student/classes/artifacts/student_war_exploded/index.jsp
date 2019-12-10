
<%@ page  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>Home</title>  
    <style>  
       
        #left{  
            width: 15%;  
            height: 700px;  
            float: left;  
            border-right:1px solid gray;
        }  
        #right{  
            width: 84%;  
            height: 700px;  
            border:0;
        }  
    </style>  
<body>  
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
  
    <h2>班级，学生信息管理</h2><hr>
   
    <div id="left">
     <ul>
      <li><a href="${basePath}/bjServlet?action=list" target="right">班级管理</a></li>   
       <li><a href="${basePath}/studentServlet?action=list" target="right">学生管理</a></li>     
     </ul>
    </div>  
    <iframe id="right" name="right"  src=""></iframe>  
 
</body>  
</html>  