<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sell Item</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/main.css">
</head>

<body>
	<c:if test="${not empty successMessage}">
        <h3>${successMessage}</h3>
    </c:if>
	
    <h2>Bán đồ dùng</h2>
    
    <form action="${pageContext.request.contextPath}/items" method="POST">
        <label for="item">Tên vật phẩm:</label>
        <input type="text" id="item" name="item" placeholder="Nhập tên vật phẩm" required><br><br>

		<label>Chọn loại vật phẩm:</label><br>
		<input type="radio" id="household" name="category" value="Đồ gia dụng">
		<label for="household">Đồ gia dụng</label><br>

		<input type="radio" id="study" name="category" value="Học tập">
		<label for="study">Học tập</label><br>
	
		<input type="radio" id="electronics" name="category" value="Điện tử">
		<label for="electronics">Điện tử</label><br>

		<input type="radio" id="furniture" name="category" value="Nội thất">
		<label for="furniture">Nội thất</label><br>

		<input type="radio" id="entertainment" name="category" value="Giải trí">
		<label for="entertainment">Giải trí</label><br>

		<input type="radio" id="other" name="category" value="Khác" onclick="toggleOtherInput(this)">
		<label for="other">Khác</label>
		<input type="text" id="otherInput" name="otherCategory" placeholder="Nhập loại khác" style="display:none;"><br><br>

        <label for="damageCondition">Tình trạng hỏng hóc:</label><br>
        <textarea id="damageCondition" name="damageCondition" rows="4" cols="50" placeholder="Mô tả tình trạng hỏng hóc (nếu có)"></textarea><br><br>

        <label for="price">Giá :</label>
        <input type="number" id="price" name="price" placeholder="Nhập giá mong muốn" required>
		<span>(VNĐ)</span><br><br>

        <label for="phone">SĐT:</label>
        <input type="tel" id="phone" name="phone" placeholder="Nhập số điện thoại liên hệ" required><br><br>

        <label for="email">Địa chỉ Email:</label>
        <input type="email" id="email" name="email" placeholder="Nhập email liên hệ" required><br><br>

        <input type="submit" value="Đăng bán">
    </form>

    <script>
        function toggleOtherInput(checkbox) {
            const otherInput = document.getElementById('otherInput');
            otherInput.style.display = checkbox.checked ? 'inline' : 'none';
        }
    </script>
</body>

</html>
