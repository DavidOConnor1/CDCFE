/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqllab;
import java.io.File;
import java.sql.*;

public class SqlLab {

    public static void start(){
        String fileName = sqllab.Lab.dbName.getText(); //gets the DB name from the textbox
        String Dir = sqllab.Lab.dblocation.getText(); //gets the DB location from the textbox
        
        new File(Dir).mkdir(); //creates the folder were the DB will be saved.
        String url = "jdbc:sqlite:" + Dir + fileName; //creates a URL for the database
        
        try { //loads driver into memory, just one way of doing it
            Class.forName("org.sqlite.JDBC").newInstance(); 
          } catch (Exception ex) {
        }//end try catch
        
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) { //if the connection is not null 
                sqllab.Lab.dbButton.setText("The database has been created."); //change the text on the create DB button
            }//end if
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //println for catching error, popup would be better
        }//end try catch

                //string to be passes as a statement, creates the table warehouses
                String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity integer\n"
                + ");";
        
        //Makes a connection called conn to the url created earlier
        //may not be needed again if used already, no harm in retrying
        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) { //makes a statement object called stmt
        stmt.execute(sql); //passes the sql string statement to stmt
        } catch (SQLException e) {
        System.out.println(e.getMessage()); //println for catching error, popup would be better
        }//end try catch
            
        Statement stmt = null; //clear stmt after first usage
        //Makes a connection called conn to the url created earlier
        //may not be needed again if used already, no harm in retrying
        try {Connection conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
        //add to warehouses table
        stmt.executeUpdate("INSERT INTO warehouses " + "VALUES (1001, 'Apple', 2435)");
        stmt.executeUpdate("INSERT INTO warehouses " + "VALUES (1002, 'Pear', 1456)");
        stmt.executeUpdate("INSERT INTO warehouses " + "VALUES (1003, 'grape', 5778)");
        stmt.executeUpdate("INSERT INTO warehouses " + "VALUES (1004, 'kiwi', 5778)");
        stmt.executeUpdate("INSERT INTO warehouses " + "VALUES (1005, 'orange', 5778)");
        } catch (SQLException e) {
            System.out.print(e); //println for catching error, popup would be better
        }//end try catch  
    } // close start
    
   
    
    
    
    
    public static void main(String[] args) {
        start();
        
    }
    
}
