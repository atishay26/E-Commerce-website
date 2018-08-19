import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Laptop1 extends HttpServlet
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
String c1=req.getParameter("DellAlienware");
String c2=req.getParameter("IBM");
String c3=req.getParameter("HP");
String c4=req.getParameter("Mac");
String c5=req.getParameter("buy");

if (c5!=null)
{
String[] laptops=req.getParameterValues("laptop");

String[] laptopp=new String[laptops.length];
List<String> l=Arrays.asList(laptops);
if (l.contains("DellAlienware"))     {  laptopp[a]="270000";        a++;   } 
if (l.contains("IBM"))               {  laptopp[a]="43700";         a++;   }
if (l.contains("HP"))                {  laptopp[a]="156000";        a++;   }
if (l.contains("Mac"))               {  laptopp[a]="257000";        a++;   } 
session.setAttribute("laptopp",laptopp);   
session.setAttribute("laptops",laptops);
res.sendRedirect("welcome.html");
}
out.println("<html><body bgcolor='aliceblue'>");
out.println("<font color='blue' size='4'><a href='laptop.html' style='text-decoration:none'><b>back</a></font>");
if (c1!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c1+"</font></h2>");
out.println("<p align='center'><img src='images/laptop1.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c2!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c2+"</font></h2>");
out.println("<p align='center'><img src='images/laptop2.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c3!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c3+"</font></h2>");
out.println("<p align='center'><img src='images/laptop3.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c4!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c4+"</font></h2>");
out.println("<p align='center'><img src='images/laptop4.jpg' style='border:1px solid black;' height='250' width='250'>");
}
out.println("<hr><br>");
out.println("<font size='5'>Specificatons  :</font>");
out.println("<table align='center' cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
out.println("<th text align='center'><font color='blue' size='4'>Model</font></th>");
if (c1!=null)
{
s1="Intel i7";
s2="Window 10 Home,64-Bit";
s3="1TB Storage";
s4="17.2 inch FHD(1920x1080)";
s5="16GB";
s6="1 Year OnsiteSupport";
s7="Red,Blue,Black";
s8="Alienware";
s9="2.7 lakh";
}
if (c2!=null)
{
s1="Intel i5";
s2="Window 10 Home,64-Bit";
s3="500GB Storage";
s4="11.6 inch FHD(1920x1080)";
s5="8GB";
s6="1 Year Service-Station Support";
s7="Red,Blue";
s8="ThinkPad";
s9="43.7 thousand";
} 
if (c3!=null)
{
s1="Intel i7";
s2="Window 10 Professional,64-Bit";
s3="512GB Storage";
s4="14.3 HD(1920x1080)";
s5="16GB";
s6="1 Year HomesiteSupport";
s7="Red,Blue,Black,Grey";
s8="Spectra";
s9="1.56 lakh";
} 
if (c4!=null)
{
s1="Intel Corei7";
s2="Mac OS";
s3="512GB Storage";
s4="15 HD Display";
s5="16GB";
s6="1 Year";
s7="Red,Black";
s8="MacBook Pro MLW";
s9="2.57 lakh";
}  
out.println("<td text align='center'>"+s8+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Processor</font></th><td text align='center'>"+s1+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Operating System</font></th><td text align='center'>"+s2+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Hard Drive</font></th><td text align='center'>"+s3+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Display</font></th><td text align='center'>"+s4+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>RAM</font></th><td text align='center'>"+s5+"</td></tr>");
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
