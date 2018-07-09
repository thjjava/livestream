<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/comm/ContextPath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>视频直播管理系统</title>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.min.js"></script>
		<style>
			tr{
				line-height:30px;
			}
		
			.input01{
				height:30px;
				width:200px;
			}
			span{
				color:red;
				font-size:14px;
			}
		</style>
		<script>
			function getLicense(){
				var comName = $("#comName").val();
				var devNum = $("#devNum").val();
				if(comName == ""){
					alert("企业名称不能为空!");
					return;
				}
				if(devNum == ""){
					alert("设备数不能为空!");
					return;
				}
				if(!checkNum(devNum)){
					alert("请输入数字!");
					return;
				}
				if(!checkRate(devNum)){
					alert("请输入正整数!");
					return;
				}
				$("#license").html("");
				$.post("<%=path%>/company_getLicense.do",{"comName":comName,"devNum":devNum},function(data){
					var html = "<hr>"+data;
					$("#license").html(html);
				})
				
			}
			
			/**
			*判断字符串是否为数字 
			*/
			function checkNum(input){  
				if (!isNaN(input)){  
					return true;  
				}else{
					return false;
				}  
			} 
			
			/**
			*判断正整数  
			*/
			function checkRate(input){  
			     var g = /^[1-9]*[1-9][0-9]*$/;
    			 return g.test(input);
			} 
		</script>
	</head>
	<body style="background-color: #f3f3f4;margin: 0 0 0 0;">
		<div style="width: 100%;height: auto;text-align: center;">
			<span style="color:red;margin-left:-8%;">注:创建License需要填写正确的企业名称和设备数，设备数必须是正整数</span>
			<table style="margin-left:30%;margin-top:50px;">
				<tr>
					<td align="right">企业名称：</td>
					<td><input type="text" id="comName" class="input01" /></td>
				</tr>
				<tr>
					<td align="right">设备数：</td>
					<td><input type="text" id="devNum" class="input01" /></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td><input type="button" id="submit" value="创建" onclick="getLicense();"/></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td><span id="license"></span></td>
				</tr>
			</table>
		</div>
	</body>
</html>
