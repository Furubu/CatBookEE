<nav class="navbar navbar-inverse">
    <ul class="nav navbar-nav">
        <li role="presentation" <% if(request.getParameter("active").equals("Purrfile")) out.print("class=\"active\""); %>><a href="/purrfile.jsp">Purrfile</a></li>
        <li role="presentation" <% if(request.getParameter("active").equals("About")) out.print("class=\"active\""); %>><a href="#">About</a></li>
        <li role="presentation" <% if(request.getParameter("active").equals("Friends")) out.print("class=\"active\""); %>><a href="#">Friends</a></li>
        <li role="presentation" <% if(request.getParameter("active").equals("Groups")) out.print("class=\"active\""); %>><a href="#">Groups</a></li>       
    </ul>
    <div align = "right" style="margin-right: 10px; margin-top: 5px">
        <form action="logout.jsp">
            <button type="submit" class="btn">Logout</button> 
        </form>
    </div>
</nav>