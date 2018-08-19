import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LogoutServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
HttpSession session=req.getSession(false);
if (session!=null)
session.invalidate();

RequestDispatcher rd=req.getRequestDispatcher("/index.html");
rd.forward(req,res);
out.println("</body></html");
}
}