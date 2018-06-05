<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hanil Networks(user)</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css2/blog-post.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Hanil Networks</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="../list/ulist.do">물품 리스트
              </a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="request.jsp">물품요청</a>
              <span class="sr-only">(current)</span>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="mypage.jsp">마이페이지</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">로그아웃</a>
            </li>
            <!-- <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li> -->
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container" style="margin-bottom: 10%">

      <div class="row">
        <div class="col-lg-8">
        <div class="row">

          <div class="card my-4" style="width: 100%">
            <h5 class="card-header">Goods Request</h5>
            <div class="card-body">
            <form name="buyrequest" action='../brequest/buyenroll.do' method='POST'>
            <input type="hidden" name="user_id" value="<%=session.getAttribute("id") %>">
            <input type="hidden" name="product_result" value="q">
              <div class="form-group">
                  <label>물품이름</label>
                  <input type="text" name="product_name" class="form-control" placeholder="물품 이름을 입력하세요">
                  <p class="help-block"></p>
              </div>
            <div class="form-group">
                  <label>URL</label>
                  <input type="text" name="product_url" class="form-control" placeholder="특정 물품을 원하시면 URL 주소를 입력해 주세요">
                  <p class="help-block"></p>
              </div>
            <div class="form-group">
                  <label>개수</label>
                    <input type="number" name="product_num" class="form-control" placeholder="물품 개수를 입력해 주세요">
                      <p class="help-block"></p>
              </div>
              <div class="form-group">
                  <label>신청 사유</label>
                  <input type="text" name="request_reason" class="form-control"  placeholder="사유를 간단하게 적어주세요">
              </div>
              <button type="submit" onclick="return requestcheck(this.form)" class="btn btn-default">등록</button>
              <button type="reset" class="btn btn-default">리셋</button>
              </form>
            </div>
          </div>
          </div>
          </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Search Widget -->
          <div class="card my-4">
            <h5 class="card-header">Search</h5>
            <div class="card-body">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="물품 검색">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="button">Go!</button>
                </span>
              </div>
            </div>
          </div>

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">공구류</a>
                    </li>
                    <li>
                      <a href="#">위생품</a>
                    </li>
                    <li>
                      <a href="#">비상약품</a>
                    </li>
                  </ul>
                </div>
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">사무용품</a>
                    </li>
                    <li>
                      <a href="#">기타</a>
                    </li>
                    <li>
                      <a href="#"></a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">Notice</h5>
            <div class="card-body">
            공지 사항이 표시되는 곳입니다.
            </div>
          </div>

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Administer : </p>
        <p class="m-0 text-center text-white">tell : </p>
        <p class="m-0 text-center text-white">mail : </p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor2/jquery/jquery.min.js"></script>
    <script src="../vendor2/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script>
    function requestcheck(frm){
    	var mess = "등록하시겠습까?";
    	if(confirm(mess)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    </script>

  </body>

</html>
