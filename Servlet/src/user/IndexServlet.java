package user;

import core.Request;
import core.Response;
import core.Servlet;

public class IndexServlet implements Servlet {
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
        String uname = request.getParameter("uname");
        String[] favs = request.getParameterValues("fav");
        response.println("名字为"+uname);
        response.println("爱好：");
        for (String v:favs){
            if (v.equals(0)){
                response.print("1");
            }else if (v.equals("1")){
                response.print("2");
            } else if (v.equals("2")){
                response.print("3");
            }
        }
        response.print("<body>");
        response.print("</html>");
    }
}
