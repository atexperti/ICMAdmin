<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">


	<div class="right_content">

		<h2>Add Event</h2>

		<s:form action="submitEvents" method="post" theme="simple"
			name="myform" class="niceform">
			<table height="538" id="rounded-corner"
				summary="2007 Major IT Companies' Profit">

				<tbody>
					<tr>
						<td width="180">Event Name</td>
						<td width="211"><s:textfield name="eventName" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Event Adress</td>
						<td width="211"><s:textfield name="eventAddress" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Speakers</td>
						<td width="211"><s:textfield name="contactPerson" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Contact Number</td>
						<td width="211"><s:textfield name="contactNumber" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Category</td>
						<td width="211"><s:textfield name="category" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Date and Time</td>
						<td width="211"><s:textfield name="datetime" value="yyyy-MM-dd HH:mm" /><br /></td>
					</tr>
					<tr>
						<td width="180">place</td>
						<td width="211"><s:textfield name="place" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Sub Languages</td>
						<td width="211"><s:textfield name="subLanguages" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Region</td>
						<td width="211"><s:textfield name="region" value="" /><br /></td>
					</tr>
					<tr>
						<td>Event Language</td>
						<td><s:select headerKey="-1" headerValue="Select Language"
								list="languageMaster" name="languageName" listKey="languageId"
								listValue="languageName" /></td>
					</tr>
					<tr>
						<td>Speaker Language</td>
						<td><s:select headerKey="-1" headerValue="Speaker Language"
								list="languageMaster" name="spectatorLanguage"
								listKey="languageId" listValue="languageName" /></td>
					</tr>



					<tr>
						<td>Event Description</td>
						<td><s:textarea label="eventDescription"
								name="eventDescription" cols="20" rows="10" /></td>
					</tr>
					<tr>
						<td class="submit" align="right">
							<button type="submit">Add</button>
						</td>
						<td class="submit">
							<button type="submit" onclick="document.myform.action='events'">Back</button>
						</td>
					</tr>

				</tbody>
			</table>
		</s:form>
		<h2>&nbsp;</h2>

		<h2>&nbsp;</h2>
	</div>
	<!-- end of right content-->


</div>
<!--end of center content -->

<!--end of center content -->
<s:include value="footer.jsp"></s:include>