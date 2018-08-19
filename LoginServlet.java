import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class LoginServlet extends HttpServlet
{
	Connection c=null;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String custid="";
		int j=0;
		String userId=req.getParameter("userId");
		String pass=req.getParameter("pass");

		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			ServletContext sc=getServletContext();
			String val=sc.getInitParameter("poolconnect");
			String val1=sc.getInitParameter("contextconnect");
			if (val.equals("yes"))
			{
				InitialContext ctx=new InitialContext();

				DataSource ds=(DataSource)ctx.lookup("tindey");
				c=ds.getConnection();
			}
			if (val1.equals("yes"))
			{
				c=(Connection)sc.getAttribute("con");
			}

			HttpSession session=req.getSession();
			session.setAttribute("userId",userId);
			session.setAttribute("pass",pass);
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select userId,pass,custid from cust");
			while(rs.next())
			{
				if(rs.getString(1).equals(userId) && rs.getString(2).equals(pass))
				{
				   j=1;
				   custid=rs.getString("custid");
				   break;
				}
			}
			if(j==1)
			{
			  session.setAttribute("custid", custid);
			  
			}
		}catch (Exception e){out.println(e);}
	}
}