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
           function kechengDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/kecheng?type=kechengDel&id="+id;
               }
           }
           
           function kechengAdd()
           {
                 var url="<%=path %>/admin/kecheng/kechengAdd.jsp";
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
					<td width="33%">名称</td>
					<td width="33%">介绍</td>
					<td width="33%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.kechengList}" var="kecheng">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${kecheng.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kecheng.jieshao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/kecheng/kechengEditPre.jsp" method="post" name="form1">
							<input type="button" value="删除" onclick="kechengDel(${kecheng.id})"/>
							
							<input type="hidden" name="name" value="${kecheng.name}"/>
							<input type="hidden" name="jieshao" value="${kecheng.jieshao}"/>
						    <input type="hidden" name="id" value="${kecheng.id}"/>
						    <input type="submit" value="编辑"/>
					    </form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="kechengAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
