<%@page import="cat.entity.Usercb"%>
<%@page import="cat.entity.Postcb"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- CSS bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <!-- Custom CSS -->
        <link href="css/purrfile.css" rel="stylesheet" type="text/css" >
        
        </head>

    <body>
        <jsp:include page="navbar.jsp" >
            <jsp:param name="active" value="Purrfile"></jsp:param>
        </jsp:include>

        <%
            List<Postcb> posts = (List<Postcb>) request.getAttribute("posts");
            Usercb user = (Usercb) request.getAttribute("user");
        %>

        <header>
            <center> <h1> Purrfile </h1> </center>
            <br></br>
            <h2> <%= user.getName()%> <%= user.getSurname()%></h2>
        </header>
        <br></br>


        <section>
            <center>
                <form name="newPost" action="NewPostServlet" method="post">
                    <h2> New Post <img src="images/pawn.png" alt="pawn" style="margin-left: 10px; width:30px; height:30px"></h2>
                    <textarea class="form-control" style="width:400px; height: 150px"></textarea>

                    <button class="btn" style="margin-right: 10px; margin-top: 15px"> Post! </button>
                    <button class="btn" style="margin-left: 10px; margin-top: 15px">
                        <span class="glyphicon glyphicon-picture" aria-hidden="true"></span> Add image
                    </button>
                </form>
            </center>
        </section>

        <aside>
            <center>
                <h2> Dashboard </h2>
                <ul class="list-group" >
                    <%
                        for (Postcb post : posts) {

                    %>   
                    <li class="list-group-item">
                        <h4 class="list-group-item-heading"><%= post.getTexto()%></h4>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </center>
        </aside>
    </body>
</html>