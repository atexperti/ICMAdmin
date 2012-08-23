<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<s:include value="header.jsp"></s:include>

<div class="center_content">

	<div class="right_content">

		<h2>To Do List</h2>


		

			<s:iterator var="todoList" status="stat"
				value="%{todoList.entrySet()}">
				<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
				<thead>
					<tr>
						<th colspan="2" scope="col" class="rounded"><s:property
								value="%{#todoList.getKey()}" /></th>
						
					</tr>
				</thead>
				<tfoot>
				</tfoot>
				<tbody>
					<s:iterator var="internlMap" status="stat"
						value="%{#todoList.getValue()}">
						<tr>
							<td><s:property value="%{#internlMap.getKey()}" /></td>
							<td><s:property value="%{#internlMap.getValue()}" /></td>
						</tr>

					</s:iterator>
				</tbody>
				</table>	
			</s:iterator>

			
	</div>
	<!-- end of right content-->


</div>
<!--end of center content -->

<s:include value="footer.jsp"></s:include>
