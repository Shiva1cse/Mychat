package chatter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init()throws ServletException
    {
    	
    }
	protected void doGet( final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		try {
				DataBaseConnection db=new DataBaseConnection();
				Connection con = null;
				try {
					con = db.CreateConenction();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String msg_query="Select * from messages";
				Statement st=con.createStatement();
			   		        	   
						ResultSet rs=st.executeQuery(msg_query);
						String myData ="                                           Welcome To Chatter\n";
						while(rs.next())
						{
							myData=myData+(rs.getString("msg")+"\n");
    						
						}
						con.close();
						HttpSession session=request.getSession();  
				        session.setAttribute("uname",myData); 
						//System.out.println(rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			    
			
		
		/**/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost( final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {		
		try {
			DataBaseConnection db=new DataBaseConnection();
			Connection con=db.CreateConenction();
			String Name=request.getParameter("ChatterName");
			//System.out.print(Name);
			PreparedStatement ps=con.prepareStatement("Insert into chat(name)Values(?)");
			ps.setString(1, Name);
			int rs=ps.executeUpdate();
			//String Create_query="Create table "+Name+"(messages varchar(400) not null);";
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate(Create_query);
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//System.out.println("dsd");		
	}
	}

