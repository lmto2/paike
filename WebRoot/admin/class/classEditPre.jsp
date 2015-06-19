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
           function majorAll()
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
               DWRUtil.addOptions("major_id",data,"majorId","majorName");
           }
           
           
           function check()
           {
               if(document.formAdd.major_id.value==0)
               { 
                   alert("请选择专业");
                   return false;
               }
               return true;
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/class?type=classEdit" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						  <td bgcolor="#FFFFFF" align="right">班级代码</td>
						  <td bgcolor="#FFFFFF" align="left"><input type="text" name="num" size="20" value="<%=request.getParameter("num") %>"/></td>
					   </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         名称：						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="name" size="20" value="<%=request.getParameter("name") %>"/>						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         专业：						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <table border="0">
							           <tr> 
							               <td>  
							                  <select name="major_id" id="major_id" onclick="majorAll()">
									              <option value="0">请选择专业</option>
									          </select>							               </td>
							               <td>
							                  <img id="indicatorm" src="<%=path %>/img/loading.gif" style="display:none"/>							               </td>
							           </tr>
							    </table>						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="id"  value="<%=request.getParameter("id") %>"/>
						       <input type="submit" value="提交" onclick="return check()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
