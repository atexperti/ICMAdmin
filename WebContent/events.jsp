<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">

	<div class="right_content">

		<h2>Events</h2>
		<div>

			<s:form action="searchEvents" method="post" theme="simple"
				class="niceform">
				<table width="100%">
					<tr>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Author" cssClass="select_m"
								list="authorList" name="author" value="%{author}" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Language" cssClass="select_m"
								list="languageMaster" name="languageName" listKey="languageId"
								listValue="languageName" value="%{languageName}" /></td>

						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Date" cssClass="select_m" list="dateList"
								name="datetime" value="%{datetime}" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Region" cssClass="select_m"
								list="regionsList" name="region" value="%{region}" /></td>
						<td class="submit">
							<button type="submit">Search</button>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="clear"></div>

		<div>
			<s:form action="modifyEvents" method="post" theme="simple"
				name="listForm" class="niceform" enctype="multipart/form-data">
				<s:hidden name="type" value="delAll"></s:hidden>
				<table width="100%" id="rounded-corner"
					summary="2007 Major IT Companies' Profit">
					<thead>
						<tr>

							<th scope="col" class="rounded">ID</th>
							<th scope="col" class="rounded">Name</th>
							<th scope="col" class="rounded">Date</th>
							<th scope="col" class="rounded">Speakers</th>
							<th scope="col" class="rounded">Description</th>
							<th scope="col" class="rounded">Place</th>
							<th scope="col" class="rounded">Region</th>
							<th scope="col" class="rounded">Language</th>
							<th scope="col" class="rounded">UserName</th>
							<th scope="col" class="rounded">Edit</th>
							<th scope="col" class="rounded">Approve</th>
							<th scope="col" class="rounded-q4">Delete</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<s:iterator value="%{events}" status="eventsstatus">

							<tr>
								<td><s:checkboxlist name="eventCheckBox" list="%{eventId}"
										value="%{eventId}" listValue="" id="%{eventId}"></s:checkboxlist></td>
								<s:date name="datetime" var="formattedDatetime"
									format="yyyy-MM-dd HH:mm" />
								<td><s:property value="%{eventName}"></s:property></td>
								<td><s:property value="%{#formattedDatetime}"></s:property></td>
								<td><s:property value="%{contactPerson}"></s:property></td>
								<td><s:property escapeHtml="false"
										value="%{eventDescription}"></s:property></td>
								<td><s:property value="%{place}"></s:property></td>
								<td><s:property value="%{region}"></s:property></td>
								<td><s:property value="%{languageMaster.languageName}"></s:property></td>
								<td><s:property value="%{userMaster.userName}"></s:property></td>

								<td><s:url id="myUrl" action="modifyEvents"
										escapeAmp="false">
										<s:param name="eventId" value="%{eventId}"></s:param>
										<s:param name="type">edit</s:param>
									</s:url> <s:a href="%{myUrl}">
										<img src="images/user_edit.png" alt="" title="" border="0" />
									</s:a></td>
								<s:if test="%{eventStatus == 0}">
									<td><s:url id="myUrl" action="modifyEvents"
											escapeAmp="false">
											<s:param name="eventId" value="%{eventId}"></s:param>
											<s:param name="type">approve</s:param>
										</s:url> <s:a href="%{myUrl}">
											<img border="0" title="" alt="" src="images/approve.png" />
										</s:a></td>
								</s:if>
								<s:else>
									<td><img border="0" title="" alt=""
										src="images/approve.png" /></td>
								</s:else>
								<!-- <td><a href="/events/<s:property value="%{eventsId}" />"><img
								src="images/approve.png" alt="" title="" border="0" /></a></td> -->

								<td><s:url id="myUrl" action="modifyEvents"
										escapeAmp="false">
										<s:param name="eventId" value="%{eventId}"></s:param>
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
								<span class="bt_red_lft"></span><strong>Delete Events</strong><span
									class="bt_red_r"></span>
							</button>
						</td>
						<td>
							<button type="submit" class="bt_green"
								onclick="document.listForm.action='addEvents'">
								<span class="bt_green_lft"></span><strong>Add Events</strong><span
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
