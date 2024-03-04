<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html:html>
	<head>
		<html:base/>
		<title><bean:message key="title.login" /></title>
		<link rel="stylesheet" href="stylesheets/login_style.css" type="text/css">
	</head>
	<body>
	
		<html:form action="login" focus="accessNumber">
			<table>
				<tr class="fieldlabel">
					<td><bean:message key="label.accessnumber"/></td>
				</tr>
				<tr class="fieldlabel">
					<td><html:text property="accessNumber" size="9" maxlength="9"/></td>
					<td class="error"><html:errors/></td>
				</tr>
				<tr class="fieldlabel"><td><bean:message key="label.pinnumber"/></td></tr>
				<tr class="fieldlabel">
					<td><html:password property="pinNumber"/></td>
				</tr>
				<tr><td><html:submit styleClass="fieldlabel" value="Login"/></td></tr>
			</table>
		</html:form>
		
	</body>
</html:html>