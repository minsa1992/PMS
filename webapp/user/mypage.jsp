<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
s
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
              <a class="nav-link" href="../list/ulist.do">물품리스트
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="request.jsp">물품요청</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="mypage.jsp">마이페이지</a>
              <span class="sr-only">(current)</span>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">로그아웃</a>
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
            <h5 class="card-header">회원 정보 변경</h5>
            <div class="card-body">
              <div class="form-group">
                  <label>이름</label>
                  <input class="form-control">
                  <p class="help-block"></p>
              </div>
            <div class="form-group">
                  <label>변경할 비밀 번호</label>
                  <input type="password" class="form-control">
                  <p class="help-block"></p>
              </div>
            <div class="form-group">
                  <label>변경할 비밀 번호 확인</label>
                    <input type="password" class="form-control">
                      <p class="help-block"></p>
              </div>
              <div class="row">
              <div class="col-lg-6">
              <div class="form-group">
                  <label>ìì</label>
                    <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>경영지원팀
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">SM사업팀
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">SM사업1팀
                        </label>
                    </div>
                    <div class="radio">
                      <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">SM사업2팀
                      </label>
                    </div>
                </div>
                </div>
                <div class="col-lg-6">
                  <div class="form-group">
                        <label>직급</label>
                          <select class="form-control">
                          <option>부장</option>
                          <option>차장</option>
                          <option>과장</option>
                          <option>대리</option>
                          <option>주임</option>
                          <option>사원</option>
                      </select>
                    </div>
                </div>
              </div>


              <button type="submit" class="btn btn-default">Submit Button</button>
              <button type="reset" class="btn btn-default">Reset Button</button>
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
                <input type="text" class="form-control" placeholder="ë¬¼í ê²ì">
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
                      <a href="#">공구류</a>
                    </li>
                    <li>
                      <a href="#">위생품</a>
                    </li>
                    <li>
                      <a href="#">비상약품</a>
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

  </body>

</html>
