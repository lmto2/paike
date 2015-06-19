<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

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

<script type='text/javascript' src='<%=path %>/dwr/interface/loginServiceM.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
<script language="javascript">
		
function writeObj(obj){ 
    var description = ""; 
    for(var i in obj){   
        var property=obj[i];   
        description+=i+" = "+property+"\n";  
    }   
    //alert(description+"test1"); 
}
		  //wwwwwwwwwwwwwwwwwww读取专业
           var i=0;
           function roomtypeAll()
           {
               if(i==0)
               {
                   document.getElementById("indicatorm").style.display="block";
                   loginServiceM.majorAll(callbackm);
                   i=1;
               }
               
           }
           function callbackm(data)
           {
               document.getElementById("indicatorm").style.display="none";
			   //alert(typeof data);
			   //alert("test");
			   writeObj(data);
               DWRUtil.addOptions("type_id",data,"roomtypeId","roomtypeName");
           }
           
           
           function check()
           {
               if(document.formAdd.major_id.value==0)
               { 
                   alert("请选择教室类型");
                   return false;
               }
               return true;
           }
        </script>


	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/classroom?type=classroomAdd" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				       <tr align='center' bgcolor="#FFFFFF" onmousemove="javascript:this.bgColor='red';" onmouseout="javascript:this.bgColor='#FFFFFF';" height="22">
                         <td bgcolor="#FFFFFF" align="right"> 教室名称： </td>
				         <td bgcolor="#FFFFFF" align="left"><input type="text" name="name" size="20"/>                         </td>
			           </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						  <td bgcolor="#FFFFFF" align="right">教室类型：</td>
						  <td bgcolor="#FFFFFF" align="left">
<table border="0">
 <tr><td>  
 <select name="type_id" id="type_id" onclick="roomtypeAll()">
 <option value="0">请选择教室类型</option>
 </select>
 </td>
 <td><img id="indicatorm" src="<%=path %>/img/loading.gif" style="display:none"/></td>
</tr>
</table>
						  </td>
					   </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						  <td bgcolor="#FFFFFF" align="right">教室容量：</td>
						  <td bgcolor="#FFFFFF" align="left"><input type="text" name="volume" size="20"/></td>
					   </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
