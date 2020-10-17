<%@ page import="java.util.Date" %>
<%@include file="header.jsp"%> <%--There we include header--%>

<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Confirmation</h1>
                <nav class="d-flex align-items-center">
                    <a href="Product">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="confirmation.jsp">Confirmation</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Order Details Area =================-->
<section class="order_details section_gap">
    <div class="container">
        <h3 class="title_confirmation">Thank you. Your order has been received.</h3>
        <%
        Date createDate = new Date(session.getCreationTime());
        Date lastAccess = new Date(session.getCreationTime());
        out.println("<h3 class=\"title_confirmation\">Session createDate: "+createDate+"</h3>");
        out.println("<h3 class=\"title_confirmation\">Last access: "+lastAccess+"</h3>");
        %>
        <h3 class="title_confirmation">Inactivity interval: ${pageContext.session.maxInactiveInterval}</h3>
        <h3 class="title_confirmation">You are visited us: ${cookie.counter.value}</h3>
        <div class="order_details_table">
            <h2>Order Details</h2>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Product</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                    </tr>
                    </thead>
                    <tbody>
<c:set var="subtotal" value ="${0}">
</c:set>
    <c:forEach items="${sessionScope.ShoppingCart}" var="item">
                    <tr>
                        <td>
                            <p>${item.product.name}</p>
                        </td>
                        <td>
                            <p>${item.product.price}</p>
                        </td>
                        <td>
                            <h5>x ${item.quantity}</h5>
                        </td>
                        <td>
                            <p>${item.total}</p>
                        </td>
                    </tr>
        <c:set var="subtotal" value="${subtotal+item.total}"/>
    </c:forEach>


                    <tr>
                        <td>
                            <h4>Total</h4>
                        </td>
                        <td>
                            <h5></h5>
                        </td>
                        <td>
                            <h5></h5>
                        </td>
                        <td>
                            <p>${subtotal}</p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!--================End Order Details Area =================-->

<%@include file="footer.jsp"%> <%--There we include footer--%>