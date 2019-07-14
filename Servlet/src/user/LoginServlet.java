package user;

import core.Request;
import core.Response;
import core.Servlet;

public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        response.print("<title>");
        response.print("服务器响应成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("正文"+request.getParameter("uname"));
        response.print("</body>");
        response.print("</html>");
    }

}
