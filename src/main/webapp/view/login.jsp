<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>login</title>
    <link rel="stylesheet" href="../style/nicepage.css" media="screen">
<link rel="stylesheet" href="../style/login.css" media="screen">
    <script class="u-script" type="text/javascript" src="../style/jquery-1.9.1.min.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="../style/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 2.29.6, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"url": "index.html",
		"sameAs": []
}</script>
    <meta property="og:title" content="login">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#01abf5">
    <link rel="canonical" href="../index.jsp">
    <meta property="og:url" content="index.html">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
  </head>
  <body class="u-body">
    <section class="u-align-center-xs u-align-left-lg u-align-left-md u-align-left-sm u-align-left-xl u-clearfix u-image u-section-1" id="carousel_60d8" data-image-width="1280" data-image-height="853">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-container-style u-group u-palette-5-light-1 u-radius-4 u-shape-round u-group-1" data-animation-name="zoomIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">
          <div class="u-container-layout u-valign-middle u-container-layout-1">
              <form action="<%=request.getContextPath() %>/login" class="was-validated" method="post">
                  <div class="form-group">
                      <label for="uname">Username:</label>
                      <input type="text" class="form-control" id="uname" placeholder="Enter username" name="username" required autofocus>
                      <div class="valid-feedback">Valid.</div>
                      <div class="invalid-feedback">Please fill out this field.</div>
                  </div>
                  <div class="form-group">
                      <label for="pwd">Password:</label>
                      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
                      <div class="valid-feedback">Valid.</div>
                      <div class="invalid-feedback">Please fill out this field.</div>
<%--                      <c:set var="error" scope="session" value=""--%>
                      <%
                          if(request.getParameter("error")!=null){
                      %>
                      <div class="invalid-feedback" align="center"><b>Wrong username or password!</b></div>
                      <%
                          }
                      %>
                  </div>
                  <button type="submit" class="u-active-palette-2-dark-2 u-black u-btn u-button-style u-hover-palette-2-light-1 u-btn-1">Login</button>
              </form>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>