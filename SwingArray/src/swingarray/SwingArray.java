/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingarray;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SwingArray {

        public static ArrayList<Integer> StaffID = new ArrayList<>(); 
    public static ArrayList<String> StaffName = new ArrayList<>(); 
    public static ArrayList<Integer> StaffPin = new ArrayList<>(); 
    public static int index;
    

    public static void addrecords(){ 

        StaffID.add(0); 
        StaffName.add("John"); 
        StaffPin.add(999); 

        StaffID.add(1); 
        StaffName.add("Paul"); 
        StaffPin.add(666); 

        StaffID.add(2); 
        StaffName.add("Ringo"); 
        StaffPin.add(111); 
    }//end addrecords 

    public static void viewstaff(){ 

        
        test.TextBox.setText("");
        

        test.TextBox.append("Index\t"+"ID\t"+"Name\t\t"+"Pin\n"); //set header 

        for (int i=0; i<StaffID.size(); i++){ 

            test.TextBox.append(i+"\t"+StaffID.get(i).toString()+"\t"+ 

                    StaffName.get(i)+"\t\t"+StaffPin.get(i).toString()+"\n"); 

        }//end for      
    }//end viewstaff 
    
    
        public static void search() {//start search
              boolean stafffound = false; 
        for (int i=0;i < StaffID.size();i++){ //open for
                if (test.IDField.getText().matches(Integer.toString(StaffID.get(i)))){ 
                    stafffound = true; 
                    index = i; 
                }//end if 
            }//end for  

            if (stafffound == true){ 

                test.IDField.setText(Integer.toString(StaffID.get(index))); //it gets the staff id from the index

                test.NameField.setText(StaffName.get(index)); //prints the name when found staff member 

                test.PinSlider.setValue(StaffPin.get(index)); //prints the value of the staff member when found 

                JOptionPane.showMessageDialog(null,"Staff Found!"); //a pop up will appear when the staff is found
            }//end if 

            if (stafffound == false){ 

                JOptionPane.showMessageDialog(null,"Staff Not Found!");  //will appear when unable to find staff

                test.IDField.setText(null); 

                test.NameField.setText(null); // will not print in any of the boxes when staff is not found 

                test.PinSlider.setValue(0); 
            }//end if 
        }//end search
    
        public static void delete(){ 

        boolean stafffound = false; 

        for (int i=0;i < StaffID.size();i++){ 

                if (test.IDField.getText().matches(Integer.toString(StaffID.get(i)))){ 
                    stafffound = true; 
                    index = i; 
                }//end if 
            }//end for  

            if (stafffound == true){ 

                test.IDField.setText(null); 

                StaffID.remove(index); 

                test.NameField.setText(null); 

                StaffName.remove(index); 
                
                test.PinSlider.setValue(0); 
                
                StaffPin.remove(index); 
                
                JOptionPane.showMessageDialog(null,"Staff Deleted!"); 
            }//end if 

            if (stafffound == false){ 
                JOptionPane.showMessageDialog(null,"Staff Not Found!"); 
                test.IDField.setText(null); 
                test.NameField.setText(null); 
                test.PinSlider.setValue(0); 
            }//end if 
    } //end delete 
        
         

public static void newstaff(String id, String name, int pin){ 

        boolean stafffound = false; //the system does not show who is on the system

        for (int i=0;i < StaffID.size();i++){ 
                if (test.IDField.getText().matches(Integer.toString(StaffID.get(i)))){ 
                    stafffound = true; 
                    index = i; 
                }//end if 
            }//end for 

        if (stafffound == false){ 
                StaffID.add(Integer.valueOf(id));  //only adds the values if the user added does not have the same pini as another member

                StaffName.add(name); 

                StaffPin.add(pin); 

                JOptionPane.showMessageDialog(null,"Information Added!"); 
            }//end if 

            if (stafffound == true){ 
                JOptionPane.showMessageDialog(null,"ID in use!"); 
            }//end if 
    }// end newstaff 
        


        public static void editstaff(){ 

        boolean stafffound = false; 

        for (int i=0;i < StaffID.size();i++){ 

                if (test.IDField.getText().matches(Integer.toString(StaffID.get(i)))){ 
                    stafffound = true; 
                    index = i; 
                }//end if 

            }//end for 

        if (stafffound == true){ 

                StaffID.set(index, Integer.valueOf(test.IDField.getText())); //allows you to change the id number 

                StaffName.set(index, test.NameField.getText()); //allows you to chnage the name

                StaffPin.set(index, test.PinSlider.getValue()); //allows you to change staff pin

                JOptionPane.showMessageDialog(null,"Staff Updated!"); 
            }//end if 

        if (stafffound == false){ 

                JOptionPane.showMessageDialog(null,"Staff Not Found!"); 

                 test.IDField.setText(null); 

                test.NameField.setText(null); 

                test.PinSlider.setValue(0); 
            }//end if 
    }//end editstaff 
    
}//close class
