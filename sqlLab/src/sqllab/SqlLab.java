/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqllab;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;

public class SqlLab {

    public static String fileName = sqllab.Lab.dbName.getText();
    public static String Dir = sqllab.Lab.dblocation.getText();
    public static String url = "jdbc:sqlite:" + Dir + fileName;
    
    
    public static void start(){
       
        
        new File(Dir).mkdir(); //creates the folder were the DB will be saved.
       
        
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
    
    
    public static void viewBTN(){
        secondFrame.dbTable.setText(null);
        secondFrame.dbTable.append("ID \t Name \t Capacity \n");
          
           try (Connection conn = DriverManager.getConnection(url)) { 

            //Statement – Used to execute string-based SQL queries 

            Statement stmt = conn.createStatement(); 

            ResultSet rs = stmt.executeQuery("SELECT * FROM warehouses"); //get everything from table, result set 

            while(rs.next()){ //rs is result set, use while to iterate through it 

                String id = rs.getString("ID"); // get id from rs 

                String name = rs.getString("Name"); //get name from rs 

                String capacity = rs.getString("Capacity"); //get capacity from rs 

                secondFrame.dbTable.append(id + "\t" + name + "\t" + capacity +"\n"); // for every entry in the table append to text area 

            }//end while     

        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null,(e.getMessage())); //if there is an error a popup is issued 
        }//end try catch 
    }
    
    public static void searchBTN(){
           try (Connection conn = DriverManager.getConnection(url)){   

            String str = secondFrame.IDField.getText();   

            //PreparedStatement – Used to execute parameterized SQL queries 

            PreparedStatement st = conn.prepareStatement("select * from warehouses where id=?");   

            st.setString(1, str); //pass id string to statement, why 1? multiple statements? location? 

            //Excuting Query   

            ResultSet rs = st.executeQuery(); //get result set rs by executing the Prepared Statement 

            if (rs.next()) { //iterate rs 

                String s = rs.getString(1); //get id from rs, save as s  

                String s1 = rs.getString(2); //get name from rs, save as s1  

                String s2 = rs.getString(3); //get capacity from rs, save as s2 

                //Sets Records in TextFields.   

                secondFrame.IDField.setText(s); //set id in textbox   

                secondFrame.NameField.setText(s1);  //set name in textbox  

                secondFrame.CAPField.setText(s2);  //set capacity in textbox  

            } else {   

                JOptionPane.showMessageDialog(null, "ERROR"); //error getting rs 

            } //end if else   

            //Create Exception Handler   

        } catch (Exception e) {   

            JOptionPane.showMessageDialog(null,(e.getMessage())); //error from try 

        }//end try catch 
    }//search button end
    
    
    
    
    public static void insertBTN(){
         try (Connection conn = DriverManager.getConnection(url)){   

            //Statement – Used to execute string-based SQL queries 

            Statement statement = conn.createStatement(); 

            //maybe statement.execute? executeUpdate also works 

            statement.executeUpdate("INSERT INTO warehouses VALUES(" + secondFrame.IDField.getText() + ",'" + secondFrame.NameField.getText() + "'," + secondFrame.CAPField.getText() + ")"); 

            JOptionPane.showMessageDialog(null, "Record inserted..."); //let user know  

            statement.close(); // close statement, may not be needed, probably a good thing to do 

            conn.close(); //close statement, may not be needed, probably a good thing to do 

        } catch (Exception e) {   

            JOptionPane.showMessageDialog(null,(e.getMessage())); //show message, good for testing, not user friendly  

        } //end try catch 
    }//end insert 
    
    
     public static void clearBTN(){
        secondFrame.IDField.setText(null);
           secondFrame.NameField.setText(null);
              secondFrame.CAPField.setText(null);
              //this will clear all the fields
    }
     
     
     public static void updateBTN(){
         
            try (Connection conn = DriverManager.getConnection(url)){  

            //Statement – Used to execute string-based SQL queries 

            Statement statement = conn.createStatement(); 

            //maybe statement.executeUpdate? execute also works 

            statement.execute("UPDATE warehouses SET name='" + secondFrame.NameField.getText() + "',capacity=" + secondFrame.CAPField.getText() + " WHERE id=" + secondFrame.IDField.getText() + ""); 

            JOptionPane.showMessageDialog(null, "Record updated..."); //let user know 

            statement.close(); // close statement, may not be needed, probably a good thing to do  

            conn.close(); //close statement, may not be needed, probably a good thing to do 

        } catch (Exception e) {   

            JOptionPane.showMessageDialog(null,(e.getMessage())); //show real error message, good for testing, not user friendly  

        } //end try catch 
     } //end update 
     
     
    public static void deleteBTN(){
         try (Connection conn = DriverManager.getConnection(url)){  
            //Statement – Used to execute string-based SQL queries 
            Statement statement = conn.createStatement(); 
            //maybe statement.execute? executeUpdate also works 
            statement.executeUpdate("DELETE FROM warehouses WHERE id=" + secondFrame.IDField.getText() + "");   
            JOptionPane.showMessageDialog(null, "Record deleted..."); //let user know 
            statement.close(); // close statement, may not be needed, probably a good thing to do  
            conn.close(); //close statement, may not be needed, probably a good thing to do 
        } catch (Exception e) {   
            JOptionPane.showMessageDialog(null,(e.getMessage())); //show real error message, good for testing, not user friendly 
        } //end try catch 
    } //end delete button
    
      public static void query(){
        String total = DBQueries.count(); //run count query from DBQueries.java file in project package 
        secondFrame.totalItems.setText(total);  
        String itemaverage = DBQueries.average(); //run average query from DBQueries.java file in project package 
        secondFrame.averageItems.setText(itemaverage); 
        //close queries button 
      }
    
    
    
    
    public static void main(String[] args) {
        start();
   
        
    }
    
}
