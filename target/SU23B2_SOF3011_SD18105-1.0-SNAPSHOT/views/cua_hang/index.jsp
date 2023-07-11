<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>

</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Địa chỉ</th>
                <th>Thành phố</th>
                <th>Quốc gia</th>
                <th colspan="2">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ list }" var="ch">
                <tr>
                    <td>${ ch.id }</td>
                    <td>${ ch.ma }</td>
                    <td>${ ch.ten }</td>
                    <td>${ ch.diaChi }</td>
                    <td>${ ch.thanhPho }</td>
                    <td>${ ch.quocGia }</td>
                    <td>
                        <a>Cập nhật</a>
                    </td>
                    <td>
                        <a>Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
