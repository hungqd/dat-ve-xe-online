<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/vehicle.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#vehicles').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<div id="vehicles_wrapper">
	<table id="vehicles" class="display">
		<thead>
			<tr>
				<td>Id</td>
				<td>Biển số xe</td>
				<td>Loại xe</td>
				<td>Số chỗ</td>
				<td>Tình trạng</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Biển số xe</td>
				<td>Loại xe</td>
				<td>Số chỗ</td>
				<td>Tình trạng</td>
				<td></td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator value="vehicles">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="bienSo"/></td>
					<td><s:property value="type.name"/></td>
					<td><s:property value="type.seats"/></td>
					
					<s:if test="active">
						<td>Hoạt động</td>
					</s:if>
					<s:else>
						<td>Không hoạt động</td>
					</s:else>
					<td><a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/coachcp/vehicle/${id}">Chi tiết</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>