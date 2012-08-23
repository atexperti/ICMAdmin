<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">


	<div class="right_content">

		<h2>Add Event</h2>
		<s:if test="hasActionErrors()">
			<div > <s:iterator
				value="actionErrors">
				<span><s:property escape="false" /> </span>
			</s:iterator> </div>
		</s:if>
		<s:else>
		<s:form action="submitMedia" method="post" theme="simple"
			enctype="multipart/form-data" name="myform">
			<table height="538" id="rounded-corner"
				summary="2007 Major IT Companies' Profit">

				<tbody>
					<tr>
						<td width="180">Title</td>
						<td width="211"><s:textfield name="title" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Provider Name</td>
						<td width="211"><s:textfield name="providerName" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Album</td>
						<td width="211"><s:textfield name="album" value="" /><br /></td>
					</tr>
				
					<tr>
						<td>Media Language</td>
						<td><s:select headerKey="-1" headerValue="Select Language"
								list="languageMaster" name="languageName" listKey="languageId"
								listValue="languageName" /></td>
					</tr>

					<tr>
						<td width="180">Ocassion</td>
						<td width="211"><s:textfield name="ocassion" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">genre</td>
						<td width="211"><s:textfield name="genre" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">artist</td>
						<td width="211"><s:textfield name="artist" value="" /><br /></td>
					</tr>
					<tr>
						<td>Category</td>
						<td><s:select headerKey="-1" headerValue="Select Category"
								list="categoryMaster" name="categoryName" listKey="categoryId"
								listValue="categoryName" /></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><s:textarea label="description" name="description" cols="20"
								rows="10" /></td>
					</tr>

					<tr>
						<td>Upload Media</td>
						<td><s:file name="userMedia" size="30"></s:file></td>
					</tr>
					<tr>
						<td class="submit" align="right">
							<button type="submit">Add</button>
						</td>
						<td class="submit">
							<button type="submit" onclick="document.myform.action='media'">Back</button>
						</td>
					</tr>

				</tbody>
			</table>
		</s:form>
		</s:else>
		<h2>&nbsp;</h2>

		<h2>&nbsp;</h2>
	</div>
	<!-- end of right content-->


</div>
<!--end of center content -->

<!--end of center content -->
<s:include value="footer.jsp"></s:include>