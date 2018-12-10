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
		</div>

		
		<hr/>
		
		<div class="panel panel-default" id="tablePanel">
			<div class="panel-heading">Scheduled Conferences</div>
			
			<c:set var="index">1</c:set>
			
			
			
			<c:forEach var="item" items="${tracks}">
	
				
				<table class="table">
			  		<thead>
						<tr>
			        		<th>Track ${item.number} - Conference Name</th>
			      		</tr>
			    	</thead>
			    	<tbody>
			    		<c:forEach var="itemConf" items="${item.conferenceList}">
			    			<tr><td><c:out value="${itemConf}"/></td></tr>
			    		</c:forEach>
			    	</tbody>
			  	</table>
				
				<hr/>
				
			</c:forEach>
			
			
			
			
		</div>
		
		<form:form action="/" method ="GET">		
			
			<div class="row">
			    <div class="col-lg-12">
			        <div class="text-right">
			            <button type="submit" class="btn btn-secondary">Back</button>
			        </div>
			    </div>
			</div>
		
		</form:form>		

	</div>
	
</body>

</html>
