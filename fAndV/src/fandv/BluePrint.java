/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fandv;

import com.ibatis.common.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class BluePrint {
    
     
    public static  String url = "jdbc:sqlite:C:/myDB/fruit.db"; // creates the url for the database
    
      
   
    
       
     public static void scriptRunner()
     {  //Open Script Runner
        new File("c:/myDB/").mkdir();
            try
            {  //open try 
             
                DriverManager.registerDriver(new org.sqlite.JDBC());
                 Connection conn = DriverManager.getConnection(url);
                 ScriptRunner runner = new ScriptRunner(conn, false, false);
                 Reader reader = new BufferedReader(new FileReader("src/fandv/fruit.sql"));
                runner.runScript(reader);
                 JOptionPane.showMessageDialog(null,("Database & Table Created & Populated!"));
             
          
             } //end try
            catch(Exception e)
            {// open catch
                System.out.println(e);
             
                 JOptionPane.showMessageDialog(null,"Close the program and reopen the program you will then be able to add the DB");
                          
         } //end catch      
              } //end class
     
      
      public static void showDB()
      {//open show db
       System.out.println("HELP!!!!!!!!!!!!!!!!!!!");
           } //close show db
      
      
      public static void showStock()
      {//   open show stock
          
          Login.viewStock.setText(null);
          Login.viewStock.append("ID \t Name \t Cost \t date \t QTY \t description \t category \n");
          
          try (Connection conn = DriverManager.getConnection(url)) 
          {//   open try
              
            //Statement – Used to execute string-based SQL queries
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ProductTable"); //get everything from table, result set
            while(rs.next()){ //rs is result set, use while to iterate through it
                String id = rs.getString("ProductID"); // get id from rs
                String name = rs.getString("ProductName"); //get name from rs
                String cost = rs.getString("ProductCost"); //get capacity from rs
                String date = rs.getString("ProductExpDate");
                String QTY = rs.getString("ProductQty");
                String des = rs.getString("ProductDescription");
                String category = rs.getString("ProductCategory");
                
                System.out.println(id + "\t" + name + "\t" + cost +"\t"+date+"\t"+QTY+"\t"+des+"\t"+category+"\n"); // for every entry in the table append to text area
                Login.viewStock.append(id + "\t" + name + "\t" + cost +"\t"+date+"\t"+QTY+"\t"+des+"\t"+category+"\n");
            }//end while    
        } //end try
          catch (SQLException e) 
        {// open catch
            System.out.println(e.getMessage()); //if there is an error a popup is issued
        }//end try catch
      }//end show stock 
      
                    

            //View Staff Code!
      
  

    public static void viewStaff()
    {  //    open view staff
        Login.viewStaffArea.setText(null); //blank the text area
        Login.viewStaffArea.append("*********\nColleagues\n *********"); 
        Login.viewStaffArea.append("\n ID \t Name \t Address \t\t PostCode \t DOB \t Email \t Phone#  \n"); //set heading for table
        
        //try and make a connection to the DB using the gloabal URL variable
        //The connection and statements objects might be better if global?
        try (Connection conn = DriverManager.getConnection(url)) //     Establishes the connection to the database
        {//     open try
            //Statement – Used to execute string-based SQL queries
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ColleagueTable"); //get everything from table, result set
            
            while(rs.next()){ //rs is result set, use while to iterate through it
                String id = rs.getString("ColleagueID"); // get id from rs
                String name = rs.getString("ColleagueName"); //get name from rs
                String address = rs.getString("ColleagueAddress"); //get capacity from rs
                String post = rs.getString("ColleaguePostCode");
                String dob = rs.getString("ColleagueDOB");
                String email = rs.getString("ColleagueEmail");
                String phone = rs.getString("ColleaguePhoneNum");
                
                
                
                
                Login.viewStaffArea.append(id + "\t" + name + "\t" + address +"\t"+post+"\t"+dob+"\t"+email+"\t"+phone+"\n"); // for every entry in the table append to text area
            }//end while    
        } //    end try
        catch (SQLException e)
        {//     open catch
            JOptionPane.showMessageDialog(null,(e.getMessage())); //if there is an error a popup is issued
        }//end  catch

  }//end show staff
  
  
// View the admins code
  
   public static void viewAdmin()
   { //open view admin
        Login.viewStaffArea.append("*********\n ADMINS \n *********"); 
        Login.viewStaffArea.append("\n ID \t Name \t Address \t\t PostCode \t DOB \t Email \t Phone#  \n"); //set heading for table
        
        try (Connection conn = DriverManager.getConnection(url)) 
        {//     open try
            //Statement – Used to execute string-based SQL queries
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM AdminTable"); //get everything from table, result set
            while(rs.next())
            { //rs is result set, use while to iterate through it
                String id = rs.getString("AdminID"); // get id from rs
                String name = rs.getString("AdminName"); //get name from rs
                String address = rs.getString("AdminAddress"); //get capacity from rs
                String post = rs.getString("AdminPostCode");
                String dob = rs.getString("AdminDOB");
                String email = rs.getString("AdminEmail");
                String phone = rs.getString("AdminPhoneNum");
              
                Login.viewStaffArea.append(id + "\t" + name + "\t" + address +"\t"+post+"\t"+dob+"\t"+email+"\t"+phone+"\n"); // for every entry in the table append to text area
            }//end while    
        }// end try 
        catch (SQLException e) 
        {// open catch
            JOptionPane.showMessageDialog(null,(e.getMessage())); //if there is an error a popup is issued
        }//end try catch

  }//end show admin
  
// ADMIN Login PAGE
   
   
   public  boolean AdminLogin(String id, String email)
   { //open admin Login
       
       try (Connection conn = DriverManager.getConnection(url))
       { //open try
         //create a statement to query the table
           String query = "SELECT* From AdminTable WHERE AdminID = ? AND AdminEmail=?";
           PreparedStatement stmt = conn.prepareStatement(query);
           stmt.setString(1, id);
           stmt.setString(2, email);
           
           //execute the query to see if the user exists in the database
           ResultSet rs = stmt.executeQuery();
           if(rs.next()){ // open if 
               //close the statement & result set         
                              
               stmt.close();
               rs.close();
               JOptionPane.showMessageDialog(null, "Logged in"); //let user know 
               //closing the database connection
               conn.close();
               return true;
               
               
           } //end if
           else
           { //open else 
               stmt.close();
               rs.close();
               JOptionPane.showMessageDialog(null, "Incorrect ID OR EMAIL PLEASE TRY AGAIN!"); //let user know 
               return false;
               
           }//end else
       } //close try
       catch (SQLException ex)
       {//open catch 
           //handles the database connection error 
           ex.printStackTrace();
           return false;
       } //close catch
   } // close admin Login
   
   
   
   
   
   
   
   
  
//  Create customer code
  
  
public static void createCustomer()
    { //    create customer
       BluePrint ob = new BluePrint();
        int rand = ob.randomID(1, 10000);
      try(Connection conn = DriverManager.getConnection(url))
      {//   open try
          //used to grab string-based sql queieres
      
          String query = "insert into CustomerTable (CustomerID, CustomerFN, CustomerLN, CustomerEmail)values(?,?,?,?)";
          PreparedStatement pst = conn.prepareStatement(query);
          pst.setString(1, Integer.toString(rand)); //allows the user to set the ID for their account
          pst.setString(2, Login.FNField.getText()); //allows the user to set their name for their account
          pst.setString(3, Login.LNField.getText()); // allows the user to set their last name for their account
          pst.setString(4, Login.emailField.getText()); // allows the user to set their email for their account
          
          pst.executeUpdate();
          
          JOptionPane.showMessageDialog(null, "Record inserted..."); //let user know 
           
            
             } //   close try
                catch (Exception e)
             {  //  open catch
          JOptionPane.showMessageDialog(null,(e.getMessage())); // shows message
      }//end catch 
  }//end login customer

        // This allows me to view the customers and ensure that they're being added to the database

    public static void viewCustomer()
    {//open view customer
         Login.viewCus.append("*********\n Customers \n *********"); 
        Login.viewCus.append("\n ID \t Name \t Address \t\t PostCode \t DOB \t Email \t Phone#  \n"); //set heading for table
        
     
        try (Connection conn = DriverManager.getConnection(url)) 
        {//     open try
            //Statement – Used to execute string-based SQL queries
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CustomerTable"); //get everything from table, result set
            while(rs.next()){ //rs is result set, use while to iterate through it
                String id = rs.getString("CustomerID"); // get id from rs
                String name = rs.getString("CustomerFN"); //get name from rs
                String address = rs.getString("CustomerLN"); //get capacity from rs
                String post = rs.getString("CustomerEmail");
                String dob = rs.getString("CustomerStreetLine");
                String email = rs.getString("CustomerCity");
                String phone = rs.getString("CustomerPostCode");
                
                
                
                
                Login.viewCus.append(id + "\t" + name + "\t" + address +"\t"+post+"\t"+dob+"\t"+email+"\t"+phone+"\n"); // for every entry in the table append to text area
            }//end while    
        } //    end try
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,(e.getMessage())); //if there is an error a popup is issued
        }//end try catch
    }//     end view customer 
  
    
