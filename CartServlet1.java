import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class CartServlet1 extends HttpServlet
{
	boolean b;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);

		if (session!=null)
		{
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

			String mobilelist[]=new String[4];
			mobilelist[0]=req.getParameter("mobilelist0");
			mobilelist[1]=req.getParameter("mobilelist1");
			mobilelist[2]=req.getParameter("mobilelist2");
			mobilelist[3]=req.getParameter("mobilelist3");

			String laptoplist[]=new String[4];
			laptoplist[0]=req.getParameter("laptoplist0");
			laptoplist[1]=req.getParameter("laptoplist1");
			laptoplist[2]=req.getParameter("laptoplist2");
			laptoplist[3]=req.getParameter("laptoplist3");

			String watchlist[]=new String[4];
			watchlist[0]=req.getParameter("watchlist0");
			watchlist[1]=req.getParameter("watchlist1");
			watchlist[2]=req.getParameter("watchlist2");
			watchlist[3]=req.getParameter("watchlist3");

			String menlist[]=new String[4];
			menlist[0]=req.getParameter("menlist0");
			menlist[1]=req.getParameter("menlist1");
			menlist[2]=req.getParameter("menlist2");
			menlist[3]=req.getParameter("menlist3");

			String womenlist[]=new String[4];
			womenlist[0]=req.getParameter("womenlist0");
			womenlist[1]=req.getParameter("womenlist1");
			womenlist[2]=req.getParameter("womenlist2");
			womenlist[3]=req.getParameter("womenlist3");

			String carlist[]=new String[4];
			carlist[0]=req.getParameter("carlist0");
			carlist[1]=req.getParameter("carlist1");
			carlist[2]=req.getParameter("carlist2");
			carlist[3]=req.getParameter("carlist3");


			out.println("<html><body bgcolor='aliceblue'>");
			out.println("<font color='blue' size='4'><a href='cart' style='text-decoration:none'><b>back</a></font>");
			out.println("<h2 align='center'><font color='Red' size='10'>Proceed For Payment</font></h2>");
			out.println("<hr><br>");
			out.println("<table cellspacing='1' cellpadding='10' width='850' border='1'><tr>");
			out.println("<tr align='center'><td><font color='red' size='6'> Product Type </font></td><td><font color='red' size='6'> Product Name </font></td><td><font color='red' size='6'> Quantity </font></td><td><font color='red' size='6'>Total Price(in Rs)</font></td></tr>"); 

			int k,l,j=0;
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
					out.println("<td>"+ mobilelist[m] +"</td>");
					k=Integer.parseInt(mobilelist[m]);
					l=Integer.parseInt(mobilep[m]);
					j+=k*l;
					out.println("<td>"+String.valueOf(k*l)+"</td>");
					out.println("</tr>");
					b=false;
				}
			}

			if (laptops!=null){
			out.println("<tr>");
			out.println("<th text align='center'><font color='blue' size='4'>Laptops</font></th>");
			b=true;
			for (int m=0;m<laptops.length;m++)
			{
				if (b==false)
					out.println("<th>   </th>");
				out.println("<td>"+laptops[m]+"</td>");
				out.println("<td>"+ laptoplist[m] +"</td>");
				k=Integer.parseInt(laptoplist[m]);
				l=Integer.parseInt(laptopp[m]);
				j+=k*l;
				out.println("<td>"+String.valueOf(k*l)+"</td>");
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
					out.println("<td>"+ watchlist[m] +"</td>");
					k=Integer.parseInt(watchlist[m]);
					l=Integer.parseInt(watchp[m]);
					j+=k*l;
					out.println("<td>"+String.valueOf(k*l)+"</td>");
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
				out.println("<td>"+ menlist[m] +"</td>");
				k=Integer.parseInt(menlist[m]);
				l=Integer.parseInt(menp[m]);
				j+=k*l;
				out.println("<td>"+String.valueOf(k*l)+"</td>");
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
				out.println("<td>"+ womenlist[m] +"</td>");
				k=Integer.parseInt(womenlist[m]);
				l=Integer.parseInt(womenp[m]);
				j+=k*l;
				out.println("<td>"+String.valueOf(k*l)+"</td>");
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
				out.println("<td>"+ carlist[m] +"</td>");
				k=Integer.parseInt(carlist[m]);
				l=Integer.parseInt(carp[m]);
				j+=k*l;
				out.println("<td>"+String.valueOf(k*l)+"</td>");
				out.println("</tr>");
				b=false;
			}
		}

		out.println("</table>");
		//session.setAttribute("j",j);
		out.println("<p size='15'>Total Amount to pay: <h2><font color='blue'>"+j+" Rs.</font></h2>");
		out.println("<br><br><a href='netbank.html'><input type='submit' size='30' value='Pay'></a>");

		}

		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.forward(req,res);
		}
	}
}
