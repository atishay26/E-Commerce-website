import java.sql.*;
import java.util.StringTokenizer;
import java.io.*;
import javax.naming.*;
import javax.sql.*;
import javax.servlet.ServletContext;

public class TableCreate
{
public static void createTable(String path)
{

try
{
FileInputStream fn=new FileInputStream(path);
byte br[]=new byte[fn.available()];
fn.read(br);
fn.close();
String data=new String(br);

StringTokenizer str=new StringTokenizer(data,"/");

InitialContext ctx=new InitialContext();

DataSource ds=(DataSource)ctx.lookup("tindey");
Connection con=ds.getConnection();
Statement stm=con.createStatement();

while(str.hasMoreTokens())
{
String query=str.nextToken();
if(query.trim().equals("stop"))
{
break;
}
stm.executeUpdate(query);
System.out.println(query);
}
con.close();
}
catch (Exception e){}
}

public static void createTab(String path,Connection c)
{

try
{
FileInputStream fn=new FileInputStream(path);
byte br[]=new byte[fn.available()];
fn.read(br);
fn.close();
String data=new String(br);

StringTokenizer str=new StringTokenizer(data,"/");

Statement stm=c.createStatement();

while(str.hasMoreTokens())
{
String query=str.nextToken();
if(query.trim().equals("stop"))
{
break;
}
stm.executeUpdate(query);
System.out.println(query);
}
}
catch (Exception e){}
}
}