// Update customer code, this will allow customers to update their account details such as name, email, street line(address) & post code
    
    
    public static void updateCombo(JComboBox idBOX)
    { //open combo box
         try (Connection conn = DriverManager.getConnection(url)) 
         {//    OPEN TRY
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery("SELECT CustomerID FROM CustomerTable");
             
             List<String> ids = new ArrayList<>();
             
             //searches through the database and adds to each one
                while(rs.next()) // loops grabbing IDS 
                { //open while 
                    ids.add(rs.getString("CustomerID"));
                }//end while
               idBOX.setModel(new DefaultComboBoxModel(ids.toArray())); 
         }//end try 
         catch(SQLException ex)
         {//open catch
             JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
         }//end catch
    }//end combo box 
    
    
    public static void updateCombo1(JComboBox categoryBox)
    {//     Used for grabbing all of the categories in the Product table 
         try (Connection conn = DriverManager.getConnection(url)) //    establisihes the connection to the databse
         {//    Open try
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery("SELECT ProductCategory FROM ProductTable");
             
             List<String> ids = new ArrayList<>();
             
             //searches through the database and adds to each one
                while(rs.next()){
                    ids.add(rs.getString("ProductCategory"));
                }//end while
               categoryBox.setModel(new DefaultComboBoxModel(ids.toArray())); 
         } 
         catch(SQLException ex)
         {//open catch
             JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
         }//end catch
    }//end 
    
    
    
    //fill in fields combo box 
    
    public static void go()
    {//  open try
         String item = (String)Login.idBOX.getSelectedItem();
        String sql = "select * from CustomerTable where CustomerID = ?";
        
        try(Connection conn = DriverManager.getConnection(url))//   establishes the connection to the database
        {//     open try 
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, item);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Login.fnText.setText(rs.getString("CustomerFN"));
                 Login.lnText.setText(rs.getString("CustomerLN"));
                  Login.emailText.setText(rs.getString("CustomerEmail"));
                   Login.STField.setText(rs.getString("CustomerStreetLine"));
                    Login.cityField.setText(rs.getString("CustomerCity"));
                     Login.postField.setText(rs.getString("CustomerPostCode"));
                  
            }//end if 
       } //end try
       catch(SQLException ex)
       { //open catch
           JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
       }//end catch
    } //end go
    
    
    //  This method is used to display certain categories of stock in the display area
    
    public static void displayCertain(){
        Login.searchStock.setText(null);
        String item = (String)Login.categoryBox.getSelectedItem();
        String sql = "select * from ProductTable where ProductCategory = ?";
        try(Connection conn = DriverManager.getConnection(url)){
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, item);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
               String id = rs.getString("ProductID");
               String name = rs.getString("ProductName");
               String cost = rs.getString("ProductCost");
               String qty = rs.getString("ProductQty");
               String des = rs.getString("ProductDescription");
               String category = rs.getString("ProductCategory");
               
               Login.searchStock.append(id+"\t"+name+"\t"+cost+"\t"+qty+"\t"+des+"\t"+category+"\n");
                
            }//end if 
       } //end try
       catch(SQLException ex){ //open catch
           JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
       }//end catch
        
    }
    
    
    
    //this will allow the ids that are pulled to fill the fields
    
    
    
    
    public static void updateCustomer()
    {// open update
        String fn = Login.fnText.getText(); //allows the user to update their first Name 
          String ln =  Login.lnText.getText(); //allows the user to update their last name
          String email = Login.emailText.getText(); // allows the user to update their email
          String street = Login.STField.getText(); // allows the user to update the streeet line that they live on
          String city =  Login.cityField.getText(); // allows the user to update  the city  
          String post = Login.postField.getText(); // allows the user to update their post code 
          String ID = Login.idBOX.getSelectedItem().toString(); //gets the id 
        
        try(Connection conn = DriverManager.getConnection(url))
        {//open try
            
          //used to grab string-based sql queieres

          String query = "UPDATE 'CustomerTable' SET 'CustomerFN'='"+fn+"', 'CustomerLN'='"+ln+"', 'CustomerEmail'='"+email+"', 'CustomerStreetLine'='"+street+"', 'CustomerCity'='"+city+"', 'CustomerPostCode'='"+post+"' Where CustomerID ='"+ID+"'" ;
          PreparedStatement pst = conn.prepareStatement(query);
          
            //allows the user to update thier post code
          
          pst.executeUpdate();
          
          JOptionPane.showMessageDialog(null, "Record Has Been updated..."); //let user know 
           
            
             }//close try 
             catch (Exception e)
        { //open catch
          JOptionPane.showMessageDialog(null,(e.getMessage())); // shows message
      }//end catch 
    }//end uodate customer 
    
    
    
    public static void displaySearch()
    {//open displaySearch
        
         Login.searchStock.setText(null);
          Login.searchStock.append("ID \t Name \t Cost \t date \t QTY \t description \t category \n");
          
          try (Connection conn = DriverManager.getConnection(url)) 
          {//   open try
              
            //Statement – Used to execute string-based SQL queries
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ProductTable"); //get everything from table, result set
            
            while(rs.next())
            { //rs is result set, use while to iterate through it
                String id = rs.getString("ProductID"); // get id from rs
                String name = rs.getString("ProductName"); //get name from rs
                String cost = rs.getString("ProductCost"); //get capacity from rs
                String date = rs.getString("ProductExpDate");
                String QTY = rs.getString("ProductQty");
                String des = rs.getString("ProductDescription");
                String category = rs.getString("ProductCategory");
                
               // for every entry in the table append to text area
                Login.searchStock.append(id + "\t" + name + "\t" + cost +"\t"+date+"\t"+QTY+"\t"+des+"\t"+category+"\n");
            }//end while
            
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //if there is an error a popup is issued
        }//end try catch
    }//end display search
      
    
