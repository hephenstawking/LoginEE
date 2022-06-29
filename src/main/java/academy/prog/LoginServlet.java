package academy.prog;

import jakarta.servlet.http.*;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";
    static final String PASS = "$dm1nistrA";
    static final int AGE = 18;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        int age = parseInt(request.getParameter("age"));
        HttpSession session = request.getSession(true);

        if (age < AGE) {
            String agePerm = "Denied";
            session.setAttribute("user_age", agePerm);
        } else {
            if (validatePassword(password) == false) {
                String passCheck = "notMatch";
                session.setAttribute("user_pass_req", passCheck);
            } else {
                if (LOGIN.equals(login) && PASS.equals(password)) {
                    session.setAttribute("user_login", login);
                }
            }
        }

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");
            session.removeAttribute("user_age");
            session.removeAttribute("user_pass_req");

        response.sendRedirect("index.jsp");
    }

    protected Boolean validatePassword (String password) {
        return password.matches("^(?=.*[~!@#$%^&*()_+`\\-=\\[\\]\\{\\};':\\\",./<>?])(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\S{10,}$");
    }
}
