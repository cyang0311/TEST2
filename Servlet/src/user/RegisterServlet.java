package user;

import core.Request;
import core.Response;
import core.Servlet;

public class RegisterServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        response.print("<title>");
        response.print("注册");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        String uname = request.getParameter("uname");
        String[] favs = request.getParameterValues("fav");
        response.println("名字为"+uname);
        response.println("爱好：");
        for (String v:favs){
            if (v.equals("0")){
                response.print("一");
            }else if (v.equals("1")){
                response.print("二");
            } else if (v.equals("2")){
                response.print("三");
            }
        }
        response.print("<body>");
        response.print("</html>");
    }
}
