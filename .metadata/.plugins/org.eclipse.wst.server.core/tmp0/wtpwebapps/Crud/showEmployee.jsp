<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.tap.acad.model.employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Designation</th>
<th>Salary</th>
<th>Email</th>
<th>Password</th>
</tr>
<%!ArrayList<employee> empList; %>
<% empList=(ArrayList<employee>)session.getAttribute("empList");
for(employee e:empList){ %>
<tr>
<td><% out.println(e.getEmpid());%></td>
<td><% out.println(e.getEmpname());%></td>
<td><%out.println(e.getDesig()); %></td>
<td><%out.println(e.getSalary()); %></td>
<td><%out.println(e.getEmail()); %></td>
<td><% out.println(e.getPassword());%></td>

</tr>
<%} %>

<!-- out.println(empList); -->
</table>
</center>
</body>
</html>