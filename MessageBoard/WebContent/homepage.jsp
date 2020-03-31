<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message Board Homepage</title>
</head>
<body style="text-align: center">
	<h2>Welcome to the Message Board</h2>
	<h4>The current time and date is:</h4><br>
	<% out.print(LocalDateTime.now()); %><br>
	<p>Check out the chat</p>
	<form action="./MessageBoard">
		<input type="submit" value="Enter the Chat"/>
	</form>
</body>
</html>