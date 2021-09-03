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
          <a class="nav-link active"  href="reimbregister.jsp">Reimbursement Form</a>
        </li>
 
  
      </ul>
  
    </div>
  </div>
</nav>
<div class="container">
 <div class="row text-center" style="color: tomato;">

 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2>Reimbursement Form</h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/insertReimb" method="post">
     
      <div class="form-group">
       <label for="uname">Amount:</label> <input type="text"
        class="form-control" id="username" placeholder="Amount"
        name="amount" required>
      </div>

      <div class="form-group">
       <label for="uname">Author:</label> <input type="text"
        class="form-control" id="author" placeholder="Author"
        name="author" required>
      </div>

      <div class="form-group">
       <label for="uname">Description:</label> <input type="text"
        class="form-control" id="description" placeholder="Description"
        name="description" required>
      </div>

      <div class="form-group">
       <label for="uname">Resolved:</label> <input type="text"
        class="form-control" id="resolved" placeholder="Resolved"
        name="resolved" required>
      </div>

      <div class="form-group">
       <label for="uname">Status:</label> <input type="text"
        class="form-control" id="status" placeholder="Status"
        name="status" required>
      </div>

  <div class="form-group">
       <label for="uname">Submitted:</label> <input type="text"
        class="form-control" id="submitted" placeholder="Submitted"
        name="submitted" required>
      </div>
      
        <div class="form-group">
       <label for="uname">Type:</label>
       <select class="form-select" name = "type"  id="type">
       <option selected></option>
       <option value = "LODGING"> LODGING</option>
       <option value = "TRAVEL"> TRAVEL</option>
       <option value = "FOOD"> FOOD</option>
       <option value = "OTHER"> OTHER</option>
       
       </select>
       
      </div>
  

      <button type="submit" class="btn btn-primary">Submit Form</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>