/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtest12;

/**
 *
 * @author student
 */
public class FirstJFrame extends javax.swing.JFrame {

    /**
     * Creates new form FirstJFrame
     */
    public FirstJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextBox = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        ToggleButton = new javax.swing.JToggleButton();
        ComboBox = new javax.swing.JComboBox<>();
        Slider = new javax.swing.JSlider();
        Spinner = new javax.swing.JSpinner();
        SubButton = new javax.swing.JButton();
        TextField = new javax.swing.JTextField();
        TextSub = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 750));

        TextBox.setColumns(20);
        TextBox.setRows(5);
        jScrollPane1.setViewportView(TextBox);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Single Button");
        jButton1.setToolTipText("Press me ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ToggleButton.setBackground(new java.awt.Color(153, 153, 153));
        ToggleButton.setText("Toggle");
        ToggleButton.setMaximumSize(new java.awt.Dimension(95, 23));
        ToggleButton.setMinimumSize(new java.awt.Dimension(95, 23));
        ToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleButtonActionPerformed(evt);
            }
        });

        ComboBox.setBackground(new java.awt.Color(153, 153, 153));
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bob", "Davey", "Rachel", "Jessica", " " }));
        ComboBox.setToolTipText("Choose who to kiss");
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        Slider.setBackground(new java.awt.Color(153, 153, 153));
        Slider.setMajorTickSpacing(10);
        Slider.setMinorTickSpacing(5);
        Slider.setPaintLabels(true);
        Slider.setPaintTicks(true);
        Slider.setToolTipText("Rate them from 1-100");
        Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SliderMouseDragged(evt);
            }
        });
        Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SliderMouseClicked(evt);
            }
        });

        Spinner.setModel(new javax.swing.SpinnerDateModel());
        Spinner.setToolTipText("Choose date");
        Spinner.setName("Date"); // NOI18N

        SubButton.setBackground(new java.awt.Color(153, 153, 153));
        SubButton.setText("Submit Date");
        SubButton.setToolTipText("Just press");
        SubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubButtonActionPerformed(evt);
            }
        });

        TextField.setBackground(new java.awt.Color(153, 153, 153));
        TextField.setForeground(new java.awt.Color(153, 255, 153));

        TextSub.setBackground(new java.awt.Color(153, 153, 153));
        TextSub.setText("Text Submit");
        TextSub.setToolTipText("Enter Approaite message");
        TextSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SubButton, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TextSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSub))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       TextBox.append("You have pressed the Single Button\n"); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubButtonActionPerformed
        // TODO add your handling code here:
        TextBox.append(Spinner.getValue().toString()+"\n"); 
    }//GEN-LAST:event_SubButtonActionPerformed

    private void ToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToggleButtonActionPerformed
        // TODO add your handling code here:
        if(ToggleButton.isSelected() == true) {
            TextBox.append("You have pressed the Toggle Button\n");
        }
    }//GEN-LAST:event_ToggleButtonActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
        TextBox.append(ComboBox.getSelectedItem().toString()+"\n"); 
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void SliderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderMouseClicked
        // TODO add your handling code here:
        TextBox.append(Integer.toString(Slider.getValue())+"\n"); 
    }//GEN-LAST:event_SliderMouseClicked

    private void SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderMouseDragged
        TextBox.append(Integer.toString(Slider.getValue())+"\n"); 
    }//GEN-LAST:event_SliderMouseDragged

    private void TextSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSubActionPerformed
        // TODO add your handling code here:
        TextBox.append(TextField.getText()+"\n"); 
    }//GEN-LAST:event_TextSubActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FirstJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JSlider Slider;
    private javax.swing.JSpinner Spinner;
    private javax.swing.JButton SubButton;
    private javax.swing.JTextArea TextBox;
    private javax.swing.JTextField TextField;
    private javax.swing.JButton TextSub;
    private javax.swing.JToggleButton ToggleButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}