<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.cuspycode.jpaddl.JPALifecycleListener" %>
<%@ page import="com.cuspycode.jpaddl.Customer" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.EntityTransaction" %>
<%
	EntityManager em = JPALifecycleListener.createEntityManager();

	// Add a customer

	Customer c = new Customer();
	c.setName("Carol");
	c.setEmail("carol@example.com");
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(c);
	tx.commit();
%>
<html>
<head><title>JPA-DDL Example</title></head>
<body>
<h1>JPA-DDL Example</h1>

<%
	for (int i=1; i<10; i++) {
	    Customer x = em.find(Customer.class, (long) i);
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
