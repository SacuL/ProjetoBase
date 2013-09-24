
<%
	session.invalidate();
	response.sendRedirect("welcome.xhtml?msg=You%20are%20logged%20out.");
%>