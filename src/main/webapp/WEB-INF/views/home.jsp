<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript"
	src="resources/script/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div id="tasks"></div>
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				url : "http://localhost:8080/tasktracker_web/tasks/",
				type : "GET",
				dataType: 'json',
				success : function(data) {
					for( var i = 0; i < data.length; i++) {
						var task = data[i];
						$("#tasks").append("<div id='" +  task.id + "' class='task'><br><span id='title'>" + task.title + "</span><br>" + "<span id='description'>" + task.description + "</span><br></div>");
					}
				}
			});
		});
	</script>
</body>
</html>
