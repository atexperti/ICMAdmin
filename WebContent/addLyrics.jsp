<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">


	<div class="right_content">

		<h2>Add Lyrics</h2>

		<s:form action="submitLyrics" method="post" theme="simple" name="myform"
			onSubmit="javascript:return validateLyrics(this)" class="niceform">
			<table height="538" id="rounded-corner"
				summary="2007 Major IT Companies' Profit">

				<tbody>
					<tr>
						<td width="180">Lyrics Title</td>
						<td width="211"><s:textfield name="title" value="" /><br /></td>
					</tr>

					<tr>
						<td>Keywords</td>
						<td><s:textfield name="keywords" value="" /><br /></td>
					</tr>

					<tr>
						<td>Lyric Language</td>
						<td><s:select headerKey="-1" headerValue="Select Language"
								list="languageMaster" name="languageName" listKey="languageId" listValue="languageName"/>
							</td>
					</tr>
					<tr>
						<td width="180">Album Name</td>
						<td width="211"><s:textfield name="album" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Genre</td>
						<td width="211"><s:textfield name="genre" value="" /><br /></td>
					</tr>
					<tr>
						<td width="180">Artist</td>
						<td width="211"><s:textfield name="artists" value="" /><br /></td>
					</tr>
					<tr>
						<td>Lyrics Description</td>
						<td><s:textarea label="Address" name="lyricsDesc" cols="40"
								rows="20" /></td>
					</tr>
					<tr>
						<td class="submit" align="right">
							<button type="submit">Add</button>
						</td>
						<td class="submit">
							<button type="submit" onclick="document.myform.action='lyrics'">Back</button>
						</td>
					</tr>

					</form>
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