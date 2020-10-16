<%@include file="header.jsp"%> <%--There we include header--%>
<!-- start banner Area -->
<section class="banner-area">
  <div class="container">
    <div class="row fullscreen align-items-center justify-content-start">
      <div class="col-lg-12">
        <div class="active-banner-slider owl-carousel">
          <!-- single-slide -->
          <div class="row single-slide align-items-center d-flex">
            <div class="col-lg-5 col-md-6">
              <div class="banner-content">
                <h1>Nike New <br>Collection!</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                <div class="add-bag d-flex align-items-center">
                  <a class="add-btn" href=""><span class="lnr lnr-cross"></span></a>
                  <span class="add-text text-uppercase">Add to Bag</span>
                </div>
              </div>
            </div>
            <div class="col-lg-7">
              <div class="banner-img">
                <img class="img-fluid" src="img/banner/banner-img.png" alt="">
              </div>
            </div>
          </div>
          <!-- single-slide -->
          <div class="row single-slide">
            <div class="col-lg-5">
              <div class="banner-content">
                <h1>Nike New <br>Collection!</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                <div class="add-bag d-flex align-items-center">
                  <a class="add-btn" href=""><span class="lnr lnr-cross"></span></a>
                  <span class="add-text text-uppercase">Add to Bag</span>
                </div>
              </div>
            </div>
            <div class="col-lg-7">
              <div class="banner-img">
                <img class="img-fluid" src="img/banner/banner-img.png" alt="">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- End banner Area -->

<!-- start features Area -->
<section class="features-area section_gap">
  <div class="container">
    <div class="row features-inner">
      <!-- single features -->
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="single-features">
          <div class="f-icon">
            <img src="img/features/f-icon1.png" alt="">
          </div>
          <h6>Free Delivery</h6>
          <p>Free Shipping on all order</p>
        </div>
      </div>
      <!-- single features -->
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="single-features">
          <div class="f-icon">
            <img src="img/features/f-icon2.png" alt="">
          </div>
          <h6>Return Policy</h6>
          <p>Free Shipping on all order</p>
        </div>
      </div>
      <!-- single features -->
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="single-features">
          <div class="f-icon">
            <img src="img/features/f-icon3.png" alt="">
          </div>
          <h6>24/7 Support</h6>
          <p>Free Shipping on all order</p>
        </div>
      </div>
      <!-- single features -->
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="single-features">
          <div class="f-icon">
            <img src="img/features/f-icon4.png" alt="">
          </div>
          <h6>Secure Payment</h6>
          <p>Free Shipping on all order</p>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- end features Area -->

<!-- Start category Area -->

<!-- start product Area -->

  <!-- single product slide -->
  <div class="single-product-slider">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-6 text-center">
          <a href="Product"><button type="button" class="btn btn-primary">All</button></a>
          <c:forEach items="${Categories}" var="category">
            <a href="Product?Category=${category}"><button type="button" class="btn btn-primary">${category}</button></a>
          </c:forEach>
          <div class="section-title">
            <h1>${Category} Sneakers</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
              dolore
              magna aliqua.</p>
          </div>
        </div>
      </div>
      <div class="row">


<c:forEach items="${products}" var="product">
        <!-- single product -->
        <div class="col-lg-3 col-md-6">
          <div class="single-product">
            <img class="img-fluid" src="${product.photoUrl}" alt="">
            <div class="product-details">
              <h6>${product.name}</h6>
              <div class="price">
                <h6>$${product.price}</h6>
              </div>
              <h6>${product.category}</h6>
              <div class="prd-bottom">

                <a href="AddCart?id=${product.id}" class="social-info">
                  <span class="ti-bag"></span>
                  <p class="hover-text">add to bag</p>
                </a>
                <a href="AddWishList?id=${product.id}" class="social-info">
                  <span class="lnr lnr-heart"></span>
                  <p class="hover-text">Wishlist</p>
                </a>
                <a href="AddCompare?id=${product.id}" class="social-info">
                  <span class="lnr lnr-sync"></span>
                  <p class="hover-text">compare</p>
                </a>
                <a href="" class="social-info">
                  <span class="lnr lnr-move"></span>
                  <p class="hover-text">view more</p>
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


<!-- Start brand Area -->
<section class="brand-area section_gap">
  <div class="container">
    <div class="row">
      <a class="col single-img" href="#">
        <img class="img-fluid d-block mx-auto" src="img/brand/1.png" alt="">
      </a>
      <a class="col single-img" href="#">
        <img class="img-fluid d-block mx-auto" src="img/brand/2.png" alt="">
      </a>
      <a class="col single-img" href="#">
        <img class="img-fluid d-block mx-auto" src="img/brand/3.png" alt="">
      </a>
      <a class="col single-img" href="#">
        <img class="img-fluid d-block mx-auto" src="img/brand/4.png" alt="">
      </a>
      <a class="col single-img" href="#">
        <img class="img-fluid d-block mx-auto" src="img/brand/5.png" alt="">
      </a>
    </div>
  </div>
</section>
<!-- End brand Area -->
<%@include file="footer.jsp"%> <%--There we include footer--%>