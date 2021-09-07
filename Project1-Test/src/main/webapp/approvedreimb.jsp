<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Reimbursement</title>

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

    <h2>Reimbursement Register Form</h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/update" method="post">

  	<div class="form-group">
       <label for="uname">ID:</label> <input type="text"
        class="form-control" id="id" placeholder="ID"
        name="id" required>
      </div>
      
      <div class="form-group">
       <label for="uname">Amount:</label> <input type="text"
        class="form-control" id="amount" placeholder="Amount"
        name="amount" required>
      </div>

      <div class="form-group">
       <label for="uname">Author:</label> <input type="text"
        class="form-control" id="author" placeholder="Name"
        name="author" required>
      </div>

      <div class="form-group">
       <label for="uname">Description:</label> <input type="text"
        class="form-control" id="description" placeholder="description"
        name="description" required>
      </div>
      
    <div class="form-group">
       <label for="uname">Status:</label> 
       <select class="form-select" name = "status"  id="status">
       <option selected></option>
       <option value = "APPROVED"> APPROVED</option>
       <option value = "DECLINED"> DECLINED</option>
       </select>
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



      <button type="submit" class="btn btn-primary">Submit</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>