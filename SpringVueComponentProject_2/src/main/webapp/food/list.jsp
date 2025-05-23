<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
nav-link:hover{
  cursor:pointer;
}
</style>
<script src="../js/page-card.js"></script>
</head>
<body>
   <div class="container-fluid">
    <div class="row">
      <div class="col-sm-8">
        <div class="col-md-3" v-for="vo in list">
		    <div class="thumbnail">
		      <a class="nav-link" @click="">
		        <img :src="'http://www.menupan.com'+vo.poster" style="width:230px;height: 130px">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
       
        <div style="height: 10px"></div>
        <div class="text-center">
         <%-- 페이지 출력 --%>
           <page-card></page-card>
         </div>
      </div>
      <div class="col-sm-4">
        <%-- 상세보기:component --%>
      </div>
    </div>
   </div>
   <script>
     const food_detail={
    		 props:['detail'],
    		 template:
    			 `
    			 	<table class="table">
     		         
     				</table>
    			 `
     }
     let foodApp=Vue.createApp({
    	data(){
    		return {
    			list:[],
    			curpage:1,
    			totalpage:0,
    			startPage:0,
    			endPage:0,
    			detail:{}
    		}
    	},
    	mounted(){
    		this.dataRecv()
    	},
    	methods:{
    		// 이전
    		prev() {
    			this.curpage=this.startPage-1
    			this.dataRecv()
    		},
    		// 다음
    		next(){
    			this.curpage=this.endPage+1
    			this.dataRecv()
    		},
    		// 1 2 3 4 .. => 페이지 클릭
    		pageChange(page){
    			this.curpage=page
    			this.dataRecv()
    		},
    		// 블럭별 페이지 나누기 
    		range(start,end){
    			let arr=[]
    			let len=end-start
    			for(let i=0;i<=len;i++)
    		    {
    			   arr[i]=start
    			   start++
    		    }
    			return arr
    		},
    		// 공통사용 
    		dataRecv(){
              axios.get("../food/list_vue.do",{
            	  params:{
            		  page:this.curpage
            	  }
              }).then(res=>{
            	  console.log(res.data)
            	  this.list=res.data.list
            	  this.curpage=res.data.curpage
            	  this.totalpage=res.data.totalpage
            	  this.startPage=res.data.startPage
            	  this.endPage=res.data.endPage
            	  
              }).catch(error=>{
            	  console.log(error.response)
              })  			
    		}
    	},
    	components:{
    		'page-card':page_card
    	}
     }).mount(".container-fluid")
   </script>
</body>
</html>