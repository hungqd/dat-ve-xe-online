<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/coach.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#coachs').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<div id="coachs_wrapper">
	<table id="coachs">
		<thead>
			<tr>
				<td>Id</td>
				<td>Tên nhà xe</td>
				<td>Mô tả</td>
				<td>Hoạt động</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Tên nhà xe</td>
				<td>Mô tả</td>
				<td>Hoạt động</td>
				<td></td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator var="coach" value="coachs">
				<tr>
					<td><s:property value="#coach.id"/></td>
					<td><s:property value="#coach.name"/></td>
					<td><s:property value="#coach.description"/></td>
					<s:if test="%{#coach.active}">
						<td>Đang hoạt động</td>
					</s:if>
					<s:else>
						<td>Không hoạt động</td>
					</s:else>
					<td>
						<a href="${pageContext.request.contextPath}/admincp/coachDetail?id=${coach.id}" class="btn btn-primary">Chi tiết</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>