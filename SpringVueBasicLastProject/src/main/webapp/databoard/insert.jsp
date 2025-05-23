<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script> <!-- AWS에서 잘 안 돌아갈 수도 -->
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
</style>
</head>
<body>
  <div class="container">
   <div class="row">
   <h3 class="text-center">글쓰기</h3>
   <form @submit.prevent="submitForm">
   <!-- defaultPrevent(): 이벤트 정지 => 먼저 실행되지 않도록 => null값 보내지 않도록 한 뒤 함수 먼저 실행-->
   <table class="table">
     <tr>
      <th width=15%>이름</th>
      <td width=85%>
       <input type=text name=name size=20 required
        class="input-sm" ref="name" v-model="name"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>제목</th>
      <td width=85%>
       <input type=text name=subject size=50 required
        class="input-sm" ref="subject" v-model="subject"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>내용</th>
      <td width=85%>
       <textarea rows="5" cols="52" name=content required
       ref="content" v-model="content"></textarea>
      </td>
     </tr>
     <tr>
      <th width=15%>첨부파일</th>
      <td width=85%>
       <input type=file class="input-sm" multiple="multiple" 
       ref="files" v-model="files" accept="upload/*"> 
       <!-- 실제 프로젝트에서는 realpath 지정 -->
      </td>
     </tr>
     <tr>
      <th width=15%>비밀번호</th>
      <td width=85%>
       <input type=password name=pwd size=10 required
        class="input-sm" ref="pwd" v-model="pwd"
       >
      </td>
     </tr>
     <tr>
       <td colspan="2" align=center>
         <input type=submit value="글쓰기" class="btn-sm btn-danger">
         <input type=button value="취소" class="btn-sm btn-primary"
          onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </form>
   </div>
  </div>
  <script>
    let insertApp=Vue.createApp({
    	data(){
    		return {
    			name:'',
    			subject:'',
    			content:'',
    			pwd:'',
    			files:''
    		}
    	},
    	mounted(){
    		// 자동 호출 함수 => 화면 변경시 한 번만 수행
    	},
    	updated(){
    		
    	},
    	// 사용자 정의 함수
    	methods:{
    		submitForm(){
    			/* if(this.name==="")
    			{
    				this.$refs.name.focus()
    				return
    			} */ //현재 name은 required 상태기 때문에 안 써도 됨
    			// 데이터를 모아서 한 번에 전송
    			let formData=new FormData()
    			formData.append("name",this.name)
    			formData.append("subject",this.subject)
    			formData.append("content",this.content)
    			formData.append("pwd",this.pwd)
    			
    			let len=this.$refs.files.files.length
    			//alert("File Lenth:"+len)
    			if(len>0)
    			{
    				for(let i=0;i<len;i++)
    				{
    					formData.append("files["+i+"]",this.$refs.files.files[i])
    				}
    			}
    			axios.post('insert_ok.do',formData,{
    				header:{
    					'Content-Type':'multipart/form-data'
    				}
    			}).then(response=>{
    				if(response.data==='yes')
    				{
    					location.href='list.do'
    				}
    				else
    				{
    					alert(response.data)
    				}
    			}).catch(error=>{
    				console.log(error.response)
    			})
    		}
    	}
    }).mount(".container")
  </script>
</body>
</html>