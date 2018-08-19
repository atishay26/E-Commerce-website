import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Women1 extends HttpServlet
{
	String s1,s2,s3,s4,s5,s6;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		int a=0;
		if (session!=null)
		{
			String c1=req.getParameter("Gucci");
			String c2=req.getParameter("forever21");
			String c3=req.getParameter("levis");
			String c4=req.getParameter("louisphilippe");
			String c5=req.getParameter("buy");

			if (c5!=null)
			{
				String[] womens=req.getParameterValues("women");

				String[] womenp=new String[womens.length];
				List<String> l=Arrays.asList(womens);
				if (l.contains("Gucci"))
				{
					womenp[a]="1749";
					a++;   
				} 
				if (l.contains("forever21"))
				{  
					womenp[a]="2099";
					a++;   
				}
				if (l.contains("levis"))
				{  
					womenp[a]="2251";
					a++;
				}
				if (l.contains("louisphilippe"))
				{  
					womenp[a]="2399";
					a++;
				} 
				session.setAttribute("womenp",womenp);   
				session.setAttribute("womens",womens);
				res.sendRedirect("welcome.html");
			}
			out.println("<html><body bgcolor='aliceblue'>");
			out.println("<font color='blue' size='4'><a href='women.html' style='text-decoration:none'><b>back</a></font>");
			if (c1!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c1+"</font></h2>");
				out.println("<p align='center'><img src='images/women1.jpg' style='border:1px solid black;' height='250' width='250'>");
			}

			if (c2!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c2+"</font></h2>");
				out.println("<p align='center'><img src='images/women2.jpg' style='border:1px solid black;' height='250' width='250'>");
			}

			if (c3!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c3+"</font></h2>");
				out.println("<p align='center'><img src='images/women3.jpg' style='border:1px solid black;' height='250' width='250'>");
			}

			if (c4!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c4+"</font></h2>");
				out.println("<p align='center'><img src='images/women4.jpg' style='border:1px solid black;' height='250' width='250'>");
			}
			out.println("<hr><br>");
			out.println("<font size='5'>Specificatons  :</font>");
			out.println("<table align='center' cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
			out.println("<th text align='center'><font color='blue' size='4'>Model</font></th>");
			
			if (c1!=null)
			{
				s1="100% Cotton";
				s2="--";
				s3="white";
				s4="Sleeves";
				s5="1,749";
				s6="Bo714BRS3R";
			}
			if (c2!=null)
			{
				s1="Cotton";
				s2="--";
				s3="Black";
				s4="Long Sleeves";
				s5="2,099";
				s6="Bo11NSu1L";
			} 
			if (c3!=null)
			{
				s1="100% Cotton";
				s2="--";
				s3="Light Black";
				s4="Sleeves";
				s5="2,251";
			s6="Bo1N4H&&Wq";
			} 
			if (c4!=null)
			{
				s1="100% Cotton";
				s2="--";
				s3="Royal Blue";
				s4="Sleeves";
				s5="2,399";
				s6="Bo1N95PIUO";
			}  
			out.println("<td text align='center'>"+s6+"</td></tr>");
			out.println("<tr><th text align='center'><font color='blue' size='4'>Material</font></th><td text align='center'>"+s1+"</td></tr>");
			out.println("<tr><th text align='center'><font color='blue' size='4'>Size Available</font></th><td text align='center'>"+s2+"</td></tr>");
			out.println("<tr><th text align='center'><font color='blue' size='4'>Color</font></th><td text align='center'>"+s3+"</td></tr>");
			out.println("<tr><th text align='center'><font color='blue' size='4'>Sleeve or Sleeveless</font></th><td text align='center'>"+s4+"</td></tr>");
			out.println("<tr><th text align='center'><font color='blue' size='4'>Price</font></th><td text align='center'>"+s5+"</td></tr>");

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
