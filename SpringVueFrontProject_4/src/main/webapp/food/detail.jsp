<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <table class="table">
      <tr>
       <td colspan="3" class="text-center">
        <img :src="'http://www.menupan.com'+vo.poster" style="width:800px;height:250px">
       </td>
      </tr>
      <tr>
       <td colspan="3" class="text-center">
        <h3>{{vo.name}}</h3>
       </td>
      </tr>
    </table>
    <table class="table">
     <tr>
      <td><h3>[설명]</h3></td>
     </tr>
     <tr>
       <td colspan="3" class="text-center" style="color:gray">
        {{vo.content}}
       </td>
      </tr>
    </table>
    <table class="table">
     <tr>
      <td>
      </td>
     </tr>
    </table>
   </div>
  </div>
  <script>
   let detailApp=Vue.createApp({
	   data(){
		   return {
			   fno:${param.fno},
			   vo:{}
		   }
	   },
	   mounted(){
		   axios.get('../food/detail_vue.do',{
			   params:{
				   fno:this.fno
			   }
		   })
		   .then(res=>{
			  console.log(res.data)
			  this.vo=res.data.vo
		   })
		   // 에러 처리
		   .catch(error=>{
			   console.log(error.response)
		   })
	   },
	   methods:{
		   
	   }
   }).mount(".container")
  </script>
</body>
</html>