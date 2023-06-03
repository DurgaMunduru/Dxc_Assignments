<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String account = request.getParameter("account");
		String amount = request.getParameter("amount");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc","root","root");
			PreparedStatement stmt = conn.prepareStatement("insert into bank values(?,?)");
			stmt.setString(1, account);
			stmt.setString(2, amount);
			int i = stmt.executeUpdate();
			if(i>0) {
				out.println("Saved into database");
				out.println("<html><body>");
				%>
				<jsp:forward page="records.jsp"/>
				<% 
			}
			
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
%>
</body>
</html>