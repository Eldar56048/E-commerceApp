<%@include file="header.jsp"%> <%--There we include header--%>
<!--================Single Product Area =================-->
<div class="product_image_area">
    <div class="container">
        <div class="row s_product_inner">
            <div class="col-lg-6">
                <div class="s_Product_carousel">
                    <div class="single-prd-item">
                        <img class="img-fluid" src="${product.photoUrl}" alt="">
                    </div>
                    <div class="single-prd-item">
                        <img class="img-fluid" src="${product.photoUrl}" alt="">
                    </div>
                    <div class="single-prd-item">
                        <img class="img-fluid" src="${product.photoUrl}" alt="">
                    </div>
                </div>
            </div>
            <div class="col-lg-5 offset-lg-1">
                <div class="s_product_text">
                    <h3>${product.name}</h3>
                    <h2>$${product.price}</h2>
                    <ul class="list">
                        <li><a class="active" href="#"><span>Category</span> : ${product.category}</a></li>
                    </ul>
                    <p>${product.structure}</p>

                    <div class="card_area d-flex align-items-center">
                        <a class="primary-btn" href="AddCart?id=${product.id}">Add to Cart</a>
                        <a class="icon_btn" href="AddWishList?id=${product.id}"><i class="lnr lnr lnr-diamond"></i></a>
                        <a class="icon_btn " href="AddCompare?id=${product.id}"><i class="lnr lnr lnr-heart"></i></a>
                    </div>
                    <c:if test="${sessionScope.User.role.equals(\"admin\")}">
                        <div class="card_area d-flex align-items-center">
                            <a href="UpdateProduct?id=${product.id}"><button type="button" class="btn btn-success">Update Product</button></a>
                        </div>
                        <div class="card_area d-flex align-items-center">
                            <a href="RemoveProductAdmin?id=${product.id}"><button type="button" class="btn btn-danger">Remove Product</button></a>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<!--================End Single Product Area =================-->

<!--================Product Description Area =================-->
<section class="product_description_area">
    <div class="container">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Description</a>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
                <p>${product.structure}</p>
            </div>
    </div>
</section>
<!--================End Product Description Area =================-->

<%@include file="footer.jsp"%> <%--There we include footer--%>
