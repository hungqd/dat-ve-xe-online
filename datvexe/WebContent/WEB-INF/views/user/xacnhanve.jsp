<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div style="margin-left: auto; margin-right : auto; margin-top : 100px; width: 900px; text-align: center; font-size: 18px;">
	<s:if test="%{#request.result == false}">
		 <p><b style="color: red;"> Error! </b>Vé của bạn đã bị hủy!</p>
         <p> Bạn vui lòng đặt vé khác!</p>
	</s:if>
	<s:else>
		<h3>Cảm ơn bạn đã đặt vé</h3>
        <p>Vui lòng trước thời gian xe chạy 24h bạn phải lấy vé nếu không vé của bạn sẽ bị hủy!</p>
        <i style="font-size: 11px;">để lấy vé bạn phải có mã vé được gửi qua email</i>
	</s:else>
</div>