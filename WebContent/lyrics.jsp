<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">

	<div class="right_content">

		<h2>Lyrics</h2>
		<div>
			<s:form action="searchLyrics" method="post" theme="simple"
				class="niceform">
				<table width="100%">
					<tr>
						<td class="m_select"><s:select headerKey="-1" headerValue="Select Albums" cssClass="select_m"
								list="albumsList" name="album"/></td>
						<td class="m_select">
						<s:select headerKey="-1" headerValue="Select Language" cssClass="select_m"
								list="languageMaster" name="languageName" listKey="languageId" listValue="languageName"/>
							</td>
						<td class="m_select"><s:select headerKey="-1" headerValue="Select Artists" cssClass="select_m"
								list="artistList" name="artists" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Date" cssClass="select_m" list="datesList"
								name="lastModifiedDate"/></td>
								<td class="submit">
							<button type="submit">Search</button>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="clear"></div>

		<div>
			<s:form action="modifyLyrics" method="post" theme="simple" name="listForm"
				class="niceform" enctype="multipart/form-data">
				<s:hidden name="type" value="delAll"></s:hidden>
				<table width="100%" id="rounded-corner"
					summary="2007 Major IT Companies' Profit">
					<thead>
						<tr>

							<th scope="col" class="rounded">ID</th>
							<th scope="col" class="rounded">Title</th>
							<th scope="col" class="rounded">Lyrics</th>
							<th scope="col" class="rounded">Album Name</th>
							<th scope="col" class="rounded">Genere</th>
							<th scope="col" class="rounded">Artist</th>
							<th scope="col" class="rounded">Edit</th>
							<th scope="col" class="rounded-q4">Delete</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<s:iterator value="%{lyrics}" status="lyricsstatus">

							<tr>
								<td><s:checkboxlist name="lyricsCheckBox"
										list="%{lyricsId}" value="%{lyricsId}" listValue=""
										id="%{lyricsId}"></s:checkboxlist></td>

								<td><s:property value="%{title}"></s:property></td>
								<td><s:property escapeHtml="false"  value="%{lyrics}"></s:property></td>
								<td><s:property value="%{albumName}"></s:property></td>
								<td><s:property value="%{genre}"></s:property></td>
								<td><s:property value="%{artists}"></s:property></td>

								<td><s:url id="myUrl" action="modifyLyrics"
										escapeAmp="false">
										<s:param name="lid" value="%{lyricsId}"></s:param>
										<s:param name="type">edit</s:param>
									</s:url> <s:a href="%{myUrl}">
										<img src="images/user_edit.png" alt="" title="" border="0" />
									</s:a></td>
								<!-- <td><a href="/lyrics/<s:property value="%{lyricsId}" />"><img
								src="images/approve.png" alt="" title="" border="0" /></a></td> -->
								<td><s:url id="myUrl" action="modifyLyrics"
										escapeAmp="false">
										<s:param name="lid" value="%{lyricsId}"></s:param>
										<s:param name="type">del</s:param>
									</s:url> <s:a href="%{myUrl}">
										<img src="images/trash.png" alt="" title="" border="0" />
									</s:a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<table>
				<tr>
						<td  align="right">
							<button type="submit" class="bt_red"><span class="bt_red_lft"></span><strong>Delete
						Lyrics</strong><span class="bt_red_r"></span></button>
						</td>
						<td >
							<button type="submit" class="bt_green" onclick="document.listForm.action='addLyrics'"><span class="bt_green_lft"></span><strong>Add
						Lyrics</strong><span class="bt_green_r"></span></button>
						</td>
					</tr>
					</table>
				<h2>&nbsp;</h2>
			</s:form>
		</div>

	</div>
	<!-- end of right content-->


</div>
<!--end of center content -->
<s:include value="footer.jsp"></s:include>