//    This method will pull all required information about the product when
//    The user enters an ID and presses the search button
    
    
    
    public static void searchBTN()
    {// open search buttton
      try (Connection conn = DriverManager.getConnection(url))
      {//   open try
          
          String grab = Login.idSearch.getText();
          PreparedStatement pst = conn.prepareStatement("select * FROM ProductTable WHERE ProductID = ?");  //searchs for the ids of the table
          
          pst.setString(1, grab);
          
          ResultSet rs = pst.executeQuery();
          
          if(rs.next())
          {//open if
             //     Will fill the corresponding fields with their needed information!
             Login.idSearch.setText(rs.getString(1)); 
             Login.nameView.setText(rs.getString(2));
             Login.priceView.setText(rs.getString(3));
             
              
          } // close if 
            else
                {//open else 
                    JOptionPane.showMessageDialog(null, "Error!");
                       
                }//end else
          
          
      }//   close try
        catch(Exception e)
              { //open catch
                  JOptionPane.showMessageDialog(null,(e.getMessage()));
              } //close catch  
    } //close search button 
    
    
 
     
    
    
//    This method clears alll the fields within the panel
    
    
    public static void clearCustomer()
    {//open clearCustomer 
        Login.fnText.setText(null);
        Login.lnText.setText(null);
        Login.emailText.setText(null);
        Login.STField.setText(null);
        Login.cityField.setText(null);
        Login.postField.setText(null);
    } //end clear customer 
    
    
    
    
    
        //create Colleague accounts
    
    
        public static void createColleague()
        {// open create colleague
            
      try(Connection conn = DriverManager.getConnection(url))
      { // open try
          
          //used to grab string-based sql queieres
       
          
          String query = "insert into ColleagueTable (ColleagueID, ColleagueName, ColleagueAddress, ColleaguePostCode, ColleagueDOB, ColleagueEmail, ColleaguePhoneNum)values(?,?,?,?,?,?,?)";
          PreparedStatement pst = conn.prepareStatement(query);
          pst.setString(1, Login.cID.getText()); //allows the user to set the ID for their account
          pst.setString(2, Login.cName.getText()); //allows the user to set their name for their account
          pst.setString(3, Login.cAddress.getText()); // allows the user to set their last name for their account
          pst.setString(4, Login.postC.getText()); // allows the user to set their email for their account
          pst.setString(5, Login.dobField.getText());
          pst.setString(6, Login.cEmail.getText());
          pst.setString(7, Login.phoneField.getText());
          
          pst.executeUpdate();
          
          JOptionPane.showMessageDialog(null, "Record inserted..."); //let user know 
           
            
             }//close try
                catch (Exception e) // catch exception
             {//open catch
          JOptionPane.showMessageDialog(null,(e.getMessage())); // shows message
      }//end catch 
  }//end login customer
    
          public static void clearColleague()
    {//open clearCustomer 
        
//        The purpose of this method is to clear all of the fields
        
        Login.cID.setText(null);
        Login.cName.setText(null);
        Login.cAddress.setText(null);
        Login.postC.setText(null);
        Login.dobField.setText(null);
        Login.cEmail.setText(null);
        Login.phoneField.setText(null);
    } //end clear customer 
 
  
         public static void updateCombo2(JComboBox colleagueIDBOX) //used to grab of all the ids of the colleagues
         {//open
             
         try (Connection conn = DriverManager.getConnection(url)) //establishing the connection to the database 
         
         {//open try
             
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery("SELECT ColleagueID FROM ColleagueTable");
             
             List<String> ids = new ArrayList<>();
             
             //searches through the database and adds to each one
                while(rs.next())
                {// open while
                    ids.add(rs.getString("ColleagueID"));
                }//end while
               colleagueIDBOX.setModel(new DefaultComboBoxModel(ids.toArray())); 
         } //   end try
         catch(SQLException ex)
         {//open catch
             JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
         }//end catch
    }//end     
          
          
         
         
         public static void fillColleagueDetails()
    {//  open try
         String item = (String)Login.colleagueIDBOX.getSelectedItem();
        String sql = "select * from ColleagueTable where ColleagueID = ?";
        
        try(Connection conn = DriverManager.getConnection(url))//   establishes the connection to the database
        {//     open try 
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, item);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {//open if 
                Login.cID.setText(rs.getString("ColleagueID"));
                 Login.cName.setText(rs.getString("ColleagueName"));
                  Login.cAddress.setText(rs.getString("ColleagueAddress"));
                   Login.postC.setText(rs.getString("ColleaguePostCode"));
                    Login.dobField.setText(rs.getString("ColleagueDOB"));
                     Login.cEmail.setText(rs.getString("ColleagueEmail"));
                       Login.phoneField.setText(rs.getString("ColleaguePhoneNum")); 
                  
            }//end if 
       } //end try
       catch(SQLException ex)
       { //open catch
           JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
       }//end catch
    } //end go
          
       
         public static void deleteColleague()
         {//    open delete
           // Will be able to delete colleagues 
               try(Connection conn = DriverManager.getConnection(url))//   establishes the connection to the database
               {    // open try
                  
                   Statement smt = conn.createStatement();
                   smt.executeUpdate("DELETE FROM ColleagueTable WHERE ColleagueID ="+Login.cID.getText()+"");
                   JOptionPane.showMessageDialog(null, "Record of Colleague been Deleted!");
                   
                   smt.close();
                   conn.close();
                   
               }    //end try
               catch(Exception e)
               {    //open catch
                   JOptionPane.showMessageDialog(null,(e.getMessage()));
               }//  end catch
             
         }//    end delete
         
            public static void deleteCustomer()
         {//    open delete
           // Will be able to delete colleagues 
               try(Connection conn = DriverManager.getConnection(url))//   establishes the connection to the database
               {    // open try
                  
                   Statement smt = conn.createStatement();
                   smt.executeUpdate("DELETE FROM CustomerTable WHERE CustomerID ="+Login.idBOX.getSelectedItem()+"");
                   JOptionPane.showMessageDialog(null, "Record of Colleague been Deleted!");
                   
                   smt.close();
                   conn.close();
                   
               }    //end try
               catch(Exception e)
               {    //open catch
                   JOptionPane.showMessageDialog(null,(e.getMessage()));
               }//  end catch
         }//    end delete
         
            
            int randomID(int min, int max)
    {// open
        int range = (max-min)+1;
        return (int)(Math.random()*range)+min;
    } //close
            
            
            
            
