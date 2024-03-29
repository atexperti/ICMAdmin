<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ICM ADMIN PANEL</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="scripts/clockp.js"></script>
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
			<s:if test="%{#session.icm_loggedIn}">
				<div class="right_header">
					Welcome Admin, | <a href="logout" class="logout">Logout</a>
				</div>
			</s:if>
			<div id="clock_a"></div>
		</div>

		<div class="main_content">

			<div class="menu">
				<ul>
					<li><a class="current" href="home">Admin Home</a></li>
					<li><a href="media">Media </a></li>
					<li><a href="events"> Events</a></li>
					<li><a href="articles"> Articles </a></li>
					<li><a href="lyrics"> Lyrics </a></li>
					<li><a href="orderMngmt"> Order Management </a></li>
					<li><a href="userMngmt"> User Management </a></li>
					<li><a href="ticketMngmt"> Ticket Managemnet </a></li>

					<li>
						<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a class="sub1" href="" title="">sublevel2<!--[if IE 7]><!--></a>
								<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
								<ul>
									<li><a href="" title="">sublevel link</a></li>
									<li><a href="" title="">sulevel link</a></li>
									<li><a class="sub2" href="#nogo">sublevel3<!--[if IE 7]><!--></a>
										<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
										<ul>
											<li><a href="#nogo">Third level-1</a></li>
											<li><a href="#nogo">Third level-2</a></li>
											<li><a href="#nogo">Third level-3</a></li>
											<li><a href="#nogo">Third level-4</a></li>
										</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
									<li><a href="" title="">sulevel link</a></li>
								</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>

							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
					</li>
					<li>
						<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a class="sub1" href="" title="">sublevel2<!--[if IE 7]><!--></a>
								<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
								<ul>
									<li><a href="" title="">sublevel link</a></li>
									<li><a href="" title="">sulevel link</a></li>
									<li><a class="sub2" href="#nogo">sublevel3<!--[if IE 7]><!--></a>
										<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
										<ul>
											<li><a href="#nogo">Third level-1</a></li>
											<li><a href="#nogo">Third level-2</a></li>
											<li><a href="#nogo">Third level-3</a></li>
											<li><a href="#nogo">Third level-4</a></li>
										</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
									<li><a href="" title="">sulevel link</a></li>
								</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>

							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
					</li>
					<li>
						<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
							<li><a class="sub1" href="" title="">sublevel2<!--[if IE 7]><!--></a>
								<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
								<ul>
									<li><a href="" title="">sublevel link</a></li>
									<li><a href="" title="">sulevel link</a></li>
									<li><a class="sub2" href="#nogo">sublevel3<!--[if IE 7]><!--></a>
										<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
										<ul>
											<li><a href="#nogo">Third level-1</a></li>
											<li><a href="#nogo">Third level-2</a></li>
											<li><a href="#nogo">Third level-3</a></li>
											<li><a href="#nogo">Third level-4</a></li>
										</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
									<li><a href="" title="">sulevel link</a></li>
								</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>

							<li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
					</li>

					<li></li>
					<li></li>
				</ul>
			</div>