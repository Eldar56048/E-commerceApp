<%@include file="header.jsp"%> <%--There we include header--%>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Shopping Cart</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="category.html">Cart</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Cart Area =================-->
<section class="cart_area">
    <div class="container">
        <div class="cart_inner">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Product</th>
                        <th scope="col">Price</th>
                        <th scope="col">Remove</th>
                    </tr>
                    </thead>
                    <tbody>


                    <c:forEach items="${sessionScope.WishList}" var="product">
                        <tr>
                            <td>
                                <div class="media">
                                    <div class="d-flex">
                                        <img  class="img-fluid" src="${product.photoUrl}" alt="">
                                    </div>
                                    <div class="media-body">
                                        <p>${product.name}</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <h5>$${product.price}</h5>
                            </td>
                            <td>
                                <a href="RemoveWishList?productId=${product.id}"><button type="button" class="btn btn-danger">Remove</button></a>
                            </td>
                            <td>
                                <a href="AddCart?id=${product.id}"><button type="button" class="btn btn-success">Success</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr class="out_button_area">
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <div class="checkout_btn_inner d-flex align-items-center">
                                <a class="gray_btn" href="#">Continue Shopping</a>
                                <a class="primary-btn" href="#">Proceed to checkout</a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!--================End Cart Area =================-->
<%@include file="footer.jsp"%> <%--There we include footer--%>
