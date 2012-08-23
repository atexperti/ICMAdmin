<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">

	<div class="right_content">

		<h2>Articles</h2>
		<div>

			<s:form action="searchArticles" method="post" theme="simple"
				class="niceform">
				<table width="100%">
					<tr>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Author" cssClass="select_m"
								list="authorsList" name="author" value="%{author}" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Language" cssClass="select_m"
								list="languageMaster" name="languageName" listKey="languageId"
								listValue="languageName" value="%{languageName}" /></td>

						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Date" cssClass="select_m"
								list="dateCreateList" name="dateadded" value="%{dateadded}"/></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Date" cssClass="select_m"
								list="dateModifiedList" name="lastModifiedDate" value="%{lastModifiedDate}" /></td>
						<td class="submit">
							<button type="submit">Search</button>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="clear"></div>

		<div>
			<s:form action="modifyArticles" method="post" theme="simple"
				name="listForm" class="niceform" enctype="multipart/form-data">
				<s:hidden name="type" value="delAll"></s:hidden>
				<table width="100%" id="rounded-corner"
					summary="2007 Major IT Companies' Profit">
					<thead>
						<tr>

							<th scope="col" class="rounded">ID</th>
							<th scope="col" class="rounded">Title</th>
							<th scope="col" class="rounded">Article</th>
							<th scope="col" class="rounded">Language</th>
							<th scope="col" class="rounded">Author</th>
							<th scope="col" class="rounded">Edit</th>
							<th scope="col" class="rounded">Approve</th>
							<th scope="col" class="rounded-q4">Delete</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<s:iterator value="%{articles}" status="articlesstatus">

							<tr>
								<td><s:checkboxlist name="articleCheckBox"
										list="%{articleId}" value="%{articleId}" listValue=""
										id="%{articleId}"></s:checkboxlist></td>

								<td><s:property value="%{title}"></s:property></td>
								<td><s:property escapeHtml="false" value="%{article}"></s:property></td>
								<td><s:property value="%{languageMaster.languageName}"></s:property></td>
								<td><s:property value="%{userMaster.userName}"></s:property></td>

								<td><s:url id="myUrl" action="modifyArticles"
										escapeAmp="false">
										<s:param name="articleId" value="%{articleId}"></s:param>
										<s:param name="type">edit</s:param>
									</s:url> <s:a href="%{myUrl}">
										<img src="images/user_edit.png" alt="" title="" border="0" />
									</s:a></td>
								<s:if test="%{status == 0}">
									<td><s:url id="myUrl" action="modifyArticles"
											escapeAmp="false">
											<s:param name="articleId" value="%{articleId}"></s:param>
											<s:param name="type">approve</s:param>
										</s:url> <s:a href="%{myUrl}">
											<img border="0" title="" alt="" src="images/approve.png" />
										</s:a></td>
								</s:if>
								<s:else>
									<td><img border="0" title="" alt=""
										src="images/approve.png" /></td>
								</s:else>
								<!-- <td><a href="/articles/<s:property value="%{articlesId}" />"><img
								src="images/approve.png" alt="" title="" border="0" /></a></td> -->

								<td><s:url id="myUrl" action="modifyArticles"
										escapeAmp="false">
										<s:param name="articleId" value="%{articleId}"></s:param>
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
						<td align="right">
							<button type="submit" class="bt_red">
								<span class="bt_red_lft"></span><strong>Delete Articles</strong><span
									class="bt_red_r"></span>
							</button>
						</td>
						<td>
							<button type="submit" class="bt_green"
								onclick="document.listForm.action='addArticles'">
								<span class="bt_green_lft"></span><strong>Add Articles</strong><span
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
