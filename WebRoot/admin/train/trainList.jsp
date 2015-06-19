<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function trainDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/train?type=trainDel&id="+id;
               }
           }
           
           function trainAdd()
           {
                 var url="<%=path %>/admin/train/trainAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="center" bgcolor="#FAFAF1" height="22">
				  <td width="33%">培养方案代码</td>
					<td width="33%">培养方案名称</td>
					<td width="33%">培养方案介绍</td>
					<td width="33%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.trainList}" var="train">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				  <td bgcolor="#FFFFFF" align="center">${train.trainProId}</td>
					<td bgcolor="#FFFFFF" align="center">
						${train.trainProName}					</td>
					<td bgcolor="#FFFFFF" align="center">
						${train.trainProPresent}					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/train/trainEditPre.jsp" method="post" name="form1">
							<input type="button" value="删除" onclick="trainDel(${train.trainProId})"/>
							
							<input type="hidden" name="name" value="${train.trainProName}"/>
				            <input type="hidden" name="jieshao" value="${train.trainProPresent}"/>
				            <input type="hidden" name="id" value="${train.trainProId}"/>
				            <input type="submit" value="编辑"/>
			            </form>					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>  
			        <input type="button" value="添加" style="width: 80px;" onclick="trainAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
