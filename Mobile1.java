import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Mobile1 extends HttpServlet
{
	String s1,s2,s3,s4,s5,s6,s7,s8,s9;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		int a=0;
		if (session!=null)
		{
			String c1=req.getParameter("Iphone");
			String c2=req.getParameter("Galaxy Note2");
			String c3=req.getParameter("Sony XperiaZ");
			String c4=req.getParameter("MotoG");
			String c5=req.getParameter("buy");

		if (c5!=null)
		{
			String[] mobiles=req.getParameterValues("mobile");

			String[] mobilep=new String[mobiles.length];
			List<String> l=Arrays.asList(mobiles);
			if (l.contains("Iphone"))
			{
				mobilep[a]="12480";
				a++;
			} 
			if (l.contains("Galaxy Note2"))
			{
				mobilep[a]="9999";
				a++;
			}
			if (l.contains("Sony XperiaZ"))     
			{  
				mobilep[a]="32490";
				a++;   
			}
			if (l.contains("MotoG"))
			{  
				mobilep[a]="9999";
				a++;
			} 
			session.setAttribute("mobilep",mobilep);   
			session.setAttribute("mobiles",mobiles);
			res.sendRedirect("welcome.html");
		}
out.println("<html><body bgcolor='aliceblue'>");
out.println("<font color='blue' size='4'><a href='mobile.html' style='text-decoration:none'><b>back</a></font>");
if (c1!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c1+"</font></h2>");
out.println("<p align='center'><img src='images/mobile1.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c2!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c2+"</font></h2>");
out.println("<p align='center'><img src='images/mobile2.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c3!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c3+"</font></h2>");
out.println("<p align='center'><img src='images/mobile3.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c4!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c4+"</font></h2>");
out.println("<p align='center'><img src='images/mobile4.jpg' style='border:1px solid black;' height='250' width='250'>");
}
out.println("<hr><br>");
out.println("<font size='5'>Specificatons  :</font>");
out.println("<table align='center' cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
out.println("<th text align='center'><font color='blue' size='4'>Model</font></th>");
if (c1!=null)
{
s1="Dual Core";
s2="iOSv7";
s3="16GB";
s4="4 inches";
s5="1510 mAh";
s6="1 Year Support";
s7="Black";
s8="iPhone5c";
s9="12,480";
}
if (c2!=null)
{
s1="Octa Core";
s2="Android v4.3";
s3="32GB (64GB Expandable)";
s4="5.7 inches";
s5="3200 mAh";
s6="1 Year Support";
s7="Black";
s8="Samsung Galaxy Note2";
s9="9,999";
} 
if (c3!=null)
{
s1="Quad Core";
s2="Androidv4.1.2";
s3="16GB (32GB Expandable)";
s4="5 inches";
s5="2330 mAh";
s6="1 Year Support";
s7="Red,Black,Grey";
s8="Sony XperiaZ";
s9="32,490";
} 
if (c4!=null)
{
s1="Quad Core";
s2="Androidv4.1.1";
s3="16GB (32GB Expandable)";
s4="5 inches";
s5="3500 mAh";
s6="1 Year";
s7="White,Black";
s8="MotoG";
s9="9,999";
}  
out.println("<td text align='center'>"+s8+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Processor</font></th><td text align='center'>"+s1+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Operating System</font></th><td text align='center'>"+s2+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Memory</font></th><td text align='center'>"+s3+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Display</font></th><td text align='center'>"+s4+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Battery</font></th><td text align='center'>"+s5+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Warranty</font></th> <td text align='center'>"+s6+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Color</font></th><td text align='center'>"+s7+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Price</font></th><td text align='center'>"+s9+"</td></tr>");

out.println("</table><br><hr>");
out.println("</body></html>");
}
else
{
RequestDispatcher rd=req.getRequestDispatcher("/index.html");
rd.forward(req,res);
}
}
}
