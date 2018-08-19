import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.sql.*;

public class Account extends HttpServlet 
{
	Connection c=null;
	ResultSet rs=null;
	Statement st=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession(false);
		String custid1=session.getAttribute("custid").toString();
		String fname= req.getParameter("fname");      
		String lname= req.getParameter("lname");      
		String ph_no= req.getParameter("ph_no"); 
		String name= fname+" "+lname;
		try
		{
			ServletContext sc=getServletContext();
			String val=sc.getInitParameter("poolconnect");
			String val1=sc.getInitParameter("contextconnect");
			if (val.equals("yes"))
			{
				InitialContext ctx=new InitialContext();

				DataSource ds=(DataSource)ctx.lookup("jains");
				c=ds.getConnection();
			}
			if (val1.equals("yes"))
			{
				c=(Connection)sc.getAttribute("con");
			}
			PreparedStatement ps1=c.prepareStatement("update cust set name='"+name+"', phone_no='"+ph_no+"' where custid='"+custid1+"'");
			ps1.executeUpdate();
			res.sendRedirect("welcome.html");
		}catch(Exception e){} 
		finally
		{
			try
			{
				c.close();
			}catch(Exception e){}
		}
	}
}

   