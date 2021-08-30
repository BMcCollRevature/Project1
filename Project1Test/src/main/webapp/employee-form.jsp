<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Project 1: Expense Reimbursement System </title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update" method="post"></form>
				</c:if>
				<c:if test="${employee == null}">
					<form action="insert" method="post"></form>
				</c:if>

				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Username</label> <input type="text"
						value="<c:out value='${employee.username}' />" class="form-control"
						name="username" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Password</label> <input type="text"
						value="<c:out value='${employee.password}' />" class="form-control"
						name="password"required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee First Name</label> <input type="text"
						value="<c:out value='${employee.firstname}' />" class="form-control"
						name="firstname"required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Last Name</label> <input type="text"
						value="<c:out value='${employee.lastname}' />" class="form-control"
						name="lastname"required="required">
				</fieldset>
				
					<fieldset class="form-group">
					<label>Employee Email</label> <input type="text"
						value="<c:out value='${employee.email}' />" class="form-control"
						name="email"> 
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>