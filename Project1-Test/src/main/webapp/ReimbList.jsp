<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>

<script>
function sortTableByColumn(table, column, asc = true) {
    const dirModifier = asc ? 1 : -1;
    const tBody = table.tBodies[0];
    const rows = Array.from(tBody.querySelectorAll("tr"));

    // Sort each row
    const sortedRows = rows.sort((a, b) => {
        const aColText = a.querySelector(`td:nth-child(${ column + 1 })`).textContent.trim();
        const bColText = b.querySelector(`td:nth-child(${ column + 1 })`).textContent.trim();

        return aColText > bColText ? (1 * dirModifier) : (-1 * dirModifier);
    });

    // Remove all existing TRs from the table
    while (tBody.firstChild) {
        tBody.removeChild(tBody.firstChild);
    }

    // Re-add the newly sorted rows
    tBody.append(...sortedRows);

    // Remember how the column is currently sorted
    table.querySelectorAll("th").forEach(th => th.classList.remove("th-sort-asc", "th-sort-desc"));
    table.querySelector(`th:nth-child(${ column + 1})`).classList.toggle("th-sort-asc", asc);
    table.querySelector(`th:nth-child(${ column + 1})`).classList.toggle("th-sort-desc", !asc);
}

document.querySelectorAll(".table-sortable th").forEach(headerCell => {
    headerCell.addEventListener("click", () => {
        const tableElement = headerCell.parentElement.parentElement.parentElement;
        const headerIndex = Array.prototype.indexOf.call(headerCell.parentElement.children, headerCell);
        const currentIsAscending = headerCell.classList.contains("th-sort-asc");

        sortTableByColumn(tableElement, headerIndex, !currentIsAscending);
    });
});
</script>

<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
    
<meta charset="ISO-8859-1">
<style>
    th{ 
        color:darkblue;
            }
            .table-sortable th {
  cursor: pointer;
}

.table-sortable .th-sort-asc::after {
  content: "\25b4";
}

.table-sortable .th-sort-desc::after {
  content: "\25be";
}

.table-sortable .th-sort-asc::after,
.table-sortable .th-sort-desc::after {
  margin-left: 5px;
}

.table-sortable .th-sort-asc,
.table-sortable .th-sort-desc {
  background: rgba(0, 0, 0, 0.1);
}
</style>
<title>Reimbursement List</title>
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

<form method="post">
<table class="table table-striped table-sortable">
<thead>
    <tr>
        <th>ID</th>
        <th>Amount</th>
        <th>Author</th>
        <th>Description</th>
        <th>Type</th>
        <th>Submitted</th>
        <th>Resolved</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
   </thead>
    <%
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost/project1main";
    String username="root";
    String password="Colormemine";
    String query="select * from reimbursement";
    Connection conn=DriverManager.getConnection(url,username,password);
    Statement stmt=conn.createStatement();
    ResultSet rs=stmt.executeQuery(query);
    while(rs.next())
    {

    %>
        <tr><td><%=rs.getInt("id")%></td>
        <td><%=rs.getDouble("amount")%></td>
        <td><%=rs.getString("author")%></td>
          <td><%=rs.getString("description")%></td>
           <td><%=rs.getString("type")%></td>
            <td><%=rs.getTimestamp("submitted")%></td>
             <td><%=rs.getTimestamp("resolved")%></td>
              <td><%=rs.getString("status")%></td>
              <td><a class="btn btn-link" href="approvedreimb.jsp" role="button">Edit</a><br>
              <a class="btn btn-link" href="delete.jsp" role="button">Delete</a></td></tr>
            <%

    }
    %>
    </table>
    
	<%
		rs.close();
		stmt.close();
		conn.close();
    	}
	catch(Exception e)
	{
	    e.printStackTrace();
	    }
	%>

</form>

</body>
</html>
