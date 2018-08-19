import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegisterFilter implements Filter
{
	FilterConfig config;
	Connection c=null;
	public void init(FilterConfig config)throws ServletException
	{
		this.config=config;
	}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException
	{
		PrintWriter out=res.getWriter();
		String userId=req.getParameter("userId");
		String pass=req.getParameter("pass");
		String repass=req.getParameter("repass");
		String name=req.getParameter("name");
		String ph=req.getParameter("phone");
		final String to,subject,body,id,passw;

	if (pass.equals(repass))
	{
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
			}
			else
			{
				ResultSet rs1=st.executeQuery("select * from customer_id");
				rs1.next();
				int j=rs1.getInt(1)+1; 
				String jj=String.valueOf(j);
				PreparedStatement ps=c.prepareStatement("insert into cust(userId,pass,custid,name,phone_no) values(?,?,?,?,?)");
				ps.setString(1,userId);
				ps.setString(2,pass);
				ps.setString(3, jj);
				ps.setString(4,name);
				ps.setString(5,ph);
				ps.executeQuery();

				PreparedStatement ps1=c.prepareStatement("update customer_id set custid="+j);
				ps1.executeUpdate();
				out.println("<html><body><br><h1><Registered Successfully!! login now</h1>");
				out.println("<br><h2>login page reloading... </h2></body></html>");
				to=userId;
				subject="ShoppingHippo Welcomes You";
				body="Start your shopping with a ease";
				id="project.atishay@gmail.com"; 
				passw="servletproject";

				Properties props = System.getProperties(); 
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.smtp.host","smtp.gmail.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port","587");
				props.put("mail.smtp.starttls.required","true");

				java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
				Session sess = Session.getInstance(props,new javax.mail.Authenticator() 
					{
						protected PasswordAuthentication getPasswordAuthentication() 
						{
							return new PasswordAuthentication(id,passw);
						}
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
					transport.connect("smtp.gmail.com",id,passw);
					transport.sendMessage(message,message.getAllRecipients());
					transport.close();
				}
				catch (Exception e){}
				HttpServletResponse rss=(HttpServletResponse)res;
				rss.setHeader("Refresh","4;index.html");
				//RequestDispatcher rd=req.getRequestDispatcher("/registered");
				//rd.forward(req,res);
			}
			c.close();
		}
		catch(Exception e){out.println(e);}
	}
	else
	{
		out.println("<html><body><br><h1>Password and Reentered Password didnot match!!Try Again</h1>");
		out.println("<br><h2><Registration page Reloading..</h2></body></html>");
		HttpServletResponse rss=(HttpServletResponse)res;
		rss.setHeader("Refresh","4;register.html");
	}

	}
	public void destroy(){}
}

