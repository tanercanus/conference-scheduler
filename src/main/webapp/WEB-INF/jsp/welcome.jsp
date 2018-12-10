<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="javascript:void(0);">Conference Schedule</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Welcome Schedule Confecence Application</h1>
			<h2 class="elementHide errorArea"></h2>
			<p>Enter confecence and click add button</p>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Architecting Your Codebase 60min" id="addInput"> 
					<span class="input-group-btn">
						<button class="btn btn-default" id="addButton" type="button">Add</button>
					</span>
				</div>
			</div>

		</div>
		
		<hr/>
		
		<div class="panel panel-default" id="tablePanel">
		  <!-- Default panel contents -->
		  <div class="panel-heading">Added Conferences</div>
		  <div class="panel-body">
		    <p>You can see added conferences below.</p>
		  </div>
		
		  <!-- Table -->
		  <table class="table" id="addTable">
		  	<thead>
		      <tr>
		        <th>Conference Name</th>
		        <th>Time</th>
		        <th>Action</th>
		      </tr>
		    </thead>
		    <tbody>
		    </tbody>
		  </table>
		</div>
		
		<form:form action="/postInput" method ="POST" modelAttribute="submitBean">
		
			<form:input path="postInput" id="postInput" cssClass="elementHide"/>
						
			<div class="row">
			    <div class="col-lg-12">
			        <div class="text-right">
			            <button type="submit" id="submitButton" disabled class="btn btn-primary">Submit</button>
			        </div>
			    </div>
			</div>
		
		</form:form>
		
		

	</div>
	
	<script src="/js/welcome.js"></script>
</body>

</html>
