<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/19
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%request.getContextPath();%>/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<div class="row">
    <table class="table table-striped table-secondary">
        <tbody>
        <tr>
            <td><span class="text-primary">当前用户：</span><span class="text-danger">${user.uName}</span></td>
        </tr>
        <tr>
            <td><span class="text-primary">用户状态：</span>
                <c:if test="${user.uState eq '1'}">
                <span class="text-danger">已审核</span>
                </c:if>
                <c:if test="${user.uState eq '2'}">
                    <span class="text-danger">未审核</span>
                </c:if>
            </td>
        </tr>
        <tr>
            <td><span class="text-primary">创建时间：</span><span class="text-danger"><fmt:formatDate value="${user.uDate}" pattern="yyyy-MM-dd"></fmt:formatDate></span></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
