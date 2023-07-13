<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 7/1/23
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="POST" action="/SU23B2_SOF3011_SD18105_war_exploded/cua-hang/update?id=${ data.id }">
        <div>
            <label>Mã</label>
            <input type="text" name="ma" value="${ data.ma }" />
        </div>
        <div>
            <label>Tên</label>
            <input type="text" name="ten" value="${ data.ten }" />
        </div>
        <div>
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" value="${ data.diaChi }" />
        </div>
        <div>
            <label>Thành Phố</label>
            <input type="text" name="thanhPho" value="${ data.thanhPho }" />
        </div>
        <div>
            <label>Quốc Gia</label>
            <input type="text" name="quocGia" value="${ data.quocGia }" />
        </div>
        <div>
            <button>Submit</button>
        </div>
    </form>
</body>
</html>
