<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html:html>
	<head>
		<html:base/>
		<title><bean:message key="title.login" /></title>
		<link rel="stylesheet" href="stylesheets/login_style.css" type="text/css">
	</head>
	<body topmargin="0" leftmargin="5" marginheight="0" marginwidth="0" bgcolor="#6699FF">
		<html:form action="login" focus="accessNumber">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#6699FF">
				<tr>
					<td>
						<html:img srcKey="image.logo" width="79" height="46" altKey="image.logo.alt" border="0"/>
					<td/>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td bgcolor="#000000">
						<table border="0" cellpadding="0" cellspacing="0" width="1" height="2"></table>
					</td>
				</tr>
				<table border="0" cellpadding="0" cellspacing="0" width="1" height="1">
					<tr>
						<td></td>
					</tr>
				</table>
				<table>
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="590">
					<tr>
						<td width="15" height="31"></td>
						<td width="12"></td>
					</tr>
					<tr>
						<td width="575" bgcolor="#FFFFFF" colspan="2">
							<table cellpadding="0" cellspacing="0" border="0" width="575" height="3">
								<tr>
									<td></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="590" bgcolor="#ffffff">
					<tr>
						<td width="15" bgcolor="#6699FF"></td>
						<td width="15"></td><td width="379"></td>
						<td width="15"></td>
						<td width="15"></td>
						<td width="15"></td>
					</tr>
					<tr>
						<td bgcolor="#6699FF" width="15"></td>
						<td></td>
						<td valign="top">
							<table border="0" cellpadding="0"cellspacing="0">
								<tr class="fieldlabel">
									<td><bean:message key="label.accessnumber"/></td>
								</tr>
								<tr class="fieldlabel">
									<td><html:text property="accessNumber" size="9" maxlength="9"/></td>
									<td class="error"><html:errors/></td>
								</tr>
								<tr class="fieldlabel"><td height="10"></td></tr>
								<tr class="fieldlabel"><td><bean:message key="label.pinnumber"/></td></tr>
								<tr class="fieldlabel">
									<td><html:password property="pinNumber" size="4" maxlength="4"/></td>
								</tr>
								<tr><td height="10"></td></tr>
								<tr><td><html:submit styleClass="fieldlabel" value="Login"/></td></tr>
								<tr><td></td></tr>
							</table>
						</td>
						<td width="151" valign="top">
							<html:img srcKey="image.strutspower" altKey="image.strutspower.alt"/>
						</td>
					</tr>
				</table>
				<%@include file="include/footer.jsp"%>
				<br>
			</table>
		</html:form>
	</body>
</html:html>