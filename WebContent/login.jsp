<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ICM ADMIN PANEL</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="scripts/clockp.js"></script>
<script type="text/javascript" src="scripts/functions.js"></script>
<script type="text/javascript" src="scripts/clockh.js"></script>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/ddaccordion.js"></script>
<script type="text/javascript">
	ddaccordion.init({
		headerclass : "submenuheader", //Shared CSS class name of headers group
		contentclass : "submenu", //Shared CSS class name of contents group
		revealtype : "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
		mouseoverdelay : 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev : true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded : [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
		onemustopen : false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault : false, //Should contents open by default be animated into view?
		persiststate : true, //persist state of opened contents within browser session?
		toggleclass : [ "", "" ], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml : [ "suffix",
				"<img src='images/plus.gif' class='statusicon' />",
				"<img src='images/minus.gif' class='statusicon' />" ], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed : "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit : function(headers, expandedindices) { //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose : function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>

<script type="text/javascript" src="scripts/jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
</script>

<script language="javascript" type="text/javascript"
	src="scripts/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all"
	href="css/niceforms-default.css" />

</head>
<body>
	<div id="main_container">
		<div class="header">
			<div class="logo">
				<div class="slogan">Enlighten...Enrich...Edify...</div>
			</div>
			<div id="clock_a"></div>
		</div>


		<div class="login_form">

			<h3>Admin Panel Login</h3>


			<s:form action="login.action" method="post" theme="simple"
				onSubmit="javascript:return validateLogin(this)" class="niceform">
				<div style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; color: red;">
				<s:if test="hasActionErrors()">
					<s:iterator
						value="actionErrors">
						<span><s:property escape="false" /></span>
					</s:iterator> 
				</s:if>
				</div>
				<fieldset>
					<dl>
						<dt>
							<label for="userName"
								style="font-family: Arial, Helvetica, sans-serif; font-size: 14px">Username:</label>
						</dt>
						<dd>
							<s:textfield name="userName" value="" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="password"
								style="font-family: Arial, Helvetica, sans-serif; font-size: 14px">Password:</label>
						</dt>
						<dd>
							<s:password name="password" />
						</dd>
					</dl>


					<dl class="submit">
						<button type="submit">Login</button>
					</dl>

				</fieldset>

			</s:form>
		</div>



		<div class="footer_login">

			<div class="left_footer">ICM ADMIN PANEL | Powered by</div>
			<div class="right_footer">
				<a href="http://Atexperti.com"><img src="images/logo_bw.png"
					alt="" title="" border="0" /></a>
			</div>

		</div>

	</div>
	<!--end of main content-->
</body>
</html>



