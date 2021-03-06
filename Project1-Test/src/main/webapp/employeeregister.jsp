<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
<nav class="navbar navbar-light navbar-expand-lg"  style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Employee Reimbursement System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active"  href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="register.jsp">Employee</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link active"  href="adminregister.jsp">Admin</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active"  href="registerreimb.jsp">Reimbursement Form</a>
        </li>
 
  
      </ul>
  
    </div>
  </div>
</nav>


 <div class="container">

 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
  
   
    <h2>Employee Register Form</h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/insertEmployee" method="post">
     <br>
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