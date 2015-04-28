<%@page import="java.util.List;"%>
<%@page import="entity.*;"%>
<%@page import="java.util.Collection;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Usercb> listaEncontrados;
    listaEncontrados = (List<Usercb>) request.getAttribute("matchList");
%>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <title>Catbook: Search results</title>
    </head>

    <!-- get users -->

    <body>
        <jsp:include page="navbar.jsp" >
            <jsp:param name="active" value="Purrfile"></jsp:param>
        </jsp:include>
        <h1 style="margin-left: 15%">Search results</h1>
       <form action="FriendSearch" method="Post" style="margin-bottom: 2%; margin-top: 2%;">
            <table border="0" style="margin-left: 15%; text-align:center;" > 
                <tr>
                    <td>
                        <input type="text" class="form-control" name="searchText" value=""/>
                    </td>
                    <td colspan="2">
                        <input type="submit" class="btn btn-primary btn-sl" name="btnSearchFriend" value="Search friend" style="margin-left: 5%;"/>
                    </td>  
                </tr>
            </table>
        </form>
        <table class="table table-striped" style="max-width:70%; border: 1px solid #dddddd;" align=center >
            <tbody>

                <tr>
                    <td><b>Picture</b></td> <!-- Profile picture -->
                    <td><b>Name</b></td> <!-- Name -->
                    <td><b>&nbsp;</b></td> <!-- Add -->
                </tr>
                <%    for (Usercb friend : listaEncontrados) {
                %>
                <tr>
                    <td><img src="<%=friend.getPicture()%>" class="img-circle"></td>
                    <td><%= friend.getName() + " " + friend.getSurname()%> </td> 

                    <td>
                        <form action="FriendAdd" method="post">
                            <input type="hidden" name="friendId" value="<%= friend.getId()%>">
                            <button type="submit" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add
                            </button>
                        </form>
                    </td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <br>
    </body>
</html>