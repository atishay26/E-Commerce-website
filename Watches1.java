import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Watches1 extends HttpServlet
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
String c1=req.getParameter("Gucci");
String c2=req.getParameter("Armani");
String c3=req.getParameter("Rado");
String c4=req.getParameter("Rolex");
String c5=req.getParameter("buy");

if (c5!=null)
{
String[] watches=req.getParameterValues("watch");

String[] watchp=new String[watches.length];
List<String> l=Arrays.asList(watches);
if (l.contains("Gucci"))           {  watchp[a]="15284";      a++;   } 
if (l.contains("Armani"))     {  watchp[a]="20795";      a++;   }
if (l.contains("Rado"))     {  watchp[a]="4999";        a++;   }
if (l.contains("Rolex"))            {  watchp[a]="6495";        a++;   } 
session.setAttribute("watchp",watchp);   
session.setAttribute("watches",watches);
res.sendRedirect("welcome.html");
}
out.println("<html><body bgcolor='aliceblue'>");
out.println("<font color='blue' size='4'><a href='watches.html' style='text-decoration:none'><b>back</a></font>");
if (c1!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c1+"</font></h2>");
out.println("<p align='center'><img src='images/watch1.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c2!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c2+"</font></h2>");
out.println("<p align='center'><img src='images/watch2.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c3!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c3+"</font></h2>");
out.println("<p align='center'><img src='images/watch3.jpg' style='border:1px solid black;' height='250' width='250'>");
}

if (c4!=null)
{
out.println("<h2 align='center'><font color='Red' size='10'>"+c4+"</font></h2>");
out.println("<p align='center'><img src='images/watch4.jpg' style='border:1px solid black;' height='250' width='250'>");
}
out.println("<hr><br>");
out.println("<font size='5'>Specificatons  :</font>");
out.println("<table align='center' cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
out.println("<th text align='center'><font color='blue' size='4'>Model</font></th>");
if (c1!=null)
{
s1="Brown";
s2="Metal";
s3="13 mm";
s4="luminous,measures-seconds";
s5="Quartz";
s6="6 Month";
s7="330 Feet";
s8="B00G3LST76";
s9="15,284";
}
if (c2!=null)
{
s1="Silver";
s2="Stainless Steel";
s3="41 mm";
s4="screw-down-crown,shock-resistant,water-resistant";
s5="Quartz";
s6="--";
s7="165 Meters";
s8="B00404KCGY";
s9="20,795";
} 
if (c3!=null)
{
s1="White";
s2="Ion Plated";
s3="35 mm";
s4="--";
s5="Quartz";
s6="2 Year Support";
s7="50 Meters";
s8="B00GRRIZK2";
s9="4,999";
} 
if (c4!=null)
{
s1="Green";
s2="Stainless Steel";
s3="44 mm";
s4="--";
s5="Quartz";
s6="1 Year";
s7="100 Meters";
s8="B004LPOYRA";
s9="6,495";
}  
out.println("<td text align='center'>"+s8+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Band Color</font></th><td text align='center'>"+s1+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Case Material</font></th><td text align='center'>"+s2+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>CaseThickness</font></th><td text align='center'>"+s3+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Special Features</font></th><td text align='center'>"+s4+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Movement</font></th><td text align='center'>"+s5+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Warranty</font></th> <td text align='center'>"+s6+"</td></tr>");
out.println("<tr><th text align='center'><font color='blue' size='4'>Water Resistance Depth</font></th><td text align='center'>"+s7+"</td></tr>");
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
