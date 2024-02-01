/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqllab;
    import java.sql.*;
/**
 *
 * @author student
 */
public class DBQueries {
    public static String url ="jdbc:sqlite:c:/mydb/";    

     static String count(){ 
        String x = null; // string value to be returned from method call 
        //try and make a connection to the DB using the gloabal URL variable 
        //The connection and statements objects might be better if global? 
        try (Connection conn = DriverManager.getConnection(url)){ 
          String count = "SELECT COUNT(*) FROM warehouses"; //string query called count 
          //Statement – Used to execute string-based SQL queries 
          Statement st1 = conn.createStatement(); 
          ResultSet rs1 = st1.executeQuery(count); //result set from query 
          while (rs1.next()) //rs is result set, use while to iterate through it 
          { 
            String mycount = rs1.getString(1); //get string from location 1 in RS 
            x = mycount; // assign string from location 1 in RS to x 
          } //end while 
          st1.close(); //close statement, may not be needed, probably a good thing to do 
        } //end try catch 
        catch (Exception e) 
        { 
          System.err.println("Got an exception! "); //println for catching error, popup would be better 

          System.err.println(e.getMessage()); //println for catching error, popup would be better 
        }
        return x; // value to be returned from method call
    } //end count method 

       static String average(){   
    String x = null; // string value to be returned from method call 
        //try and make a connection to the DB using the gloabal URL variable 
        //The connection and statements objects might be better if global? 
        try (Connection conn = DriverManager.getConnection(url)){ 
          String avg = "SELECT AVG(capacity) FROM warehouses"; //string query called avg 
          Statement st2 = conn.createStatement(); 
          ResultSet rs2 = st2.executeQuery(avg); //result set from query 
          while (rs2.next()) //rs2 is result set, use while to iterate through it 
          { 
            String itemavg = rs2.getString(1); //get string from location 1 in rs2 
            x = itemavg; // assign string from location 1 in RS to x 
          } 
          st2.close(); //close statement, may not be needed, probably a good thing to do 
        } 
        catch (Exception e) 
        { 
          System.err.println("Got an exception! "); //println for catching error, popup would be better 
          System.err.println(e.getMessage()); //println for catching error, popup would be better 
        } 
        return x; // value to be returned from method call 
    }//end verage method 
          }