<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/context/base/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/context/base/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/context/base/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/context/base/themes/default/easyui.css">
<title>首页</title>
<script type="text/javascript">
$(function(){
	/*$.post('/ssm/User/getMoudle',null,function(data){
	    $.each(data, function (i, n) {
            $('#sysmenu').accordion('add', {
                title: n.m_name,
                //click:GetSmallMenu(n.MenuID,n.MenuName),
                //iconCls: 'icon-menu-' + n.MenuImg.replace(new RegExp('.png'), ''),
                selected: false,
                content: '<div style="padding:10px;" name="' + n.m_name + '"><p id="'+n.m_id+'"></p></div>'
            });
        });
		      });*/
	$("#btntest").click(function() {
		$.ajax({
			url:"/ssm/User/getMoudle",
			type:"post",
			success:function(result)
			{
				alert(result);
			}
		});
	});	      
	
})
	function addTab(title, url) {
		if ($('#tt').tabs('exists', title)) {
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'
					+ url + '" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add', {
				title : title,
				content : content,
				closable : true
			});
		}
	}
	function getMoudle()
	{
		$.post('/ssm/User/getMoudle',null,function(data){
		    $.each(data, function (i, n) {
                $('#sysmenu').accordion('add', {
                    title: n.m_name,
                    click:GetSmallMenu(n.m_name,n.m_id),
                    //iconCls: 'icon-menu-' + n.MenuImg.replace(new RegExp('.png'), ''),
                    selected: false,
                    content: '<div style="padding:10px;" name="' + n.m_name + '"><p id="'+n.m_id+'"></p></div>'
                });
            });
			      });
		
	}
	function GetSmallMenu(mname,moudleid) {
		$.post('/ssm/User/getSubMoudle',{moudleid:moudleid},function(data){
		    var ahtml = '<ul name="' + mname + '">';
			$.each(data,function(i,n){
				 ahtml += '<li><div class="selected"><a href="#" onclick=addTab("'+n.m_name+'","'+n.m_url+'")>'+n.m_name+'</a></div></li>';
			});
			ahtml += '</ul>';
		    $('p[id=' + moudleid+']').append(ahtml);
		});
       /* $.ajax({
            type: "GET",
            dataType: "json",
            url: '/Ajax/GetMenuList.ashx?Type=SmallMenu&PName=' + escape(mname),
            success: function (data) {
                var ahtml = '<ul name="' + mname + '">';
                $.each(data, function (i, n) {
                    ahtml += '<li><div class="selected"><a href="'+n.m_url+'"><span class="icon-nav icon"></span>'+n.MenuName+'</a></div></li>';
                    //ahtml += '<li onclick="OpenMenuUrl(' + n.MenuID + ')" title="' + n.MenuName + '">' + n.MenuName + '</li>';
                });
                ahtml += '</ul>';
//                alert(ahtml);
                //$("#"+mid).html(ahtml);
                $('p[id=' + mid+']').append(ahtml);
            }
        });*/
    }
	
</script>
</head>
<body class="easyui-layout" style="width: 100%" onload="getMoudle();">
	<form id="loginform" action="Test">
		<div data-options="region:'north'" style="height: 60px">
			<div style="text-align: right">${sessionScope.username} 欢迎您 </div>
			<div style="text-align: right">
				<input type="search" style="width: 120px" /> <input type="submit"
					id="btnsubmit" value="搜索" />
					<input type="button" id="btntest" name="btntest" value="test">
					<input type="button" id="test2" name="test2" value="test2">
			</div>
		</div>


		<div data-options="region:'west'" title="菜单" style="width: 15%;">

			 <div class="easyui-accordion" id="sysmenu">
				 <!--  <div title="主页" style="overflow: auto; padding: 10px;">
					<a href="#" style="width: 100%"
						onclick="addTab('repair','/Custservice/Repair')">报修</a>
				</div>
				<div title="系统管理" style="padding: 10px;"></div>
				 <div title="客服" style="padding: 10px">
					<a href="#" style="width: 100%"
						onclick="addTab('百度','http://www.baidu.com')">百度</a>
				</div>-->
			</div>
		</div>
		<div id="tt" class="easyui-tabs" data-options="region:'center'">
		</div>

	</form>
</body>
</html>