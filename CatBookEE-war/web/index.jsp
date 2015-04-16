<!DOCTYPE html>
<%
    //Falta editar. Comprobar si ID (en este caso email temporalmente) está en la sesión. Si es así, salta al perfil del usuario.
    try{
    if(!session.getAttribute("email").equals(null))
        response.sendRedirect("Purrfile");
    }catch(Exception e)
    {}
%>
<html>
    <head>
        <title>CatBook - Social Network</title>
        <!-- CSS bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <!-- CSS CatBook -->
        <link rel="stylesheet" type="text/css" href="css/catstyle.css">
        <!-- Google roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:100' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="divrightbg"></div>
        <div class="divlogo">
            <img src="images/cat-icon-login.png">
            <p align="center" class="logotext">CatBook</p>
        </div>
         <div class="divformlogin">
            <form class="form-horizontal" action="CatLogin" method="post">
                <!-- <label style="color:#F55" class="form-group">User does not exist / wrong password</label> -->
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="Email" autofocus>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">Sign in</button>
                </div>
            </form>
        </div>  
    </body>
</html>