//          Allows the user to buy products   
            
            
            public static void buy()
            {//open buy
                 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
                  Date date = new Date();  
               BluePrint ob = new BluePrint();
                int rand = ob.randomID(1, 10000);
                String dater = formatter.format(date);
                 try(Connection conn = DriverManager.getConnection(url))//   establishes the connection to the database
                 {  //open try
                   
                    String query = "Insert into OrderTable (OrderID, ProductID, QTY, Price, PurchaseDate) Values(?,?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, Integer.toString(rand));
                    pst.setString(2, Login.idSearch.getText());
                    pst.setString(3, Login.qtyField.getText());
                    pst.setString(4, Login.priceView.getText());
                    pst.setString(5, dater);
                    
                    pst.executeUpdate(); //excutes the command
                    
                    JOptionPane.showMessageDialog(null, "Purchased Item!"); //let user know 
                    
                 
                 } //close try
                 catch(SQLException ex)
                 {//    open catch
                    JOptionPane.showMessageDialog(null,(ex.getMessage()));
                 }//    end catch  
            } //close buy
          
            
            
//            Allows the user to see the products that they have bought
            
            
            
            public static void reviewBuy()
            {// open review buy
                Login.reviewOrderTxt.setText(null);
                Login.reviewOrderTxt.append("Order ID \t Product ID \t Qty \t Price \t Purchase Date \n");
                
              try(Connection conn = DriverManager.getConnection(url))//   establishes the connection to the database
              {//   open try
                  Statement smt =  conn.createStatement();
                  ResultSet rs = smt.executeQuery("SELECT * FROM OrderTable");
                  
                  while(rs.next())
                  {//open while
                      String id = rs.getString("OrderID");
                      String Pid = rs.getString("ProductID");
                      String qty = rs.getString("QTY");
                      String price = rs.getString("Price");
                      String PD = rs.getString("PurchaseDate");
                      
                      Login.reviewOrderTxt.append(id+"\t"+Pid+"\t"+qty+"\t"+price+"\t"+PD+"\n");
                  }//end while  
              }//   close try
               catch(SQLException e)
               {//  open catch
                   System.out.println(e.getMessage());
               }//close catch  
            }//end review buy 
            
             public static void updateCombo3(JComboBox pDates)
    {//     Used for grabbing all of the categories in the Product table 
         try (Connection conn = DriverManager.getConnection(url)) //    establisihes the connection to the databse
         {//    Open try
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery("SELECT PurchaseDate FROM PreviousOrder");
             
             List<String> ids = new ArrayList<>();
             
             //searches through the database and adds to each one
                while(rs.next()){
                    ids.add(rs.getString("PurchaseDate"));
                }//end while
               pDates.setModel(new DefaultComboBoxModel(ids.toArray())); 
         } 
         catch(SQLException ex)
         {//open catch
             JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
         }//end catch
    }//end 
            
            
               public static void pickPreviousOrder(){
        Login.previousTXT.setText(null);
        Login.previousTXT.setText("OrderID \t ProductID \t Qty \t Price \t PurchaseDate \n");
        String item = (String)Login.pDates.getSelectedItem();
        String sql = "select * from PreviousOrder where PurchaseDate = ?";
        try(Connection conn = DriverManager.getConnection(url))
        {//open try
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, item);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
               String id = rs.getString("OrderID");
               String name = rs.getString("ProductID");
               String qty = rs.getString("QTY");
               String cost = rs.getString("Price");
               String des = rs.getString("PurchaseDate");
               
               
               Login.previousTXT.append(id+"\t"+name+"\t"+cost+"\t"+qty+"\t"+des+"\n");
                
            }//end if 
       } //end try
       catch(SQLException ex)
       { //open catch
           JOptionPane.showMessageDialog(null,(ex.getMessage())); //if there is an error a popup is issued
       }//end catch 
    }//end pickPreviousOrder
         
               public static void reorder()
               {//open reorder
                   String item = (String)Login.pDates.getSelectedItem();
                  
                   
                    try(Connection conn = DriverManager.getConnection(url))
                    {//open try
                        String sql = "INSERT into OrderTable (OrderID, ProductID, QTY, Price, PurchaseDate) Values(?,?,?,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        
                        pst.setString(1, item); //grabs id
                        pst.setString(2, item); //grabs ProductID
                        pst.setString(3, item); //grabs qty
                        pst.setString(4, item); //grabs price
                        pst.setString(5, item); //grabs purchase date
                        
                        pst.executeQuery();
                        
                        
                    }//close try
                     catch(Exception e)
                        {//open catch
                        JOptionPane.showMessageDialog(null,(e.getMessage())); //if there is an error a popup is issued
                        }//end catch    
               } //close reorder
               
        
        
    }//end class 
        
        
        
        
  
    
    

