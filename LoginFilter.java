import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class LoginFilter implements Filter
{
	FilterConfig config;
	Connection c=null;
	public void init(FilterConfig config)throws ServletException
	{
		this.config=config;
	}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException
	{
		String userId=req.getParameter("userId");
		String pass=req.getParameter("pass");
		PrintWriter out=res.getWriter();

		try
		{
			ServletContext sc=config.getServletContext();
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
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from cust where userId='"+userId+"'and pass='"+pass+"'");
			if (rs.next())
			{
				chain.doFilter(req,res);
				HttpServletResponse rss=(HttpServletResponse)res;
				rss.setHeader("Refresh","0;welcome.html");
			}
			else
			{
				out.println("<html><body><h2>Information Didnot Match..!!</h2></body></html>");
				HttpServletResponse rss=(HttpServletResponse)res;
				rss.setHeader("Refresh","2;index.html");
				//RequestDispatcher rd=req.getRequestDispatcher("/index.html");
				//rd.forward(req,res);
			}
			c.close();
		}catch(Exception e){out.println(e);}
	}
	public void destroy(){}
}