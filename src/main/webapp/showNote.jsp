<!DOCTYPE html>
<%@page import="com.vishnu.web.model.Notes"%>
<%@page import="java.sql.Date" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>


<jsp:useBean id="notes" type="java.util.List" scope="session"></jsp:useBean>
<jsp:useBean id="dailyList" type="java.util.List" scope="session"></jsp:useBean>
<jsp:useBean id="reminderList" type="java.util.List" scope="session"></jsp:useBean>


<%
String id = request.getParameter("id");
System.out.println(id);
boolean flag = false;
Notes note = new Notes();	

for(int i=0; i<notes.size(); i++){
	note = (Notes)notes.get(i);
	if(String.valueOf(note.getNoteId()).equals(id)){
		flag = true;
		break;
	}
}

if(!flag){
	for(int i=0; i<dailyList.size(); i++){
		note = (Notes)dailyList.get(i);
		if(String.valueOf(note.getNoteId()).equals(id)){
			flag = true;
			break;
		}
	}
}

if(!flag){
	for(int i=0; i<reminderList.size(); i++){
		note = (Notes)dailyList.get(i);
		if(String.valueOf(note.getNoteId()).equals(id)){
			flag = true;
			break;
		}
	}
}

%>

<body>

	<div class="container">
		<h2>Note</h2>
		<table class="table table-striped">
			<tbody>
				<tr>
					<th>Name</th>
					<td><%=note.getNoteName() %></td>
				</tr>
				<tr>
					<th>StartDate</th>
					<td><%=note.getStartDate() %></td>
				</tr>
				<tr>
					<th>EndDate</th>
					<td><%=note.getEndDate() %></td>
				</tr>
				<tr>
					<th>RemainderDate</th>
					<td><%=note.getReminderDate() %></td>
				</tr>
				<tr>
					<th>Status</th>
					<td><%=note.getStatus() %></td>
				</tr>
				<tr>
					<th>Tag</th>
					<td><%=note.getTag() %></td>
				</tr>
				<tr>
					<th>Description</th>
					<td height="100px"><%=note.getDescription() %></td>
				</tr>
				
			</tbody>
		</table>
			<input type=button style="background-color:green; color:white" value="Back" onCLick="history.back()">
	</div>
    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
</body>
</html>
