
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2152688902826659767L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        MysqlCon databaseCon = new MysqlCon("webdevcw", "root", "");
//        Statement statement = databaseCon.getStatement();
    	
    	Connection connection;
     	int id = 1;
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        int remember = 1;
        
        String username = name.split(" ")[0];

        System.out.println(name+" - "+password+" - "+email);
    	
        System.out.print("Ola pessoal");
        
    	try {
    		String sql = "INSERT INTO users(name, username, password, email, remember, id) VALUES(?, ?, ?, ?, ?, ?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/webdevcw", "root", "");
		    PreparedStatement pstmt = connection.prepareStatement(sql);
		    
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, email);
            pstmt.setInt(5, remember);
            pstmt.setInt(6, id);
            
            pstmt.executeUpdate();	    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
