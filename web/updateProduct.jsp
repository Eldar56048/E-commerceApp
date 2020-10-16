<%@ page import="com.company.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${!sessionScope.User.role.equals(\"admin\")}">
    <c:redirect  url="Product"></c:redirect>
</c:if>

<%@include file="header.jsp"%> <%--There we include header--%>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Update Product from DataBase</h1>
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
        <div class="row align-items-center align-content-center">
            <div class="col-lg-6">
                <div class="login_form_inner">
                    <h3>Update Product from DB</h3>
                    <form class="row login_form" action="UpdateProduct" method="post" id="contactForm" novalidate="novalidate">
                        <div class="col-md-12 form-group">
                            <input value="${product.name}" type="text" class="form-control" id="productName" name="productName" placeholder="Product Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Product Name'">
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="number" value="${product.price}" class="form-control" id="productPrice" name="productPrice" placeholder="Product Price" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Product Price'">
                        </div>

                        <div class="col-md-12 form-group">
                            <textarea class="form-control" id="productStructure" name="productStructure" placeholder="Product Structure" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Product Structure'">${product.structure}</textarea>
                        </div>

                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="productCategory" value="${product.category}" name="productCategory" placeholder="Product Category" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Product Category'">
                        </div>
                        <input type="hidden"  value="${product.id}" name="productId">

                        <div class="col-md-12 form-group">
                            <%--<c:if test="${cookie.MessageAddProduct!=null}">
                                <h3>Invalid product or Password</h3>
                                ${cookie.MessageLogin.maxAge=0}
                            </c:if>--%>
                            <h3></h3>
                            <button type="submit" value="submit" class="primary-btn">Update Product</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Login Box Area =================-->

<%@include file="footer.jsp"%> <%--There we include header--%>
