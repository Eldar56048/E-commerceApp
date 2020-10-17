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
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                        <th scope="col">Remove</th>
                    </tr>
                    </thead>
                    <tbody>

<c:set var="subtotal" value ="${0}">

</c:set>

<c:forEach items="${sessionScope.ShoppingCart}" var="item">
                    <tr>
                        <td>
                            <div class="media">
                                <div class="d-flex">
                                    <img  class="img-fluid" src="${item.product.photoUrl}" alt="">
                                </div>
                                <div class="media-body">
                                    <p>${item.product.name}</p>
                                   </div>
                            </div>
                        </td>
                        <td>
                            <h5>$${item.product.price}</h5>
                        </td>
                        <td>
                            <div class="product_count">
                                <input type="text" name="qty" id="sst" maxlength="12" value="${item.quantity}" title="Quantity:"
                                       class="input-text qty">
                                <a href="AddQuantity?productId=${item.product.id}"><button class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button></a>
                                <a href="ReduceQuantity?productId=${item.product.id}"><button  class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button></a>
                            </div>
                        </td>
                        <td>
                            <h5>$${item.total}</h5>
                            <c:set var="subtotal" value="${subtotal+item.total}"/>
                        </td>
                        <td>
                            <a href="RemoveProduct?productId=${item.product.id}"><button type="button" class="btn btn-danger">Remove</button></a>
                        </td>
                    </tr>
</c:forEach>
                    <tr>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <h5>Subtotal</h5>
                        </td>
                        <td>
                            <h5>${subtotal}</h5>
                        </td>
                    </tr>
                    <tr class="out_button_area">
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <div class="checkout_btn_inner d-flex align-items-center">
                                <a class="gray_btn" href="Product">Continue Shopping</a>
                                <a class="primary-btn" href="confirmation.jsp">Proceed to checkout</a>
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