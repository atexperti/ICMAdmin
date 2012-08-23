<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">


	<div class="right_content">

		<h2>Edit Event</h2>

		<s:form action="editEvents" method="post" theme="simple"
			name="myform" class="niceform">
			<s:iterator value="event" status="stat" var="event">
				<s:hidden name="eventId" value="%{eventId}"></s:hidden>
				<table height="538" id="rounded-corner"
					summary="2007 Major IT Companies' Profit">

					<tbody>
						<tr>
							<td width="180">Event Name</td>
							<td width="211"><s:textfield name="eventName"
									value="%{eventName}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Event Adress</td>
							<td width="211"><s:textfield name="eventAddress"
									value="%{eventAddress}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Speakers</td>
							<td width="211"><s:textfield name="contactPerson"
									value="%{contactPerson}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Contact Number</td>
							<td width="211"><s:textfield name="contactNumber"
									value="%{contactNumber}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Category</td>
							<td width="211"><s:textfield name="category"
									value="%{category}" /><br /></td>
						</tr>
						<tr>
						<s:date name="datetime" var="formattedDatetime"  format="yyyy-MM-dd HH:mm"/>
						
							<td width="180">Date and Time</td>
							<td width="211"><s:textfield name="datetime"
									value="%{#formattedDatetime}" /><br /></td>
						</tr>
						<tr>
							<td width="180">place</td>
							<td width="211"><s:textfield name="place" value="%{place}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Sub Languages</td>
							<td width="211"><s:textfield name="subLanguages"
									value="%{subLanguages}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Region</td>
							<td width="211"><s:textfield name="region" value="%{region}" /><br /></td>
						</tr>

						<tr>
							<td>Speaker Language</td>
							<td><s:select headerKey="-1" headerValue="Select Language"
									list="languageMaster" name="spectatorLanguage"
									listKey="languageId" listValue="languageName"
									value="%{spectatorLanguage}" /></td>
						</tr>

						<tr>
							<td>Event Description</td>
							<td><s:textarea label="eventDescription"
									name="eventDescription" cols="20" rows="10"
									value="%{eventDescription}" /></td>
						</tr>
						<tr>
							<td class="submit" align="right">
								<button type="submit">Edit</button>
							</td>
							<td class="submit">
								<button type="submit" onclick="document.myform.action='events'">Back</button>
							</td>
						</tr>

					</tbody>
				</table>
			</s:iterator>
		</s:form>
		<h2>&nbsp;</h2>

		<h2>&nbsp;</h2>
	</div>
	<!-- end of right content-->


</div>
<!--end of center content -->

<!--end of center content -->
<s:include value="footer.jsp"></s:include>