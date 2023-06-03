<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Records</title>
</head>
<body>
<%
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc","root","root");
		String cmd1 ="select * from data";
		String cmd2 ="select * from bank";
		PreparedStatement pst1=conn.prepareStatement(cmd1);
		PreparedStatement pst2=conn.prepareStatement(cmd2);
		ResultSet rs1=pst1.executeQuery();
		ResultSet rs2=pst2.executeQuery();
		while(rs1.next()){
			out.println("Name: "+rs1.getString("Username"));
			out.println("Password: "+rs1.getString("password"));
		%>
		<br>
		<% 
	}
		while(rs2.next()){
			out.println("Account Number: "+rs2.getString("account"));
			out.println("Amount: "+rs2.getString("amount"));
		%>
		<br>
		<%
		
		}
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
</body>
</html>