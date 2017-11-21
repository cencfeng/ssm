<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>年龄段</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/context/base/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/context/base/echarts.min.js"></script>
	 <script type="text/javascript">
	     $(function(){
	    	 var myChart=echarts.init(document.getElementById("main"));
	    	 var arName=new Array();
	    	 var arAge=new Array();   	 
	    	 $.post('/ssm/Report/ageper',{},function(data){	 
	    		//var ss=JSON.stringify(data);
	    		$.each(data,function(){	    			
	    			arName.push(this.emname);
	    			 arAge.push(this.age);
	    			
	    		});
	    		//alert(data);
	    		 myChart.setOption({
		    			 title: {
		    				text: '年龄段统计',
		    				left:'right'
		    			 },
		    			 legend:{
		    				 data:['年龄']	    			
		    			 },
		    			 xAxis:{
		    				 data:arName
		    			 },
		    			 yAxis:{},
		    			 series:[{
		    				 name:'年龄',
		    				 type:'line',
		    				 data:arAge
		    			 }]
	    		 });
	    		 
	    	 });
	    	
	     })
	 </script>
</head>

<body>
    <div id="main" style="width: 100%;height:800px;"></div>
</body>
</html>