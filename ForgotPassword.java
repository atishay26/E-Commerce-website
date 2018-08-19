import java.util.Properties;
//import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class ForgotPassword extends HttpServlet 
{
	Connection c=null;
	Statement st=null;
	ResultSet rs=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession();
		final String to,subject,body,id,pass;
		String email=req.getParameter("userId");
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
			rs=st.executeQuery("select pass from cust where userId='"+email+"'");
			boolean b=rs.next();
			if(b==false)
			{
				session.setAttribute("dnt_exist", "dnt_exist");
				res.sendRedirect("index.html"); 
			}           
			else if(b==true)
			{
				to=email;
				subject="password recovery";
				body="Your password is "+rs.getString(1);
				id="project.atishay@gmail.com";
				pass="servletproject";

				Properties props = System.getProperties();
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.smtp.host","smtp.gmail.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port","587");
				props.put("mail.smtp.starttls.required","true");

				java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
				Session sess = Session.getInstance(props,new javax.mail.Authenticator()
												{
													protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(id,pass);}
												}
												);
				sess.setDebug(false);

				try
				{
					MimeMessage message = new MimeMessage(sess);
					message.setFrom(new InternetAddress(id));
					message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
					message.setSubject(subject);
					message.setText(body);
					Transport transport=sess.getTransport("smtp");
					transport.connect("smtp.gmail.com",id,pass);
					transport.sendMessage(message,message.getAllRecipients());
					transport.close();
				}
				catch(MessagingException e)
				{
					out.print("connect to internet first");
					throw new RuntimeException(e);
				}
				session.setAttribute("msg_sent", "msg_sent");
				res.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			 session.setAttribute("msg_sent_fail", "msg_sent_fail");
			 res.sendRedirect("index.html");
		} 
		finally
		{
			try
			{
			   c.close();
			}
			catch(Exception e){}
		}
	}
}
 

