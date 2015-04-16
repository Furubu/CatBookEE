<%
    try{
    //Temporalmente esta el atributo como email, cambiar a ID cuando se cree la base de datos
    session.removeAttribute("email");
    }catch(NullPointerException e){}
    
    response.sendRedirect("index.jsp");
%>
