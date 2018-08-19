import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.sql.*;

public class UpdateEmail extends HttpServlet 
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
		String newemailid= req.getParameter("new_email_id").trim();
		String oldpass=req.getParameter("old_pass");    

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
			st=c.createStatement();
			rs=st.executeQuery("select * from cust");
			int ext=0;
			while(rs.next())
			{
				if(rs.getString(1).equals(newemailid))
					ext=1;
			}
			if(ext==0)
			{
				PreparedStatement ps1=c.prepareStatement("update cust set userId='"+newemailid+"' where custid='"+custid1+"'");
				ps1.executeUpdate();
				res.sendRedirect("welcome.html");
			}
			else if(ext==1)
			{
				out.println("<html><body><h2> Email already Exist..!! Try Again </h2><body><html>");
				HttpServletResponse rss=(HttpServletResponse)res;
				rss.setHeader("Refresh","2;updateemail.html");
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

   
        