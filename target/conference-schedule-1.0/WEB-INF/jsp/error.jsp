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
			
			<h2 class="errorArea"> 
				Something went wrong! 
				<c:if test="${errorText}">
					<br/> ${errorText}
				</c:if>
			</h2>
			
		</div>
		
		<form:form action="/" method ="GET">		
			
			<div class="row">
			    <div class="col-lg-12">
			        
			            <button type="submit" class="btn btn-secondary">Home</button>
			        
			    </div>
			</div>
		
		</form:form>
		
	</div>
	
</body>

</html>
