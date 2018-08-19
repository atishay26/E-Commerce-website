import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Car1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		int a=0;
		if (session!=null)
		{
			String c1=req.getParameter("Porsche");
			String c2=req.getParameter("Lamborghini");
			String c3=req.getParameter("Bugatti");
			String c4=req.getParameter("Spyder");
			String c5=req.getParameter("buy");

			if (c5!=null)
			{
				String[] cars=req.getParameterValues("car");

				String[] carp=new String[cars.length];
				List<String> l=Arrays.asList(cars);
				if (l.contains("Porsche"))    
					{  carp[a]="24000000";
						a++;
					} 
				if (l.contains("Lamborghini")) 
					{
						carp[a]="55000000";
						a++;  
					}
				if (l.contains("Bugatti"))
					{
						carp[a]="120000000";
						a++;
					}
				if (l.contains("Spyder"))
					{
						carp[a]="100000000";
						a++;
					} 
				session.setAttribute("carp",carp);   
				session.setAttribute("cars",cars);
				res.sendRedirect("welcome.html");
			}
			out.println("<html><body bgcolor='aliceblue'>");
			out.println("<font color='blue' size='4'><a href='car.html' style='text-decoration:none'><b>back</a></font>");
			if (c1!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c1+"</font></h2>");
				out.println("<p align='center'><img src='images/car1.jpg' style='border:1px solid black;' height='250' width='250'>");
			}
			if (c2!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c2+"</font></h2>");
				out.println("<p align='center'><img src='images/car2.jpg' style='border:1px solid black;' height='250' width='250'>");
			}
			if (c3!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c3+"</font></h2>");
				out.println("<p align='center'><img src='images/car3.jpg' style='border:1px solid black;' height='250' width='250'>");
			}

			if (c4!=null)
			{
				out.println("<h2 align='center'><font color='Red' size='10'>"+c4+"</font></h2>");
				out.println("<p align='center'><img src='images/car4.jpg' style='border:1px solid black;' height='250' width='250'>");
			}
			out.println("<hr><br>");
			out.println("<font size='5'>Specificatons  :</font>");
			out.println("<table align='center' cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
			out.println("<th text align='center'><font color='blue' size='4'>Model</font></th>");
			if (c1!=null)
			{
				out.println("<td text align='center'>Boxster</td></tr></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Engine</font></th><td text align='center'>flat-4</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Horsepower @ RPM</font></th><td text align='center'>300 @ 6500</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Displacement</font></th><td text align='center'>2.0 L</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Top Speed</font></th><td text align='center'>170 mph</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>0-60</font></th><td text align='center'>4.9 sec</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Torque @ RPM</font></th> <td text align='center'>280</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Color</font></th><td text align='center'>Jet Black</td></tr></table><br><hr><br>");
			}

			if (c2!=null)
			{
				out.println("<td text align='center'>Anentador</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Engine</font></th><td text align='center'>6498</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Horsepower @ RPM</font></th><td text align='center'>300 @ 6000</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Displacement</font></th><td text align='center'>2.2 L</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Top Speed</font></th><td text align='center'>170 mph</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>0-100</font></th><td text align='center'>2.9 sec</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Torque @ RPM</font></th> <td text align='center'>550</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Color</font></th><td text align='center'>Levis Grey</td></tr></table><br><hr><br>");
			}

			if (c3!=null)
			{
				out.println("<td text align='center'>Veyron</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Engine</font></th><td text align='center'>7993</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Horsepower @ RPM</font></th><td text align='center'>1250 @ 5500</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Displacement</font></th><td text align='center'>1.7 L</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Top Speed</font></th><td text align='center'>220 mph</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>0-100</font></th><td text align='center'>2.5 sec</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Torque @ RPM</font></th> <td text align='center'>600</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Color</font></th><td text align='center'>Black</td></tr></table><br><hr><br>");
			}

			if (c4!=null)
			{
				out.println("<td text align='center'>Porsche</td>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Engine</font></th><td text align='center'>7500</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Horsepower @ RPM</font></th><td text align='center'>1000 @ 5500</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Displacement</font></th><td text align='center'> --</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Top Speed</font></th><td text align='center'>190 mph</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>0-60</font></th><td text align='center'>4.0 sec</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Torque @ RPM</font></th> <td text align='center'>300</td></tr>");
				out.println("<tr><th text align='center'><font color='blue' size='4'>Color</font></th><td text align='center'>--</td></tr></table><br><hr><br>");
			}

			out.println("<font size='5'>Price:</font><h2 text align='center'>Prices In Top Cities</h2>");
			out.println("<table align='center' cellspacing='1' cellpadding='10' width='500' border='1'><tr><th text align='center'>City</th><th text align='center'>Ex-Showroom price</th></tr>");

			if (c1!=null)
			{
				out.println("<tr><td text align='center'><font color='blue'>New Delhi</font></td><td text align='center'>Rs.2.40 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Hyderabad</td><td text align='center'>Rs.2.42 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Mumbai</td><td text align='center'>Rs.2.39 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Banglore</td><td text align='center'>Rs.2.45 cr onwards</td></tr>");
			}
			if (c2!=null)
			{
				out.println("<tr><td text align='center'><font color='blue'>New Delhi</font></td><td text align='center'>Rs.5.50 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Hyderabad</td><td text align='center'>Rs.5.70 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Mumbai</td><td text align='center'>Rs 5.50 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Banglore</td><td text align='center'>Rs.5.60 cr onwards</td></tr>");
			}
			if (c3!=null)
			{
				out.println("<tr><td text align='center'><font color='blue'>New Delhi</font></td><td text align='center'>Rs.12 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Hyderabad</td><td text align='center'>Rs.12.5 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Mumbai</td><td text align='center'>Rs.12.42 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Banglore</td><td text align='center'>Rs.12.40 cr onwards</td></tr>");
			}
			if (c4!=null)
			{
				out.println("<tr><td text align='center'><font color='blue'>New Delhi</font></td><td text align='center'>Rs.10 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Hyderabad</td><td text align='center'>Rs.9.8 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Mumbai</td><td text align='center'>Rs.10.12 cr onwards</td></tr>");
				out.println("<td text align='center'><font color='blue'>Banglore</td><td text align='center'>Rs.10.00 cr onwards</td></tr>");
			}
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
