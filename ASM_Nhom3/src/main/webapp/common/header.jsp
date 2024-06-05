<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Spinner Start -->
<div id="spinner"
	class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
	<div class="spinner-grow text-primary" role="status"></div>
</div>
<!-- Spinner End -->
<!-- Navbar start -->
<div class="container-fluid fixed-top">
	<div class="container topbar bg-primary d-none d-lg-block">
		<div class="d-flex justify-content-between">
			<div class="top-info ps-2">
				<small class="me-3"><i
					class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#"
					class="text-white">123 Street, New York</a></small> <small class="me-3"><i
					class="fas fa-envelope me-2 text-secondary"></i><a href="#"
					class="text-white">Email@Example.com</a></small>
			</div>
			<div class="top-link pe-2">
				<a href="#" class="text-white"><small class="text-white mx-2">Privacy
						Policy</small>/</a> <a href="#" class="text-white"><small
					class="text-white mx-2">Terms of Use</small>/</a> <a href="#"
					class="text-white"><small class="text-white ms-2">Sales
						and Refunds</small></a>
			</div>
		</div>
	</div>
	<div class="container px-0">
		<nav class="navbar navbar-light bg-white navbar-expand-xl">
			<a href="/app/user/index" class="navbar-brand"><h1
					class="text-primary display-6">Fruitables</h1></a>
			<button class="navbar-toggler py-2 px-3" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
				<span class="fa fa-bars text-primary"></span>
			</button>
			<div class="collapse navbar-collapse bg-white" id="navbarCollapse">
				<div class="navbar-nav mx-auto">
					<a href="/home/index" class="nav-item nav-link">Home</a> <a
						href="/product/index" class="nav-item nav-link ">Shop</a>
					<!-- <a href="/app/user/shop-detail" class="nav-item nav-link">Shop Detail</a> -->
					<a href="/app/user/contact" class="nav-item nav-link">Contact</a>
				</div>
				<div class="d-flex m-3 me-0">			
					<a href="/product/cart" class="position-relative me-4 my-auto">
						<i class="fa fa-shopping-bag fa-2x"></i> <span
						class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
						style="top: -5px; left: 15px; height: 20px; min-width: 20px;">
							${cartCount} </span>
					</a>
					<div class="nav-item dropdown">
	                            <a href="#" class="nav-link dropdown-toggle my-auto" data-bs-toggle="dropdown">
	                                <i class="fas fa-user fa-2x">
	                                	<span style="font-size: 20px;">${sessionScope.loggedInUser}</span>
	                                </i>
	                            </a>	                            
	                            <div class="dropdown-menu m-0 bg-secondary rounded-0">
	                            	<c:choose>
							            <c:when test="${sessionScope.loggedInUser ne null}">
							                <a href="/app/user/editProfile" class="dropdown-item">Edit profile</a>
							                <a href="/app/user/changePass" class="dropdown-item">Change Password</a>
							                <c:if test="${sessionScope.roleUserLogin eq 3}">
   								 				<a href="/admin/control" class="dropdown-item">Admin Control</a>
											</c:if>
							                <a href="/app/user/logout" class="dropdown-item">Logout</a>

							            </c:when>
							            <c:otherwise>
							                <a href="/app/user/login" class="dropdown-item">Login</a>
							                <a href="/account/register" class="dropdown-item">Register</a>
							                <a href="/app/forgotPass" class="dropdown-item">Forgot password</a>
							            </c:otherwise>
							        </c:choose>
	                            </div>
                        	</div>
				</div>
			</div>
		</nav>
	</div>
</div>
<!-- Navbar End -->