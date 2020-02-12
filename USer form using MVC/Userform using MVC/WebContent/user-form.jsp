<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: red">
			

			
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
				<c:if test="${user == null}">
					<form action="UserDAO" method="post">
				</c:if>

				<caption>
					<h2>
						
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

		
				<fieldset class="form-group">
					<label>ID</label> <input type="text"
						value="<c:out value='${user.id}' />" class="form-control"
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name">
				</fieldset>
				
				<fieldset class="form-group">
					<label>address</label> <input type="text"
						value="<c:out value='${user.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Phone no</label> <input type="text"
						value="<c:out value='${user.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<fieldset class="form-group">
					<label>salary</label> <input type="text"
						value="<c:out value='${user.salary}' />" class="form-control"
						name="salary">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>net</label> <input type="text"
						value="<c:out value='${user.net}' />" class="form-control"
						name="net">
				</fieldset>
				<fieldset class="form-group">
					<label>total</label> <input type="text"
						value="<c:out value='${user.total}' />" class="form-control"
						name="total">
				</fieldset>
				
				

				<button type="submit" class="btn btn-success" name="/insert"
				 value="/insert">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
