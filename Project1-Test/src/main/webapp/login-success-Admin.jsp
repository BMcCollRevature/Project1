<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Success</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="#">Employee Reimbursement System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employeeregister.jsp">Employee</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="adminregister.jsp">Admin</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="registerreimb.jsp">Reimbursement Form</a>
      </li>
    </ul>
  </div>
</nav>
 <div align="center">
        <h1>You have logged in successfully</h1>
        <br>
        <a class="btn btn-link" href="ReimbList.jsp" role="button">View Reimbursements</a>
        <br>
    	<a class="btn btn-link" href="test.jsp" role="button">Update Employee</a>
    </div>
    
    
    
</body>
</html>