<%@page import="com.vishnu.web.model.User"%>
<%@page import="com.vishnu.web.model.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=text], select, textarea {
    width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=date] {
	width: 17%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	width:400px;
	border-radius: 2px;
	background-color: #f2f2f2;
	padding: 10px;
}

.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}

.dropdown-menu.notify-drop {
	min-width: 330px;
	background-color: #fff;
	min-height: 360px;
	max-height: 360px;
}

.dropdown-menu.notify-drop .notify-drop-title {
	border-bottom: 1px solid #e2e2e2;
	padding: 5px 15px 10px 15px;
}

.dropdown-menu.notify-drop .drop-content {
	min-height: 280px;
	max-height: 280px;
	overflow-y: scroll;
}

.dropdown-menu.notify-drop .drop-content::-webkit-scrollbar-track {
	background-color: #F5F5F5;
}

.dropdown-menu.notify-drop .drop-content::-webkit-scrollbar {
	width: 8px;
	background-color: #F5F5F5;
}

.dropdown-menu.notify-drop .drop-content::-webkit-scrollbar-thumb {
	background-color: #ccc;
}

.dropdown-menu.notify-drop .drop-content>li {
	border-bottom: 1px solid #e2e2e2;
	padding: 10px 0px 5px 0px;
}

.dropdown-menu.notify-drop .drop-content>li:nth-child(2n+0) {
	background-color: #fafafa;
}

.dropdown-menu.notify-drop .drop-content>li:after {
	content: "";
	clear: both;
	display: block;
}

.dropdown-menu.notify-drop .drop-content>li:hover {
	background-color: #fcfcfc;
}

.dropdown-menu.notify-drop .drop-content>li:last-child {
	border-bottom: none;
}

.dropdown-menu.notify-drop .drop-content>li .notify-img {
	float: left;
	display: inline-block;
	width: 45px;
	height: 45px;
	margin: 0px 0px 8px 0px;
}

.dropdown-menu.notify-drop .allRead {
	margin-right: 7px;
}

.dropdown-menu.notify-drop .rIcon {
	float: right;
	color: #999;
}

.dropdown-menu.notify-drop .rIcon:hover {
	color: #333;
}

.dropdown-menu.notify-drop .drop-content>li a {
	font-size: 12px;
	font-weight: normal;
}

.dropdown-menu.notify-drop .drop-content>li {
	font-weight: bold;
	font-size: 11px;
}

.dropdown-menu.notify-drop .drop-content>li hr {
	margin: 5px 0;
	width: 70%;
	border-color: #e2e2e2;
}

.dropdown-menu.notify-drop .drop-content .pd-l0 {
	padding-left: 0;
}

.dropdown-menu.notify-drop .drop-content>li p {
	font-size: 11px;
	color: #666;
	font-weight: normal;
	margin: 3px 0;
}

