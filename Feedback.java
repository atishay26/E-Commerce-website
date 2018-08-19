import java.io.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.sql.*;

public class Feedback extends HttpServlet 
{
Connection c=null;
ResultSet rs=null;
Statement st=null;
public void doPost(HttpServletRequest req, HttpServletResponse res)   throws ServletException, IOException 
{
res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session=req.getSession(false);
        
String email= req.getParameter("userId");      
String message= req.getParameter("msg");

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
PreparedStatement ps1=c.prepareStatement("insert into feedback(email,msg,fdate) values(?,?,?)");
ps1.setString(1,email);
ps1.setString(2,message);
  Calendar cal=new GregorianCalendar();
        int dt=cal.get(Calendar.DATE);
        int mn=cal.get(Calendar.MONTH);
        int yr=cal.get(Calendar.YEAR);
        String month="";
        if(mn==0)
          month="JAN";
        else if(mn==1)
          month="FEB";
        else if(mn==2)
          month="MAR";
        else if(mn==3)
          month="APR";
        else if(mn==4)
          month="MAY";
        else if(mn==5)
          month="JUN";
        else if(mn==6)
          month="JUL";
        else if(mn==7)
          month="AUG";
        else if(mn==8)
          month="SEP";
        else if(mn==9)
          month="OCT";
        else if(mn==10)
          month="NOV";
        else if(mn==11)
          month="DEC";
        String date=dt+"-"+month+"-"+yr;
ps1.setString(3, date);
ps1.executeUpdate();
res.sendRedirect("welcome.html");
}
catch(Exception e){} 
             finally
             {
               try{
               c.close();}catch(Exception e){}
             }
}
}