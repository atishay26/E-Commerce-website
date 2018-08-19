import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ApplicationInitializer extends HttpServlet
{
public void init(javax.servlet.ServletConfig sc)throws javax.servlet.ServletException
{
ServletContext ctx=sc.getServletContext();
Connection c=(Connection)ctx.getAttribute("con");
String s1=ctx.getInitParameter("poolconnect");
//String s2=ctx.getInitParameter("contextconnect");
String val=ctx.getInitParameter("oracletab");
String oracle=ctx.getRealPath("WEB-INF//dbtable/oracletable.txt");

if (val.equals("yes"))
{
if (s1.equals("yes"))
{
TableCreate.createTable(oracle);
System.out.println("TableSuccesfully Created via connection pool");
}
else
{
TableCreate.createTab(oracle,c);
System.out.println("TableSuccesfully Created via context");
}
}
}
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
}
}