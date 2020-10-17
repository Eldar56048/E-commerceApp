<%@ page import="com.company.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.User!=null}">
    <c:redirect  url="Product"></c:redirect>
</c:if>

<%@include file="header.jsp"%> <%--There we include header--%>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Register</h1>
                <nav class="d-flex align-items-center">
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->


<!--================Login Box Area =================-->
<section class="login_box_area section_gap">
    <div class="container">
        <div class="row ">

            <div class="col-lg-6">
                <div class="login_box_img">
                    <img class="img-fluid" src="img/login.jpg" alt="">
                    <div class="hover">
                        <h4>You have already registered?</h4>
                        <p>There are advances being made in science and technology everyday, and a good example of this is the</p>
                        <a class="primary-btn" href="login.jsp">Sign in into Account</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <div class="login_form_inner">
                    <h3>Fill form to Register</h3>
                    <form class="row login_form" action="RegisterUser"  method="post" id="contactForm" novalidate="novalidate">
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Name'">
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="surname" name="surname" placeholder="Surname" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Surname'">
                        </div>

                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="username" name="username" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
                        </div>

                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                        </div>

                        <div class="col-md-12 form-group">
                            <input type="date" class="form-control" id="birthday" name="birthday" placeholder="Birth day" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Birth day'">
                        </div>

                        <div class="col-md-12 form-group">
                            <c:if test="${sessionScope.MessageAddUser!=null}">
                                <h3>${sessionScope.MessageAddUser}</h3>
                                ${sessionScope.remove("MessageAddUser")}
                            </c:if>
                            <h3></h3>
                            <button type="submit" value="submit" class="primary-btn">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Login Box Area =================-->

<%@include file="footer.jsp"%> <%--There we include header--%>
