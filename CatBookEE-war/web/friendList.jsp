<%@page import="java.util.List;"%>
<%@page import="entity.*;"%>
<%@page import="java.util.Collection;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Usercb> listaAmigos;
    listaAmigos = (List<Usercb>) request.getAttribute("listaAmigos");

    List<Usercb> listaBloqueados;
    listaBloqueados = (List<Usercb>) request.getAttribute("listaBloqueados");

%>
   
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <title>Catbook: My friends</title>
    </head>

    <body>
        <jsp:include page="navbar.jsp" >
            <jsp:param name="active" value="Purrfile"></jsp:param>
        </jsp:include>
        <h1 style="margin-left: 15%">My friends</h1>
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
                    <td><b>Blocked</b></td> <!-- Blocked -->
                    <td><b>&nbsp;</b></td> <!-- Block -->
                    <td><b>&nbsp;</b></td> <!-- Delete -->
                </tr>
                <%    for (Usercb friend : listaAmigos) {
                %>
                <tr>
                    <td><img src="<%=friend.getPicture()%>" class="img-circle"></td>
                    <td><%= friend.getName() + " " + friend.getSurname()%> </td>

                    <%
                        if (listaBloqueados.contains(friend)) {
                    %>

                    <td><input type="checkbox" name="blocked" value="true" disabled checked/></td>
                    <td>
                        <form action="FriendUnblock" method="Post">
                            <input type="hidden" name="friendId" value="<%=friend.getId()%>">
                            <button type="submit" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> Unblock
                            </button>
                        </form>
                    </td> 
                    <%
                    } else {
                    %>
                    <td><input type="checkbox" name="blocked" value="true" disabled/></td>
                    <td>
                        <form action="FriendBlock" method="post">
                            <input type="hidden" name="friendId" value="<%=friend.getId()%>">
                            <button type="submit" class="btn btn-warning btn-sm">
                                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Block
                            </button>
                        </form>
                    </td> 
                    <%
                        }
                    %>   

                    <td>
                        <form action="FriendDelete" method="post">
                            <input type="hidden" name="friendId" value="<%= friend.getId()%>">
                            <button type="submit" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Delete
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