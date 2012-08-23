<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">

	<div class="right_content">

		<h2>User Management</h2>
		<div>

			<s:form action="searchUsers" method="post" theme="simple"
				class="niceform">
				<table width="100%">
					<tr>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Church Name" cssClass="select_m"
								list="churchNamesList" name="churchName" value="%{churchName}" /></td>
						<td class="m_select"><s:select headerKey="-1"
								headerValue="Select Status" cssClass="select_m"
								list="statusList" name="status" value="%{status}" /></td>
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
			<s:form action="modifyUsers" method="post" theme="simple"
				name="listForm" class="niceform" enctype="multipart/form-data">
				<table width="100%" id="rounded-corner"
					summary="2007 Major IT Companies' Profit">
					<thead>
						<tr>

							<th scope="col" class="rounded">Name</th>
							<th scope="col" class="rounded">Email</th>
							<th scope="col" class="rounded">Church Name</th>
							<th scope="col" class="rounded">Date</th>
							<th scope="col" class="rounded">Status</th>
							<th scope="col" class="rounded">Approve</th>
							<th scope="col" class="rounded-q4">Delete</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<s:iterator value="%{users}" status="usersstatus">

							<tr>
								<s:date name="lastModifiedDate" var="formattedDatetime"
									format="yyyy-MM-dd HH:mm" />
								<td><s:property value="%{userName}"></s:property></td>
								<td><s:property value="%{email}"></s:property></td>
								<td><s:property value="%{chruchName}"></s:property></td>
								<td><s:property value="%{#formattedDatetime}"></s:property></td>
								<s:if test="%{status == 0}">
								<td>Pending</td>
								</s:if>
								<s:else><td>Approved</td></s:else>
								<s:if test="%{status == 0}">
									<td><s:url id="myUrl" action="modifyUsers"
											escapeAmp="false">
											<s:param name="userId" value="%{userId}"></s:param>
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

								<td><s:url id="myUrl" action="modifyUsers"
										escapeAmp="false">
										<s:param name="userId" value="%{userId}"></s:param>
										<s:param name="type">del</s:param>
									</s:url> <s:a href="%{myUrl}">
										<img src="images/trash.png" alt="" title="" border="0" />
									</s:a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:form>
		</div>

	</div>
	<!-- end of right content-->


</div>
<!--end of center content -->
<s:include value="footer.jsp"></s:include>
