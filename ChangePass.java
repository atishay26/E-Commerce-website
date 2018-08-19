import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.sql.*;

public class ChangePass extends HttpServlet 
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

		String oldpass= req.getParameter("old_pass");      
		String newpass= req.getParameter("new_pass");      
		String renewpass= req.getParameter("re_new_pass"); 

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
			st=c.createStatement();
			rs=st.executeQuery("select * from cust where custid='"+custid1+"'");
			//out.println(rs.getString(1));
			rs.next();
			if (rs.getString(2).equals(oldpass))
			{
				PreparedStatement ps1=c.prepareStatement("update cust set pass='"+newpass+"' where custid='"+custid1+"'");
				ps1.executeUpdate();
				res.sendRedirect("welcome.html");
			}
			else
			{
				out.println("<html><body><h2> Old password  mismatch </h2></body></html>");
				HttpServletResponse rss=(HttpServletResponse)res;
				rss.setHeader("Refresh","2;changepass.html");
			}

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