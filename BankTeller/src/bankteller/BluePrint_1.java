/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankteller;

/**
 *
 * @author David O Connor
 */
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
public class BluePrint {
    
    public static ArrayList <Integer> ID = new ArrayList<>();
    public static ArrayList <String> FirstName = new ArrayList <>();
    public static ArrayList <String> LastName = new ArrayList <>();
    public static ArrayList <String> Nationailty = new ArrayList <>();
    public static ArrayList <String> PostCode = new ArrayList <>();
    public static ArrayList <String> DOB = new ArrayList <>();
    public static ArrayList <Integer> SavingsAccount = new ArrayList <>();
    public static ArrayList <Integer> CurrentAccount = new ArrayList <>();
    public static ArrayList <Integer> OverDraft = new ArrayList <>();

    static int index;
    
    public static void addAccounts(){ //open addAccounts
        ID.add(3456);
        FirstName.add("David");
        LastName.add("O'Connor");
        Nationailty.add("Irish");
        PostCode.add("D04 RF66");
        DOB.add("29/04/3789");
        SavingsAccount.add(8000);
        CurrentAccount.add(500);
        OverDraft.add(20000);
        
          ID.add(36);
        FirstName.add("Rachel");
        LastName.add("Hynes");
        Nationailty.add("Irish");
        PostCode.add("D17 R3g6");
        DOB.add("23/12/3319");
        SavingsAccount.add(80);
        CurrentAccount.add(10);
        OverDraft.add(10000);
        
          ID.add(45);
        FirstName.add("Bob");
        LastName.add("Sight");
        Nationailty.add("Polish");
        PostCode.add("D78 D31G");
        DOB.add("12/04/3314");
        SavingsAccount.add(700);
        CurrentAccount.add(100);
        OverDraft.add(0);
        
          ID.add(34);
        FirstName.add("Caitlin");
        LastName.add("O'Reily");
        Nationailty.add("American");
        PostCode.add("D18 DD66");
        DOB.add("16/02/3589");
        SavingsAccount.add(10000);
        CurrentAccount.add(5000);  
        OverDraft.add(589329384);
    } //close addAccounts
    
    public static void viewAccounts() {
        BankTellerApp.ViewArea.setText(""); //clear the box
        BankTellerApp.ViewArea.append("ID:\t"+"First Name:\t"+"Last Name:\t"+"Nation:\t"+"Post Code:\t"+"DOB: \t"+"Savings: \t"+"Current: \t"+"OverDraft: \n" );

            for(int i=0; i<ID.size(); i++){
                BankTellerApp.ViewArea.append(ID.get(i)+"\t"+FirstName.get(i)+"\t"+LastName.get(i)+"\t"+Nationailty.get(i)+"\t"+PostCode.get(i)+"\t"+DOB.get(i)+"\t"+SavingsAccount.get(i)+"\t"+CurrentAccount.get(i)+"\t"+OverDraft.get(i)+"\n");
            } //close for loop
    }//close view
    
    public static void newAccounts(String id, String FN, String LN, String Nation,String Post ,String DOOB, String Current, String Savings, int Over ) {
        boolean accountFound = false;
            for(int i=0; i<ID.size(); i++){
                if(BankTellerApp.DOBTextField.getText().matches(Integer.toString(ID.get(i)))){
                    accountFound = true;
                    index = i;
                                } //close if 1
                } //close for 
            
                if(accountFound == true){
                        JOptionPane.showMessageDialog(null, "ID Already in Use");
                            } //end if 3
            
                if(accountFound == false) {
                    ID.add(Integer.valueOf(id));
                    FirstName.add(FN);
                    LastName.add(LN);
                    Nationailty.add(Nation);
                    PostCode.add(Post);
                    DOB.add(DOOB);
                    SavingsAccount.add(Integer.valueOf(Savings));
                    CurrentAccount.add(Integer.valueOf(Current));
                    OverDraft.add(Over);
                    blank();
                    JOptionPane.showMessageDialog(null, "Information Added");
                } //end if 2
                
                    
        } //end new accounts
   
            public static void editStaff(){
                boolean foundStaff = false;
                    for(int i=0; i<ID.size(); i++){
                        if(BankTellerApp.IDField1.getText().matches(Integer.toString(ID.get(i)))){
                            foundStaff = true;
                            index = i;
                        } //end if
                    } //end for
                      if (foundStaff == true){ 

                ID.set(index, Integer.valueOf(BankTellerApp.IDField1.getText())); 

                FirstName.set(index, BankTellerApp.FNText.getText()); 
                LastName.set(index, BankTellerApp.LNText.getText()); 
                
                Nationailty.set(index, (String) BankTellerApp.NationalityField.getText());
                PostCode.set(index, (String) BankTellerApp.PostCodeField.getText()); 
               
                DOB.set(index, BankTellerApp.DOBTextField.getText()); 
                
                SavingsAccount.set(index, Integer.valueOf(BankTellerApp.SSB_Field.getText())); 
               CurrentAccount.set(index, Integer.valueOf(BankTellerApp.CBB_Field.getText())); 
                
                 
                
                OverDraft.set(index, BankTellerApp.overSlider.getValue()); 

                JOptionPane.showMessageDialog(null,"Staff Updated!"); 

            }//end if 

        if (foundStaff == false){ 

                JOptionPane.showMessageDialog(null,"Staff Not Found!"); 

                BankTellerApp.IDField1.setText(null); 

                BankTellerApp.FNText.setText(null); 
                BankTellerApp.LNText.setText(null); 
                BankTellerApp.NationalityField.setText(null); 
                BankTellerApp.PostCodeField.setText(null);
                BankTellerApp.DOBTextField.setText(null);
                BankTellerApp.SSB_Field.setText(null);
                BankTellerApp.CBB_Field.setText(null);
                BankTellerApp.overSlider.setValue(0); 

            }//end if 

    }//end editstaff 
                   
