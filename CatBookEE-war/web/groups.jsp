<%-- 
    Document   : groups
    Created on : 16-abr-2015, 11:09:52
    Author     : antonio
--%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="cat.entity.Usercb"%>
<%@page import="cat.entity.Groupcb"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- CSS bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <!-- Custom CSS -->
        <link href="css/purrfile.css" rel="stylesheet" type="text/css" >
        
        <title> Grupos </title>
    </head>

    <body>
        <jsp:include page="navbar.jsp" >
            <jsp:param name="active" value="Purrfile"></jsp:param>
        </jsp:include>
        
        <%
            List<Groupcb> groups = (List<Groupcb>) request.getAttribute("groups");
            Usercb user = (Usercb) request.getAttribute("user");
        %>
    <body>
           <header>
            <center> <h1> Grupos </h1> </center>
            </br></br>
        </header>
        <section>
            <center>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                        <td>Nombre del grupo</td>
                        <td>Miembros</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Groupcb grupo : groups) {
                        %>
                        <tr>
                        <td><%= grupo.getNombre() %></td>
                        <td><%= grupo.getUsercbCollection().size() %></td>
                        </tr>
                        <%              
                            }
                        %>
                    </tbody>
                </table>
            </center>
        </section>
    </body>
</html>
