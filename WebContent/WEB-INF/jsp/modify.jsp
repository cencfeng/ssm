<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/context/base/jquery.min.js"></script>

	<script type="text/javascript">
	       $(function(){
	    	   $("#btnsure").click(function(){
	    		   var oldpassword=$("#oldpassword").val();
	    		   var newpassword=$("#newpassword").val();
	    		   var newpasswordsure=$("#newpasswordsure").val();
	    		   //var username=$('[name="username"]').val();
	    		   //var username=$("#username").val();
	    		   var username=$("#username").text();
	    		   alert(username);
	    		   if(oldpassword==newpassword)
    			   {
    			      alert("新密码不能和旧密码相同");
    			      return false;
    			   }
    		   if(newpassword!=newpasswordsure)
    			   {
    			     alert("两次密码输入不一致,请重新输入");
    			     return false;
    			   }
	    		   $.post("resetPassword2",{username:username,oldpassword:oldpassword,newpassword:newpassword},function(data){	    			  
	    			   //$("#resetForm").attr("action","resetPassword2");
	    			   //$("#resetForm").submit();
	    			   alert(data);
	    			   if(data=="ok"){	    			       
	    			       //$("#resetForm").empty();
	    			       $("input[type=text]").each(function() {
							 $(this).val("");
						})
	    			       alert("密码修改成功");
	    			   }else{
	    				   alert("原始密码不正确");
	    			   }
						
					
	    		   });
	    		   //$("#resetForm").attr("action","resetPassword");
	    		   //$("#resetForm").submit();    		  
	    	   });	  
	    	   
	    	
	    	  /*$("#mytest").click(function(){
	    		 
	    		   $("input[type=text]").each(function() {
						$(this).val("");
	    		   });
	    	   });*/
	       })
	      
	</script>
</head>
<body>
<form action="" method="post" id="resetForm">
    <div>
        <div>
        <input type="button" id="test"  value="test">
            用户名:<label id="username">${sessionScope.username} </label>
          <br>
      原始密码:<input type="text" id="oldpassword" name="oldpassword"><br>
      新密码:<input type="text" id="newpassword" name="password"><br>
      新密码确认:<input type="text" id="newpasswordsure" name="newpasswordsure"> <br>     
   <input type="button" id="btnsure" value="确认提交">
        </div>
    </div>
    </form>
    
    </body>
</html>