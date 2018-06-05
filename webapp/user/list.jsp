<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="toDay" class="java.util.Date" />


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
	
	<%-- <%=session.getAttribute("id") %> --%>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Hanil Networks</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="list.jsp">물품리스트
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../user/request.jsp">물품요청</a>
            </li>
           <!--  <li class="nav-item">
              <a class="nav-link" href="../user/mypage.jsp">마이페이지</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">로그아웃</a>
            </li> -->
            <li class="nav-item">
            	<a class="nav-link" href="../user/mypage.jsp">마이페이지</a>
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
    <div class="container">

      <div class="row">

        <div class="col-lg-8" style="margin-top:2%">
        <div class="row">

		<c:forEach var='dto' items="${list }">
        <div class="col-lg-4 col-md-6 mb-4">
              <div class="card">
              <div class="card">
                <img class="card-img-top" height=150px src="../admin/storage/${dto.poster }" alt="">
                </div>
                <c:set var="result" value="${dto.consumable}" />
                <c:set var="stock" value="${dto.stock }"/>
                <c:set var="usedate" value="${dto.use_date }" />
                <fmt:formatDate var="date" value="${toDay}" pattern="yyyy-MM-dd HH:mm:ss" />

                <div class="card-body">
                  <h4 class="card-title">
                  <c:choose>
                  <c:when test="${result eq 'n' }">
                   <a href="#" data-toggle="modal" onclick="show('${dto.product_name }')">${dto.product_name }</a>
                  </c:when>
                  
                  <c:when test="${result eq 'y' }">
                   <a href="#" data-toggle="modal" onclick="show2('${dto.product_name }')">${dto.product_name }</a>
                  </c:when>
                  
                  </c:choose>
               
                   <c:choose>
                   <c:when test="${result eq 'n' and usedate gt date}">
                  <h5 style="color:red;">${usedate }까지 이용불가</h5>
                  </c:when>
                  
                   <c:when test="${result eq 'n' and usedate lt date}">
                  <h5 style="color:green;">이용가능</h5>
                  </c:when>
                  
                  
                  <c:when test="${result eq 'y' and stock gt 0}">
                  <h5 style="color:green;">현재 ${stock }개 보유중</h5>
                  </c:when>
                  <c:when test="${result eq 'y' and stock eq 0 }">
                  <h5 style="color:red;">이용불가</h5>
                  </c:when>
             
                  </c:choose>
                  
                  <p class="card-text">${dto.product_location }</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted"></small>
                </div>
              </div>
            </div>
        </c:forEach> 
           
            <!-- <div class="col-lg-4 col-md-6 mb-4">
              <div class="card">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                   <a href="#" data-toggle="modal" onclick="show('aaa', 'bbb')">Goods Name</a>
                  </h4>
                  <h5>사용 가능 여부</h5>
                  <p class="card-text">물품 위치 정보</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted"></small>
                </div>
              </div>
            </div> -->
            
           

<!-- modal by1 start //////////////////////////////////////////////////////////////////////////////////////////////////////// -->

            <div class="modal fade" id="mymodal1">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">              
              <h4 id="modaltitle"></h4>
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="form-group">
                  <label for="name">대여 중일 경우 다시 들어오는 시간</label>
                  <p id="modaltime"></p>
                </div>
                  
                    <div class="form-group">
                      <label for="cal">Date &amp; Time</label>
                      <div class='input-group date' id='datetimepicker1'>
                        <input type='date' class="form-control" id="cal"/>
                        <input type='time' class="form-control" id="cal"/>
                        <!--  <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>  -->
                    </div>
                  </div>

                  <div class="form-group">
                    <label>ì¬ì </label>
                    <input class="form-control" placeholder="사유를 적어주세요">
                  </div>
              </div><!-- modal-body -->
            
          <div class="modal-footer">
            <button type="button" class="btn btn-success">사용</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div><!-- modal footer -->
        </form>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
            </div> <!-- modal end -->
<!-- modal by1 end /////////////////////////////////////////////////////////////////////////////////////////////////////// -->



<!-- modal by2 start ///////////////////////////////////////////////////////////////////////////////////////////// -->
            <div class="modal fade" id="mymodal2">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">              
              <h4 id="modaltitle2"></h4>
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="form-group">
                  <label for="contact">Count</label>
                  <input type="number" class="form-control" id="contact" placeholder="개수를 입력하세요">
                </div>
                
                <div class="form-group">
                    <label>사유</label>
                    <input class="form-control" placeholder="사유를 적어주세요">
                </div>
              </div><!-- modal-body -->
            
          <div class="modal-footer">
            <button type="button" class="btn btn-success">사용 </button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div><!-- modal footer -->
        </form>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
            </div> <!-- modal end -->

<!-- modal by2 end ///////////////////////////////////////////////////////////////////////////////////////////////// -->

          </div> <!-- row end  -->
      </div><!-- col end -->     

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
                      <a href="#">사무용품</a>
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

        </div><!-- sidebar end  -->

      </div><!-- /.row -->

    </div><!-- /.container -->

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
    <script type="text/javascript">
    $(document).ready(function() {

        <% 
        String id = (String)session.getAttribute("id");
        
        %>
  		alert(id);

      });
    
      function show(str) {
        // body...
       
        $("#modaltitle").html(str);
       

        $("#mymodal1").modal('show');
      }

      function show2(str) {
        // body...
        
        $("#modaltitle2").html(str);

        $("#mymodal2").modal('show');
      }
    </script>

  </body>

</html>
