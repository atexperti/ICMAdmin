<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">


	<div class="right_content">

		<h2>Edit Event</h2>
		<s:if test="hasActionErrors()">
			<div>
				<s:iterator value="actionErrors">
					<span><s:property escape="false" /> </span>
				</s:iterator>
			</div>
		</s:if>
		<s:form action="editMedia" method="post" theme="simple"
			enctype="multipart/form-data" name="myform" class="niceform">
			<table height="538" id="rounded-corner"
				summary="2007 Major IT Companies' Profit">
				<s:iterator value="media" status="stat" var="media">
					<s:hidden name="id" value="%{id}"></s:hidden>
					<tbody>
						<tr>
							<td width="180">Title</td>
							<td width="211"><s:textfield name="title" value="%{title}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Provider Name</td>
							<td width="211"><s:textfield name="providerName"
									value="%{providerName}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Album</td>
							<td width="211"><s:textfield name="album" value="%{album}" /><br /></td>
						</tr>
						<tr>
							<td width="180">Ocassion</td>
							<td width="211"><s:textfield name="ocassion"
									value="%{ocassion}" /><br /></td>
						</tr>
						<tr>
							<td width="180">genre</td>
							<td width="211"><s:textfield name="genre" value="%{genre}" /><br /></td>
						</tr>
						<tr>
							<td width="180">artist</td>
							<td width="211"><s:textfield name="artist" value="%{artist}" /><br /></td>
						</tr>
						<tr>
						<td>Description</td>
						<td><s:textarea label="description" name="description" cols="20"
								rows="10" value="%{description}" /></td>
					</tr>

						<tr>
							<td>Upload Media</td>
							<td><s:file name="userMedia" />
						</tr>
						<tr>
							<td class="submit" align="right">
								<button type="submit">Edit</button>
							</td>
							<td class="submit">
								<button type="submit" onclick="document.myform.action='media'">Back</button>
							</td>
						</tr>

					</tbody>
				</s:iterator>
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