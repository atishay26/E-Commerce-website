import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class NetbankServlet extends HttpServlet
{
	Connection c=null;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		String cardno=req.getParameter("cardno");
		String bankname=req.getParameter("bankname");
		String name=req.getParameter("name");

		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		try
		{
			ServletContext sc=getServletContext();
			String val=sc.getInitParameter("poolconnect");
			String val1=sc.getInitParameter("contextconnect");
			if (val.equals("yes"))
			{
				InitialContext itx=new InitialContext();

				DataSource ds=(DataSource)itx.lookup("tindey");
				c=ds.getConnection();
			}
			if (val1.equals("yes"))
			{
				c=(Connection)sc.getAttribute("con");
			}
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from bank where cardno='"+cardno+"'and name='"+name+"'");

			if (rs.next())
			{
				out.println("Matched");
				out.println("<h1>Thankyou for Buying. Happy Shopping..!!!</h1>");
				out.println("<h2>Payment Completed..!!</h2>");
				res.setHeader("Refresh","4;welcome.html");
			}

			else
			{
				out.println("<h2><Invalid Details. Try Again..!!</h2>");
				res.setHeader("Refresh","3;netbank.html");
			}
			c.close();
		}
		catch (Exception e)
		{
			out.println(e);
		}
		out.println("</body></html>");
	}
}