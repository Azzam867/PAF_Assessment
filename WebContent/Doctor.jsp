<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Doctor"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/doctor.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">

				<h1>Doctor Details</h1>

				<form id="formItem" name="formItem">

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">doctorid: </span>
						</div>
						<input id="doctorid" name="doctorid" type="text"
							class="form-control form-control-sm">
					</div>
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">doctorname: </span>
						</div>
						<input id="doctorname" name="doctorname" type="text"
							class="form-control form-control-sm">
					</div>
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">email: </span>
						</div>
						<input id="email" name="email" type="text"
							class="form-control form-control-sm">
					</div>
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">

							<span class="input-group-text" id="lblName">specialist: </span>
						</div>
						<input id="specialist" name="specialist" type="text"
							class="form-control form-control-sm">
					</div>
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">

							<span class="input-group-text" id="lblName">phone: </span>
						</div>
						<input id="phone" name="phone" type="text"
							class="form-control form-control-sm">
					</div>
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend"></div>

					</div>





					<input id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>

				<div id="alertError" class="alert alert-danger"></div>


			</div>
			<div class='col-12'>
				<div id="divItemsGrid">

					<%
					Doctor DoctorObj=new Doctor();
					out.print(DoctorObj.getDoctor());
					%>
				</div>

			</div>
		</div>
	</div>

</body>
</html>