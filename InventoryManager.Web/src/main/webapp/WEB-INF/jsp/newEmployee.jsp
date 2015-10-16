<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!--<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    <ul>
	    <c:forEach items="${model.roles}" var="r">
			<li><c:out value="${r.name}"></c:out> </li>
		</c:forEach>
    </ul>
    <c:out value="${model.totalRoles}"></c:out>
  </body>
</html>-->

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Registration Form Template</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="Content/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Content/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="Content/css/form-elements.css">
        <link rel="stylesheet" href="Content/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="Content/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="Content/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="Content/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="Content/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="Content/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

		<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Bootstrap Registration Form Template</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<span class="li-text">
								Put some text or
							</span> 
							<a href="#"><strong>links</strong></a> 
							<span class="li-text">
								here, or some icons: 
							</span> 
							<span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a> 
								<a href="#"><i class="fa fa-twitter"></i></a> 
								<a href="#"><i class="fa fa-envelope"></i></a> 
								<a href="#"><i class="fa fa-skype"></i></a>
							</span>
						</li>
					</ul>
				</div>
			</div>
		</nav>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-7 text">
                            <h1><strong>Bootstrap</strong> Registration Form</h1>
                            <div class="description">
                            	<p>
	                            	This is a free responsive registration form made with Bootstrap. 
	                            	Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                            	</p>
                            </div>
                            <div class="top-big-link">
                            	<a class="btn btn-link-1" href="#">Button 1</a>
                            	<a class="btn btn-link-2" href="#">Button 2</a>
                            </div>
                        </div>
                        <div class="col-sm-5 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Sign up now</h3>
                            		<p>Fill in the form below to get instant access:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-pencil"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form:form action="/form" modelattribute="subscriber" method="post" class="registration-form"> <!-- <form role="form" action="" method="post" class="registration-form">-->
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-first-name">First name</label>
			                        	<input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-last-name">Last name</label>
			                        	<input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-email">Email</label>
			                        	<input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-role">Email</label>
			                        	<select name="form-role"  class="form-email form-control" id="form-role">
			                        		<option value="0">Select a role</option>
			                        		<c:forEach items="${model.roles}" var="r">
												<option value="<c:out value="${r.id}"></c:out>"><c:out value="${r.name}"></c:out> </option>
											</c:forEach>
			                        	</select>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-about-yourself">About yourself</label>
			                        	<textarea name="form-about-yourself" placeholder="About yourself..." 
			                        				class="form-about-yourself form-control" id="form-about-yourself"></textarea>
			                        </div>
			                        <button type="submit" class="btn">Sign me up!</button>
			                    </form:form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="Content/js/jquery-1.11.1.min.js"></script>
        <script src="Content/bootstrap/js/bootstrap.min.js"></script>
        <script src="Content/js/jquery.backstretch.min.js"></script>
        <script src="Content/js/retina-1.1.0.min.js"></script>
        <script src="Content/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="Content/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>