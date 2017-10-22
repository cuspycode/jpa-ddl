<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.cuspycode.jpaddl.Customer" %>
<%@ page import="com.cuspycode.jpaddl.Bean" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.persistence.EntityManager" %>
<%
        Context ctx = new InitialContext();
        Bean bean = (Bean) ctx.lookup("java:global/jpa-ddl-ee/Bean");

	// Add a customer
	bean.addCustomer("Carol", "carol@example.com");
%>
<html>
<head><title>JPA-DDL Example</title></head>
<body>
<h1>JPA-DDL Example</h1>

<%
	for (int i=1; i<10; i++) {
	    Customer x = bean.getCustomer(i);
	    if (x == null) break;
%>
<p>
<%= x.getId() %>, <%= x.getName() %>, <%= x.getEmail() %>
</p>
<%
	}
%>
</body>
</html>
