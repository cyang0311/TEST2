package user;

import core.Request;
import core.Response;
import core.Servlet;

public class OtherServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("其它页面");
    }
}
