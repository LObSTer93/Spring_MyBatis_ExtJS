<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Show all info</title>
</head>
<body>

    <security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin">
        <a href="<c:url value="/add" />">Add info</a>
    </security:authorize>
    <br/>
    Hello <security:authentication property="principal.username" />!
    <br/>
    <a href="<c:url value="/logout" />"> logout </a>

    <c:if test="${!empty infoList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <c:if test="${isAdmin}">
                    <th>Edit</th>
                    <th>Delete</th>
                </c:if>
            </tr>
            <c:forEach items="${infoList}" var="info">
                <tr>
                    <td>${info.id}</td>
                    <td>${info.name}</td>
                    <td>${info.email}</td>
                    <c:if test="${isAdmin}">
                        <td><a href="<c:url value='/edit/${info.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='/delete/${info.id}'/>">Delete</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>