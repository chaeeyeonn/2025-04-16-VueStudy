<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
   jdk => 오라클 (X) => 11~14 
   => openjdk 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
   <tr>
    <td class="text-center" colspan="3">
     <img src="http://www.menupan.com${vo.poster }" style="width:650px;height:350px">
    </td>
   </tr>
   <tr>
    <td class="text-center" colspan="3"><h3>${vo.name }</h3></td>
   </tr>
   <tr>
    <td class="text-center" style="color:gray" colspan="3">${vo.content }</td>
   </tr>
   
  </table>
  
   
    <h3>[상세정보]</h3>
   
   <div>
				<h4>맛집 유형</h4>
				<p>${vo.type}</p>
				<h4>주소</h4>
				<p>${vo.address }</p>

				<h4>운영 시간</h4>
				<p>${vo.time}</p>


				<h4>가격대</h4>
				<p>${vo.price}</p>


				<h4>주차</h4>
				<p>${vo.parking}</p>


				<h4>테마</h4>
				<p>${vo.theme}</p>


				<h4>전화</h4>
				<p>${vo.phone}</p>
			</div>
  
  <table class="table">
   
  </table>
  
</body>
</html>