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
.container-fluid{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
     <input type="checkbox" value="name">업체명
     <input type="checkbox" value="address">주소
     <input type="checkbox" value="type">음식종류
     <input type="checkbox" value="theme">테마
     <input type="text" size=15 class="input-sm" ref="fd" v-model="fd">
     <input type="button" class="btn-sm btn-primary" val="검색">
    </div>
    <div style="height:10px"></div>
    <div class="row">
      <div class="col-sm-8">
      
      </div>
      <div class="col-sm-4">
       
      </div>
    </div>
  </div>
  <script>
   const detailCom={
		   template:'<div class="text-center"><h1>{{$parent.msg}}</h1></div>'		   
   }
   let foodApp=Vue.createApp({
	   data(){
		   return{
			   msg:'',
			   fd:'마포',
			   food_list:[],
			   curpage:1,
			   endPage:0,
			   startPage:0,
			   totalpage:0
		   }
	   },
	   mounted(){
		   
	   },
	   updated(){
		   
	   },
	   methods:{
		   dataRecv(){
			   async axios.get('list.do',{
				   params:{
					   page:this.curpage,
					   fd:this.fd
				   }
			   }).then(res=>{
				   
			   }).catch(error=>{
				   
			   })
		   }
	   }
   })
   foodApp.component("detail",detailCom)
   foodApp.mount(".container-fluid")
  </script>
</body>
</html>