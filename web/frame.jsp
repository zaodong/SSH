<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<frameset rows="80,*">
   <frame name="top" src="<%=basePath %>frame/top.jsp">
   <frameset cols="150,*" id="main">

      <frame src="<%=basePath %>frame/left.jsp"> 
     <frame name="right" src="<%=basePath %>frame/right.jsp">
   </frameset>
</frameset>