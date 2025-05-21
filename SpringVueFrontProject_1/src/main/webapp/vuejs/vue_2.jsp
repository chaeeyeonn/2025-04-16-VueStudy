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
	margin-top:50px;
}
.row{
	width: 960px;
	margin: 0px auto;
}
</style>
</head>
<body>
  <%--
  		생명주기
  		Vue
  		 1. 가상돔 사용 => mount() : 속도가 빠르다
  		 	=> 게임(더블버퍼링)
  		 	=> String / StringBuffer
  		 	=> 가상메모리를 이용 처리
  		 2. callback => vue에서 지원하는 함수 => 자동 호출이 된다
  		 ------------------------------------------------
  		 3. 디렉티브: 제어문
  		 4. 서버 연동: axios
  		 5. 출력 형식: {{}}
  		 6. 양방향 통신 => axios
  		 7. router: 화면 변경 => Controller
  		 8. component
  		 -------------------------------------------------
  		 9. vue-bootstrap
  		 10. vue3 => vuex
  		     react => redux (MVC)
  		     --------------react-query: tanStack-query
  		     => Framework(nextjs)
  		     => javascript => 가독성: typescript
   --%>
   <div class="container">
     <div class="row">
      <input type="text" class="input-sm" size=20>
       <div class="text-center"></div>
     </div>
   </div>
   <script>
    let app=Vue.createApp({
    	data(){
    		return{
    			msg:''
    		}
    	},
    	beforeCreate(){
    		console.log("Vue 객체 생성 전: beforeCreate() call")
    	},
    	created(){
    		console.log("Vue 객체 생성: created() call")
    	},
    	beforeMount(){
    		console.log("화면 출력 전: beforeMount() call")
    	},
    	mounted(){
    		console.log("화면 출력: mounted() call")
    	},
    	beforeUpdate(){
    		console.log("data에 선언된 변수값이 갱신 전: beforeUpdate() call")
    	},
    	updated(){
    		console.log("data에 선언된 변수값이 갱신된 상태: updated() call")
    	},
    	beforeDestroy(){
    		console.log("화면 변경 전 상태: beforeDestroy() call")
    	},
    	destroyed(){
    		console.log("화면 전환 완료, Vue 객체 소멸: destroyed() call")
    	}
    })
   </script>
</body>
</html>