import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class jdbcTest {
	
	  public static void main(String[] args) throws Exception {
		  jdbcTest dao = new jdbcTest();
		    dao.readDataBase();
		    }
	
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/research knowledge manager?"
              + "user=root&password=");
      statement = connect.createStatement();
      resultSet = statement.executeQuery("select * from file");
      
      while(resultSet.next()) {
    	  
      String FileName = resultSet.getString("filename");
      System.out.println(FileName);
      
      }
      
      
      preparedStatement = connect
              .prepareStatement("insert into file (filename,directory,filetype) values ('a','b','c')");
          // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
          // Parameters start with 1
          //preparedStatement.setString(1, "a");
          //preparedStatement.setString(2, "b");
          //preparedStatement.setString(3, "c");
          preparedStatement.executeUpdate();
          
    } catch (Exception e) {
      throw e;
    

  }

  }

} 