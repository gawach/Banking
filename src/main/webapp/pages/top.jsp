<head>
  <%@include file="../include/head.jsp"%>
    
  <link rel="stylesheet" href="<%= request.getContextPath() %>/stylesheets/top.css" type="text/css">
</head>
<body>
  <%@include file="../include/header.jsp"%>
	<main>
		<bean:define id="uv" name="user_view" type="com.oreilly.struts.banking.view.UserView" />
		<p><bean:write name="uv" property="name"/></p>
		<p><bean:write name="uv" property="balance"/></p>
	</main>
	<%@include file="../include/footer.jsp"%>
</body>