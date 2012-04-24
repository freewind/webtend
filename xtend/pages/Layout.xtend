package pages

import webtend.mvc.Page

class Layout extends Page {

	override handle() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}

	def context() {
		request.contextPath
	}

	def main(String title, =>CharSequence body) '''
	<!DOCTYPE html>

	<html ng-app>
	<head>
	<meta http-equiv=Content-Type content="text/html;charset=utf-8">
	<title>«title»</title>
	« headImports »
	</head>
	<body>
		<div id="header">
			<div class="container">
				<div class="title"><a href="@routes.Application.index">知博</a></div>
			</div>
		</div>
		« body.apply »
		<hr />
	</body>
	</html>
	'''

	def headImports() '''
	<!-- <link rel="stylesheet" media="screen" href='«context»/stylesheets/normalize.css'> -->
	<link rel="stylesheet" media="screen" href='«context»/stylesheets/bootstrap/bootstrap.min.css'>
	<link rel="stylesheet" media="screen" href='«context»/stylesheets/bootstrap/bootstrap-responsive.min.css'>
	<link rel="stylesheet" media="screen" href='«context»/stylesheets/markdown.css'>
	<link rel="shortcut icon" type="image/png" href='«context»/images/favicon.png'>
	<script src='«context»/javascripts/jquery-1.7.1.min.js' type="text/javascript"></script>
	<script src='«context»/javascripts/underscore-1.3.1.min.js' type="text/javascript"></script>
	<script src='«context»/javascripts/angular-1.0.0rc4.min.js' type="text/javascript"></script>
	<script src='«context»/javascripts/bootstrap.min.js' type="text/javascript"></script>
	<script src='«context»/javascripts/app.js' type="text/javascript"></script>
	'''

}
