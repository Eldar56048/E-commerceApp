<%@include file="header.jsp"%> <%--There we include header--%>
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Compare Cart</h1>
                <nav class="d-flex align-items-center">
                    <a href="Product">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="compare.jsp.jsp">compare.jsp</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!-- start product Area -->

<!-- single product slide -->
<div class="single-product-slider">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 text-center">
                <div class="section-title">
                    <h1>Compare Sneakers</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                        dolore
                        magna aliqua.</p>
                </div>
            </div>
        </div>
        <div class="row">

            <c:forEach items="${sessionScope.CompareMapList}" var="compare">
                <!-- single product -->
                <div class="col-lg-3 col-md-6">
                    <div class="single-product">
                        <img class="img-fluid" src="${compare.value.photoUrl}" alt="">
                        <div class="product-details">
                            <h6>${compare.value.name}</h6>
                            <h6>${compare.value.structure}</h6>
                            <div class="price">
                                <h6>$${compare.value.price}</h6>
                            </div>
                            <h6>${compare.value.category}</h6>
                            <a href="RemoveCompare?id=${compare.key}"><button type="button" class="btn btn-danger">Remove</button></a>
                            <div class="prd-bottom">
                                <a href="AddCart?id=${compare.key}" class="social-info">
                                    <span class="ti-bag"></span>
                                    <p class="hover-text">add to bag</p>
                                </a>
                                <a href="AddWishList?id=${compare.key}" class="social-info">
                                    <span class="lnr lnr-heart"></span>
                                    <p class="hover-text">Wishlist</p>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<!-- end product Area -->
<%@include file="footer.jsp"%> <%--There we include footer--%>
