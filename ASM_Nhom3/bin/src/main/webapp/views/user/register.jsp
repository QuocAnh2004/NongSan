<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@ include file="/common/head.jsp" %>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <h1 class="mt-5">Register</h1>
                    <form>
                        <div class="mb-3">
                            <label for="registerName" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="registerName">
                        </div>
                        <div class="mb-3">
                            <label for="registerEmail" class="form-label">Email address</label>
                            <input type="email" class="form-control" id="registerEmail" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                            <label for="registerEmail" class="form-label">Address</label>
                            <input type="text" class="form-control" id="Address" aria-describedby="">
                        </div>
                        <div class="mb-3">
                            <label for="registerEmail" class="form-label">PhoneNumber</label>
                            <input type="text" class="form-control" id="PhoneNumber">
                        </div>
                        <div class="mb-3">
                            <label for="registerPassword" class="form-label">Password</label>
                            <input type="password" class="form-control" id="registerPassword">
                        </div>
                        <div class="mb-3">
                            <label for="registerConfirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="registerConfirmPassword">
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                    <p class="mt-3">Already have an account? <a href="login.html">Login here</a></p>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/common/footer.jsp" %>
</body>
</html>