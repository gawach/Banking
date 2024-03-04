<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
<head>
	<title><bean:message key="welcome.title"/></title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/stylesheets/welcome.css" type="text/css">
<html:base/>
</head>
<body bgcolor="white">

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">
    ERROR:  Application resources not loaded -- check servlet container
    logs for error messages.
  </font>
</logic:notPresent>

<h3><bean:message key="welcome.heading"/></h3>
<p><bean:message key="welcome.message"/></p>
<p class = "hello">Hello, World!</p>
<p><html:link page="/pages/login.jsp">login</html:link></p>

<%-- コメントアウト --%>

</body>
</html:html>
