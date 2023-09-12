package Lab1.src;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  

/*
 * 
 * From https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.htm
 * 
 */

public class H2jdbcCreateScoreTable { 
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:tcp://localhost/~/test"; //   
   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = ""; 
  
   public static void main(String[] args) { 
      Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql = "CREATE TABLE quiz_takers " + 
         "(id INTEGER not NULL AUTO_INCREMENT, " + 
         " first VARCHAR(255), " + 
         " last VARCHAR(255), " + 
         " age INTEGER, " + 
         " PRIMARY KEY ( id ))";
         // String sql = "CREATE TABLE questions " + 
         // "(id INTEGER not NULL AUTO_INCREMENT, " + 
         // " question VARCHAR(1024), " + 
         // " a VARCHAR(1024), " + 
         // " b VARCHAR(1024), " + 
         // " c VARCHAR(1024), " + 
         // " d VARCHAR(1024), " + 
         // " e VARCHAR(1024), " + 
         // " Answer VARCHAR(1024), " + 
         // " explanation VARCHAR(1024), " +
         // " PRIMARY KEY ( id ))";

         // String sql =  "CREATE TABLE   score " + 
         //    "(id INTEGER not NULL AUTO_INCREMENT, " + 
         //    " usr varchar(255), " +  
         //    " questions_total INTEGER, " +  
         //    " questions_answered INTEGER, " + 
         //    " questions_correct INTEGER, " + 
         //    " PRIMARY KEY ( id ))";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
}
