<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Person Master Grid</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/themes/start/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/themes/start/jquery.ui.theme.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/ui.multiselect.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/themes/start/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css//ui.jqgrid.css" />

<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/bootstrap/select2.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css//personGrid.css" />
</head>
<body>
	<fieldset style="float: left; height: 510px; width: 1280px;"
		class="ui-widget-content ui-corner-all ui-jqgrid">
		<legend class="ui-widget-header ui-corner-top" style="font-size: 14px">Person
			Master</legend>
		<br>
		<br>
		<!-- Grid code starts here -->
		<div id='jqgrid' style="">
			<table id='myGrid'></table>
			<div id='pager'></div>
		</div>
		<!-- Grid code ends here -->
		<div id='msgbox' title='' style='display: none'></div>
	</fieldset>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.16.custom.min.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/ui.multiselect.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/i18n/grid.locale-en.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/i18n/grid.locale-en.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/i18n/grid.locale-en.js" /></script>

	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery.jqGrid.min.js" /></script>

	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput-1.3.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/bootstrap/select2.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/personMasterGrid-validations.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/personMasterGrid.js" /></script>

</body>
</html>