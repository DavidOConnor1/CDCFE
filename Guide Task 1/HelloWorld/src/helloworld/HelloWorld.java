/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package helloworld; 

import javax.swing.*;  

/** 

 * 

 * @author gavin 

 */ 

public class HelloWorld { 

 

    /** 

     * @param args the command line arguments 

     */ 

    public static void main(String[] args) { 

        javax.swing.SwingUtilities.invokeLater(new Runnable() { 

            public void run() { 

                createAndShowGUI(); 

            } 

        }); 

    } 

     

    private static void createAndShowGUI() { 

        //Create and set up the window. 

        JFrame frame = new JFrame("CDCFE - Computer Science Y2"); 

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

 

        //Add the ubiquitous "Hello World" label. 

        JLabel label = new JLabel("What's up X"); 

        frame.getContentPane().add(label); 

 

        //Display the window. 

        frame.pack(); 

        frame.setVisible(true); 

    } 

     

} 