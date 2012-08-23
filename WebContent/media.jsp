<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">

	<div class="right_content">

		<h2>Media</h2>
		<div>

			<s:form action="searchMedia" method="post" theme="simple"
				class="niceform">
				<table width="100%">
					<tr>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Category" cssClass="select_m"
								list="categoryMaster" name="category" listKey="%{categoryId}"
								listValue="%{categoryName}" value="%{categoryName}" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Language" cssClass="select_m"
								list="languageMaster" name="languageName" listKey="languageId"
								listValue="languageName" value="%{languageName}" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Genre" cssClass="select_m" list="genresList"
								name="genre" value="%{genre}" /></td>

						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Date" cssClass="select_m"
								list="dateModifiedList" name="lastModifiedDate"
								value="%{lastModifiedDate}" /></td>
						<td class="submit">
							<button type="submit">Search</button>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="clear"></div>

		<div>
			<s:form action="modifyMedia" method="post" theme="simple"
				name="listForm" class="niceform" enctype="multipart/form-data">
				<s:hidden name="type" value="delAll"></s:hidden>
				<table width="100%" id="rounded-corner"
					summary="2007 Major IT Companies' Profit">
					<thead>
						<tr>

							<th scope="col" class="rounded">ID</th>
							<th scope="col" class="rounded">Title</th>
							<th scope="col" class="rounded">Category</th>
							<th scope="col" class="rounded">Album</th>
							<th scope="col" class="rounded">Language</th>
							<th scope="col" class="rounded">Genre</th>
							<th scope="col" class="rounded">Description</th>
							<th scope="col" class="rounded">Date</th>
							<th scope="col" class="rounded">Edit</th>
							<th scope="col" class="rounded-q4">Delete</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<s:iterator value="%{medias}" status="mediastatus">

							<tr>
								<td><s:checkboxlist name="mediaCheckBox" list="%{id}"
										value="%{id}" listValue="" id="%{id}"></s:checkboxlist></td>

								<td><s:property value="%{title}"></s:property></td>
								<td><s:property value="%{categoryMaster.categoryName}"></s:property></td>
								<td><s:property value="%{album}"></s:property></td>
								<td><s:property value="%{languageMaster.languageName}"></s:property></td>
								<td><s:property value="%{genre}"></s:property></td>
								<td><s:property escapeHtml="false" value="%{description}"></s:property></td>
								<s:date name="lastModifiedDate" var="formattedDatetime"
									format="yyyy-MM-dd HH:mm" />
								<td><s:property value="%{#formattedDatetime}"></s:property></td>
								<td><s:url id="myUrl" action="modifyMedia"
										escapeAmp="false">
										<s:param name="id" value="%{id}"></s:param>
										<s:param name="type">edit</s:param>
									</s:url> <s:a href="%{myUrl}">
										<img src="images/user_edit.png" alt="" title="" border="0" />
									</s:a></td>
								<!-- <td><a href="/media/<s:property value="%{id}" />"><img
								src="images/approve.png" alt="" title="" border="0" /></a></td> -->

								<td><s:url id="myUrl" action="modifyMedia"
										escapeAmp="false">
										<s:param name="id" value="%{id}"></s:param>
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
						<s:if test="%{pageNo != null && pageNo>1}">
							<td><s:url id="prevUrl" action="media" escapeAmp="false">
									<s:param name="pageNo" value="%{pageNo}"></s:param>
									<s:param name="pageType">prev</s:param>
								</s:url> <s:a href="%{myUrl}">
									Prev
								</s:a></td>
						</s:if>
						<s:if test="%{medias.size>1}">
							<td><s:url id="prevUrl" action="media" escapeAmp="false">
									<s:param name="pageNo" value="%{pageNo}"></s:param>
									<s:param name="pageType">next</s:param>
								</s:url> <s:a href="%{myUrl}">
									Next
								</s:a></td>
						</s:if>
					</tr>

				</table>
				<table>
					<tr>
						<td align="right">
							<button type="submit" class="bt_red">
								<span class="bt_red_lft"></span><strong>Delete Media</strong><span
									class="bt_red_r"></span>
							</button>
						</td>
						<td>
							<button type="submit" class="bt_green"
								onclick="document.listForm.action='addMedia'">
								<span class="bt_green_lft"></span><strong>Add Media</strong><span
									class="bt_green_r"></span>
							</button>
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
