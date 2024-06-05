<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
    <%@ include file="/common/header.jsp" %>
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <h1 class="mt-5">Change Password</h1>
                    <!-- Hiển thị thông báo lỗi nếu có -->
                    <% if (request.getAttribute("error") != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= request.getAttribute("error") %>
                        </div>
                    <% } %>
                    <form:form modelAttribute="user" action="/app/user/changePass" method="post">
                        <!-- Trường ẩn cho tên người dùng -->
                        <form:hidden path="username" />
                       
                    	<input type="text" name="oldPassword" placeholder="old pass" required>
                    	<input type="text" name="newPassword" placeholder="new pass" required>
                    	<input type="text" name="confirmPassword" placeholder="confirm pass" required>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form:form>
                    <h5>${message}</h5>
                   <%--  <form action="/app/user/changePass" method="post">
                    	
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form> --%>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/common/footer.jsp" %>
</body>
</html>
