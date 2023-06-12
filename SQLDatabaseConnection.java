import java.io.File;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JTable;

import net.efabrika.util.DBTablePrinter;


public class SQLDatabaseConnection {
	public static void main(String[] args) {
	        		
	        try {
	        	//1. Connection to database
	            String connectionUrl = "jdbc:sqlserver://localhost:13001;" +
	                    "databaseName=YOUR_DB_NAME;user=YOUR_USER;password=YOUR_PASS;";
	                    Connection con = DriverManager.getConnection(connectionUrl);
	                    long startTime = System.nanoTime();
	    	     //2. Create statement       
	             Scanner sc = new Scanner(new File("input2.txt"));
	             String input = "";
	             while (sc.hasNextLine()) {
	            	 	input += sc.nextLine()+"\n";
	             }
	             sc.close();
	            		
	             String query = input;

		         Statement myStmt = con.createStatement();
		         
	             //3. Exec SQL Query
	            ResultSet myRs = myStmt.executeQuery(query);
	            
	            //4. Process result set
	            /* Uses https://github.com/htorun/dbtableprinter
	             * DBTablePrinter is a Java utility class for printing rows 
	             * from a given database table or a java.sql.ResultSet to standard out, 
	             * formatted to look like a table with rows and columns with borders.
	             * credits to: https://github.com/htorun
	             */
	            
	            DBTablePrinter.printResultSet(myRs);
	        
	    
	            long endTime   = System.nanoTime();
                long totalTime = (endTime - startTime);
                System.out.println(totalTime + " ns");
                long totalInSec = totalTime / 1000000000;
                System.out.println(totalInSec + " seconds");
	            
	        }
	        catch (Exception exc) {
	            exc.printStackTrace();
	        }
	        
	   }
}
