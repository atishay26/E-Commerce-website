import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class CartServlet extends HttpServlet
{
	boolean b;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);

		if (session!=null)
		{
			Enumeration<String> e=session.getAttributeNames();
			while (e.hasMoreElements())
			{
				String name=(String)e.nextElement();
				Object value=session.getAttribute(name);
				//out.println(value.toString());
			}

			String[] mobiles=(String[])session.getAttribute("mobiles");
			String[] laptops=(String[])session.getAttribute("laptops");
			String[] watches=(String[])session.getAttribute("watches");
			String[] mens=(String[])session.getAttribute("mens");
			String[] womens=(String[])session.getAttribute("womens");
			String[] cars=(String[])session.getAttribute("cars");


			String[] mobilep=(String[])session.getAttribute("mobilep");
			String[] laptopp=(String[])session.getAttribute("laptopp");
			String[] watchp=(String[])session.getAttribute("watchp");
			String[] menp=(String[])session.getAttribute("menp");
			String[] womenp=(String[])session.getAttribute("womenp");
			String[] carp=(String[])session.getAttribute("carp");

			out.println("<html><body bgcolor='aliceblue'>");
			out.println("<font color='blue' size='4'><a href='welcome.html' style='text-decoration:none'><b>back</a></font>");
			out.println("<h2 align='center'><font color='Red' size='10'>CART</font></h2>");
			out.println("<hr><br>");
			out.println("<table cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
			out.println("<form method='post' action='cart1'>");
			out.println("<tr align='center'><td><font color='red' size='6'> Product Type </font></td><td><font color='red' size='6'> Product Name </font></td><td><font color='red' size='6'> Quantity </font></td><td><font color='red' size='6'>Price/per unit</font></td></tr>"); 


			if (mobiles!=null)
			{
				out.println("<tr>");
				out.println("<th text align='center'><font color='blue' size='4'>Mobiles</font></th>");
				b=true;
				for (int m=0;m<mobiles.length;m++)
				{
					if (b==false)
						out.println("<th>   </th>");
					out.println("<td>"+mobiles[m]+"</td>");
					out.println("<td><select name='mobilelist"+m+"'><option value='0'>0</option><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
					out.println("<td>"+mobilep[m]+"</td>");
					//out.println("<td><button type='submit' name='"+mobiles[m]+"' value='"+mobiles[m]+"' >remove</button></td>");
					out.println("</tr>");
					b=false;
				}
			}
			if (laptops!=null)
			{
				out.println("<tr>");
				out.println("<th text align='center'><font color='blue' size='4'>Laptops</font></th>");
				b=true;
				for (int m=0;m<laptops.length;m++)
				{
					if (b==false)
						out.println("<th>   </th>");
					out.println("<td>"+laptops[m]+"</td>");
					out.println("<td><select name='laptoplist"+m+"'><option value='0'>0</option><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
					out.println("<td>"+laptopp[m]+"</td>");
					//out.println("<td><button type='submit' name='"+laptops[m]+"' value='"+laptops[m]+"' >remove</button></td>");
					out.println("</tr>");

					b=false;
				}
			}

			if (watches!=null)
			{
				out.println("<tr>");
				out.println("<th text align='center'><font color='blue' size='4'>Watches</font></th>");
				b=true;
				for (int m=0;m<watches.length;m++)
				{
					if (b==false)
						out.println("<th>   </th>");
					out.println("<td>"+watches[m]+"</td>");
					out.println("<td><select name='watchlist"+m+"'><option value='0'>0</option><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
					out.println("<td>"+watchp[m]+"</td>");
					//out.println("<td><button type='submit' name='"+watches[m]+"' value='"+watches[m]+"' >remove</button></td>");
					out.println("</tr>");
					b=false;
				}
			}

			if (mens!=null)
			{
				out.println("<tr>");
				out.println("<th text align='center'><font color='blue' size='4'>Mens Clothing</font></th>");
				b=true;
				for (int m=0;m<mens.length;m++)
				{
					if (b==false)
						out.println("<th>   </th>");
					out.println("<td>"+mens[m]+"</td>");
					out.println("<td><select name='menlist"+m+"'><option value='0'>0</option><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
					out.println("<td>"+menp[m]+"</td>");
					//out.println("<td><button type='submit' name='"+mens[m]+"' value='"+mens[m]+"' >remove</button></td>");
					out.println("</tr>");
					b=false;
				}
			}

			if (womens!=null)
			{
				out.println("<tr>");
				out.println("<th text align='center'><font color='blue' size='4'>Womens Clothing</font></th>");
				b=true;
				for (int m=0;m<womens.length;m++)
				{
					if (b==false) 
						out.println("<th>   </th>");
					out.println("<td>"+womens[m]+"</td>");
					out.println("<td><select name='womenlist"+m+"'><option value='0'>0</option><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
					out.println("<td>"+womenp[m]+"</td>");
					//out.println("<td><button type='submit' name='"+womens[m]+"' value='"+womens[m]+"' >remove</button></td>");
					out.println("</tr>");
					b=false;
				}
			}

			if (cars!=null)
			{
				out.println("<tr>");
				out.println("<th text align='center'><font color='blue' size='4'>Cars</font></th>");
				b=true;
				for (int m=0;m<cars.length;m++)
				{
					if (b==false)
						out.println("<th>   </th>");
					out.println("<td>"+cars[m]+"</td>");
					out.println("<td><select name='carlist"+m+"'><option value='0'>0</option><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td>");
					out.println("<td>"+carp[m]+"</td>");
					//out.println("<td><button type='submit' name='"+cars[m]+"' value='"+cars[m]+"' >remove</button></td>");
					out.println("</tr>");
					b=false;
				}
			}

			out.println("</table>");
			out.println("<br><br><input type='submit' size='15' name='buy' value='Buy Now'>");
			out.println("</form>");

		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.forward(req,res);
		}
	}
}
