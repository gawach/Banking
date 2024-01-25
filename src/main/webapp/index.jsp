<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h1>Hello World!</h1>

<bean:define id="uv" name="user_view" type="com.oreilly.struts.banking.view.UserView" />
<p><bean:write name="uv" property="name"/></p>
<p><bean:write name="uv" property="balance"/></p>


<%--

Redirect default requests to Welcome global ActionForward.
By using a redirect, the user-agent will change address to match the path of our Welcome ActionForward. 

--%>