.dropdown-menu.notify-drop .drop-content>li p.time {
	font-size: 10px;
	font-weight: 600;
	top: -6px;
	margin: 8px 0px 0px 0px;
	padding: 0px 3px;
	border: 1px solid #e2e2e2;
	position: relative;
	background-image: linear-gradient(#fff, #f2f2f2);
	display: inline-block;
	border-radius: 2px;
	color: #B97745;
}

dropdown-menu.notify-drop .drop-content>li p.time:hover {
	background-image: linear-gradient(#fff, #fff);
}

.dropdown-menu.notify-drop .notify-drop-footer {
	border-top: 1px solid #e2e2e2;
	bottom: 0;
	position: relative;
	padding: 8px 15px;
}

.dropdown-menu.notify-drop .notify-drop-footer a {
	color: #777;
	text-decoration: none;
}
.dropdown-menu.notify-drop .notify-drop-footer a:hover {
	color: #333;
}
.medium{
	width:100px
}
.dropdown-toggle .badge {
  position: absolute;
  right: 2px;
  top:1px;
  padding: 5px 10px;
  border-radius: 50%;
  background-color: red;
  color: white;

}
.notify{
	color:white !important;
	font-size: 1.5em !important;
	line-height: 0.9em !important;
	
}
.contain{
	width:1060px;
}
.changes{
	margin-left:10px;
}
.dochanges{
	margin-left:720px;
}
.column {
  float: left;
  padding: 10px;
  height: 700px; 
}
.center{
	width:2%;
	background-color:white;
}
.left {
  width: 18%;
	background-color: #f2f2f2;
  height:1000%;
}

.right {
  width: 80%;
  	background-color: #f2f2f2;
  	margin-rigth:200px;
}
.rows:after {
  content: "";
  display: table;
  clear: both;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

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

<jsp:useBean id="books" type="java.util.List" scope="session"></jsp:useBean>
<jsp:useBean id="user" class="com.vishnu.web.model.User" scope="session"></jsp:useBean>
	
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header"></div>
		<ul class="nav navbar-nav navbar-left">
			<span style="font-size: 30px; cursor: pointer; color: grey;"
				onclick="openNav()">&#9776;</span>
			<div id="mySidenav" class="sidenav">
			    <a href="javascript:void(0)" class="closebtn" id="closeNav" onclick="closeNav()">&times;</a>
				<h3 style="color: white;">Hai ${user.getName() }</h3>
				<a id="dashboardController" href="dashboardController">DashBoard</a>
				<a id="noteBookView" href="notebooks">NoteBooks</a> 
				<a id="listOfNotes" href="notecontroller?uid=${user.getID()}">AllNotes</a> 
				<a id="editUser" href="editUser?name=<%=user.getName() %>">Edit User</a>
			</div>

		</ul>
		<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h4 class="modal-title w-100 font-weight-bold">EDIT NOTE</h4>
			</div>
			<div class="modal-body mx-3">
			<form action="notecontroller?action=edit" method="post" onsubmit="return validateNoteForm()">
						 
						<input type="hidden" name="noteId" value="<%=note.getNoteId() %>">
						<input type="hidden" name="nid" value="<%=note.getBookId() %>">
                        
                        <label for="noteName">NoteName</label> 
                        <p id="noteName_error" style="display: none; color: red;">NoteName should not be empty</p>
						<input type="text" id="noteName" name="noteName" value="<%=note.getNoteName() %>" >

						<label for="startDate">StartDate</label> 
						  <p id="sDate_error" style="display: none; color: red;">StartDate should not be empty</p>
						<input type="date" id="startDate" name="startDate" value="<%=note.getStartDate() %>">
						
					   <label for="endDate">EndDate</label> 
					    <p id="eDate_error" style="display: none; color: red;">EndDate should not be empty</p>
					   <input type="date" id="endDate" name="endDate" value="<%=note.getEndDate() %>"> 
					   
					   <label for="remainderDate">RemainderDate</label>
					    <p id="rDate_error" style="display: none; color: red;">ReminderDate should not be empty</p>
						<input type="date" id="remainderDate" name="remainderDate"value="<%=note.getReminderDate() %>" ><br>
						
					   <label for="statusName">Status</label>
					   <p id="status_error" style="display: none; color: red;">Status should not be empty</p>
					    <select id="statusName"name="statusName" >
							<option value="started">Started</option>
							<option value="inProgress">InProgress</option>
							<option value="complete">Complete</option>
						</select> 
					   <label for="tagName">Tag</label> 
					   <p id="tag_error" style="display: none; color: red;">TagName should not be empty</p>
					   <select id="tagName"name="tagName" >
							<option value="private">Private</option>
							<option value="public">Public</option>
						</select> 
						<label for="noteDescription">Description</label>
						<p id="noteDescription_error" style="display: none; color: red;">NoteDescription should not be empty</p>
						<textarea id="noteDescription" name="noteDescription"
							value="<%=note.getDescription() %>" style="height: 200px" ></textarea>
						
						<center>
						
						<input type="button" value="Go back!" onclick="history.back()">
						<input type="submit" id="submit" value="update" name="action">
						
					</center>
					</form>
				
		</div>
	</div>
	</div>
	</nav>
    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
        function validateNoteForm() {
            var flag = true;
            var noteName = document.getElementById("noteName").value;
            var startDate = document.getElementById("startDate").value;
            var endDate = document.getElementById("endDate").value;
            var reminderDate= document.getElementById("remainderDate").value;
            var status= document.getElementById("statusName").value;
            var tag= document.getElementById("tagName").value;
            var noteDescription= document.getElementById("noteDescription").value;
            if (noteName == "") {
                flag = false;
                document.getElementById("noteName_error").style.display = 'block';
            }
            else{
                document.getElementById("noteName_error").style.display = 'none';
            }
            
            if (startDate == "") {
                flag = false;
                document.getElementById("sDate_error").style.display = 'block';
            }
            else{
                document.getElementById("sDate_error").style.display = 'none';
            }
            
            if (endDate == "") {
                flag = false;
                document.getElementById("eDate_error").style.display = 'block';
            }
            else{
                document.getElementById("eDate_error").style.display = 'none';
            }
            
            if (reminderDate == "") {
                flag = false;
                document.getElementById("rDate_error").style.display = 'block';
            }
            else{
                document.getElementById("rDate_error").style.display = 'none';
            }

            if (status == "") {
                flag = false;
                document.getElementById("status_error").style.display = 'block';
            }
            else{
                document.getElementById("status_error").style.display = 'none';
            }
            
            if (tag == "") {
                flag = false;
                document.getElementById("tag_error").style.display = 'block';
            }
            else{
                document.getElementById("tag_error").style.display = 'none';
            }
            
            if (noteDescription == "") {
                flag = false;
                document.getElementById("noteDescription_error").style.display = 'block';
            }
            else{
                document.getElementById("noteDescription_error").style.display = 'none';
            }
            return flag;
        }
    </script>
</body>
</html>
