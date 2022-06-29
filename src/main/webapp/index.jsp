<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Prog Academy</title>
  </head>
  <body>
    <%
        String login = (String)session.getAttribute("user_login");
        String agePerm = (String)session.getAttribute("user_age");
        String userPassReq = (String)session.getAttribute("user_pass_req");
        String empty = (String)session.getAttribute("empty");
    %>

    <% if (empty != null) {
    %>
    <h1>You have to fill all data to log in</h1>
    <br>Click this link to back to the <a href="/login?z=exit">login page</a>
    <% } else {


        if (userPassReq != null) {
            %>
            <h1>You didn't passed password requirements!</h1>
            <br>Click this link to back to the <a href="/login?z=exit">login page</a>
            <%
        } else {
            if (agePerm == null || "".equals(agePerm)) {
            if (login == null || "".equals(login)) {
    %>
            <form action="/login" method="POST">
                Login: <input type="text" name="login"><br>
                Password: <input type="password" name="password"><br>
                Age: <input type="text" name="age"><br>
                <input type="submit" />
            </form>
            <% } else {
            %>
                <h1>You are logged in as: <%= login %></h1>
                <br>Click this link to <a href="/login?a=exit">logout</a>
    <%          }
            } else {
                %>
                    <h1>You are not allowed to visit this site!</h1>
                    <br>Click this link to back to the <a href="/login?z=exit">login page</a>
                <%
            }
        }
    }
    %>
  </body>
</html>
