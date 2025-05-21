<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	사용자(변경 요청)
		|
	Controller(DispatcherServlet)
		|
	사용자 요청에 따라 변경(Model => @Controller,@RestController)
		|
	Controller
		|
	   JSP
	   
	사용자(변경 요청)
		|
	View(HTML)
		|
	사용자 요청 따라 변경
		|
	ViewModel: 변수값 변경 => methods, mounted
		|
	  Model: 변경된 데이터를 View(HTML) => data
	    |
	   View    
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	width: 960px;
	margin: 0px auto;
}
.dataTr:hover{
  cursor: pointer;
  background-color: cyan;
}
</style>
</head>
<body>

</body>
</html>