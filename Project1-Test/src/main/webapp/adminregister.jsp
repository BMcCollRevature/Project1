<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

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


 <div class="container">

 <hr>
  <div class="row col-md-10 col-md-offset-3"> 

   <div class="card card-body">

    <h2>Admin Register Form</h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/insertAdmin" method="post">

      <div class="form-group">
       <label for="uname">User Name:</label> <input type="text"
        class="form-control" id="username" placeholder="User Name"
        name="username" required>
      </div>

      <div class="form-group">
       <label for="uname">Password:</label> <input type="password"
        class="form-control" id="password" placeholder="Password"
        name="password" required>
      </div>

      <div class="form-group">
       <label for="uname">First Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="First Name"
        name="firstname" required>
      </div>

      <div class="form-group">
       <label for="uname">Last Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="last Name"
        name="lastname" required>
      </div>

      <div class="form-group">
       <label for="uname">Email:</label> <input type="text"
        class="form-control" id="email" placeholder="Email"
        name="email" required>
      </div>



      <button type="submit" class="btn btn-primary">Submit</button>
	<a class="btn btn-link" href="login.jsp" role="button">Already have an account?</a>
     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>