                public static void highestSavings(){
                    BankTellerApp.ViewStats.setText(""); //clear the box
                    
                    int max = Collections.max(SavingsAccount);
                     BankTellerApp.ViewStats.append("Highest Savings Account is: "+max);
                        
     
                } //end highest savings
                
                public static void lowestSavings(){
                    BankTellerApp.ViewStats.setText(""); //clear the box
                    int min = Collections.min(SavingsAccount);
                    System.out.println("Lowest Savings Account"+min);
                    BankTellerApp.ViewStats.append("Lowest Savings Account: "+min);
                } //end min
                
                public static void HighestCurrent(){
                   BankTellerApp.ViewStats.setText(""); //clear the box
                    int max = Collections.max(CurrentAccount);
                    System.out.println("Highest Current Account is :"+max); 
                     BankTellerApp.ViewStats.append("Highest Current Account is: "+max); 
                }
            
                  public static void lowestCurrent(){
                    BankTellerApp.ViewStats.setText(""); //clear the box
                    int min = Collections.min(CurrentAccount);
                    System.out.println("Lowest Current Account"+min);
                    BankTellerApp.ViewStats.append("Lowest Current Account: "+min);
                } //end min
                
                  public static void Query(){
                      
                      boolean staffFound = false;
                      for(int i =0; i<ID.size();i++){
                          if(!BankTellerApp.IDField1.getText().matches(Integer.toString(ID.get(i)))){
                          } else {
                              staffFound = true;
                              index =i;
                          } //end if
                          //end if
                      }//END FOR
                            
                      if(staffFound == true){
                         
                          BankTellerApp.IDField1.setText(Integer.toString(ID.get(index)));
                           
                          BankTellerApp.FNText.setText(FirstName.get(index)); 
                           BankTellerApp.LNText.setText(LastName.get(index)); 
                         
                           BankTellerApp.NationalityField.setText(Nationailty.get(index));
                           BankTellerApp.PostCodeField.setText(PostCode.get(index));
                           BankTellerApp.DOBTextField.setText(DOB.get(index));
                            BankTellerApp.SSB_Field.setText(Integer.toString(SavingsAccount.get(index)));
                           BankTellerApp.CBB_Field.setText(Integer.toString(CurrentAccount.get(index)));
                           BankTellerApp.overSlider.setValue(OverDraft.get(index)); 
                      } //end if 
                      
                      if(staffFound ==false){
                          JOptionPane.showMessageDialog(null, "Member Not Found");
                                  BankTellerApp.IDField1.setText(null); 

                                    BankTellerApp.FNText.setText(null); 
                                    BankTellerApp.LNText.setText(null); 
                                    BankTellerApp.NationalityField.setText(null); 
                                    BankTellerApp.PostCodeField.setText(null);
                                     BankTellerApp.DOBTextField.setText(null);
                                     BankTellerApp.SSB_Field.setText(null);
                                     BankTellerApp.CBB_Field.setText(null);
                                     BankTellerApp.overSlider.setValue(0); 
                      }//end if
                      
                  } //end query
                  
                  public static void update(){
                      boolean found = false;
                      
                         for(int i=0; i<ID.size(); i++){
                        if(BankTellerApp.IDField1.getText().matches(Integer.toString(ID.get(i)))){
                            found = true;
                            index = i;
                        } //end if
                    } //end for
                      
                         if(found == true){
                             SavingsAccount.set(index, Integer.valueOf(BankTellerApp.SSB_Field.getText())); 
                             CurrentAccount.set(index, Integer.valueOf(BankTellerApp.CBB_Field.getText())); 
                             OverDraft.set(index, BankTellerApp.overSlider.getValue());
                             JOptionPane.showMessageDialog(null, "Balance has been updated!");
                         } //end if
                         
                         if(found == false){
                             JOptionPane.showMessageDialog(null, "Member Not Found");
                             BankTellerApp.IDField1.setText(null); 
                             BankTellerApp.FNText.setText(null); 
                             BankTellerApp.LNText.setText(null); 
                             BankTellerApp.NationalityField.setText(null); 
                             BankTellerApp.PostCodeField.setText(null);
                             BankTellerApp.DOBTextField.setText(null);
                             BankTellerApp.SSB_Field.setText(null);
                             BankTellerApp.CBB_Field.setText(null);
                             BankTellerApp.overSlider.setValue(0); 
                         }
                      
                  }
                  
                  public static void blank(){
                         if(BankTellerApp.IDField1.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.IDField1, "Beware you left the text fields blank");
                                }
                      
                        if(BankTellerApp.FNText.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.FNText, "Beware you left the text fields blank");
                                }
                        
                         if(BankTellerApp.LNText.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.LNText, "Beware you left the text field blank");
                                }
                         
                          if(BankTellerApp.NationalityField.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.NationalityField, "Beware you left the text field blank");
                                }
                          
                          if(BankTellerApp.PostCodeField.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.PostCodeField, "Beware you left the text field blank");
                                }
                          
                          if(BankTellerApp.DOBTextField.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.PostCodeField, "Beware you left the text field blank");
                          }
                          
                                 if(BankTellerApp.CBB_Field.getText().isEmpty()){
                              JOptionPane.showMessageDialog(BankTellerApp.CBB_Field, "Beware you left the text field blank");
                                }//end if       
                  }//end blank
            
            }//end class




