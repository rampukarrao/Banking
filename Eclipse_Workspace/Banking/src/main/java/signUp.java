import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.*;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.*;


/**
 * 
 */

/**
 * @author rampu
 *
 */
public class signUp {
	public void init(ServletConfig f) {}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("userName");
		String email=req.getParameter("userEmail");
		String contact=req.getParameter("contactNumber");
		String pass=req.getParameter("userPass");
		try 
		{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		  PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
		  ps.setString(1, name);
		  ps.setString(2, email);
		  ps.setString(3, pass);
		  ps.setString(4, contact);
		  ps.executeUpdate();
		  RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		 dispatcher.forward(req, res);
		 pw.println("<alert> Hey! "+name+"<br> You are registerd Please! login </alert>");
		 ps.close();
		}
		catch(Exception e)
		{}
		
	
		String getServletInfo()
		{
			return(null);
		}
		public ServletConfig getServletConfig()
		{
			return(null);
		}
	}
}
