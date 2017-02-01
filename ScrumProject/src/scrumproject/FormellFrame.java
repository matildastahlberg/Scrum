/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproject;

import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sqlconnection.SQLConnection;

/**
 *
 * @author Tomas
 */
public class FormellFrame extends javax.swing.JFrame {

    /**
     * Creates new form FormellFrame
     */
    public FormellFrame() {
        initComponents();
        fillCB();
        getContentPane().setBackground(Color.white);
    }
    
   
private void fillCB() {
        try {
            ResultSet CategoryList = SQLConnection.getDatabas().executeQuery("SELECT namn FROM underkategori");
            while(CategoryList.next()){
                String category = CategoryList.getString(1);
                    CBKategori.addItem(category); // Makes sure the actual names show up in the combobox.
                }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBKategori = new javax.swing.JComboBox<>();
        TxfInlagg = new javax.swing.JTextField();
        LblTitel = new javax.swing.JLabel();
        LblText = new javax.swing.JLabel();
        TxfTitel = new javax.swing.JTextField();
        DpDatum = new org.jdesktop.swingx.JXDatePicker();
        LblBild = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtnVäljBild = new javax.swing.JButton();
        BtnVäljFil = new javax.swing.JButton();
        BtnSkicka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CBKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kategori" }));

        TxfInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxfInlaggActionPerformed(evt);
            }
        });

        LblTitel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LblTitel.setText("Titel:");

        LblText.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LblText.setText("Text:");

        LblBild.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LblBild.setText("Bild");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Fil");

        BtnVäljBild.setText("Välj Bild");

        BtnVäljFil.setText("Välj Fil");

        BtnSkicka.setText("Skicka");
        BtnSkicka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSkickaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSkicka)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CBKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LblTitel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TxfTitel))
                        .addComponent(LblText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxfInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblBild)
                            .addComponent(jLabel1))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnVäljFil)
                            .addComponent(BtnVäljBild))))
                .addGap(0, 68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CBKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTitel)
                    .addComponent(TxfTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxfInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblBild)
                            .addComponent(BtnVäljBild))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(BtnVäljFil))))
                .addGap(18, 18, 18)
                .addComponent(BtnSkicka)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxfInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxfInlaggActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxfInlaggActionPerformed

    private void BtnSkickaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSkickaActionPerformed
   String titel = TxfTitel.getText().toString();
   String con = TxfInlagg.getText().toString();
        int index = CBKategori.getSelectedIndex();
        String kategori = CBKategori.getItemAt(index);
       
       
   try {
        int forfattare;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       String dateString = format.format(DpDatum.getDate());
//       java.util.Date datum = DpDatum.getDate();
       ResultSet auth = SQLConnection.getDatabas().executeQuery("Select ID from anvandare where inloggad = 1");
        while(auth.next()){
       forfattare = auth.getInt(1);
           SQLConnection.getDatabas().execute("INSERT INTO FormelltInlagg(Titel, Text, Datum, Kategori, Forfattare) VALUES ('" + titel + "', '" + con + "','" + dateString +"','" + kategori+"' , '" + forfattare + "');");
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_BtnSkickaActionPerformed

//      private void addToDB() {
//         String inlagg = TxfInlagg.getText();
//         String titel = TxfTitel.getText();
//        try {
//           SQLConnection.getDatabas().execute("INSERT INTO FormelltInlagg(Titel, Text) VALUES ('" + inlagg + "', '" + titel + "');");
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
    
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
            java.util.logging.Logger.getLogger(FormellFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormellFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormellFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormellFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormellFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSkicka;
    private javax.swing.JButton BtnVäljBild;
    private javax.swing.JButton BtnVäljFil;
    private javax.swing.JComboBox<String> CBKategori;
    private org.jdesktop.swingx.JXDatePicker DpDatum;
    private javax.swing.JLabel LblBild;
    private javax.swing.JLabel LblText;
    private javax.swing.JLabel LblTitel;
    private javax.swing.JTextField TxfInlagg;
    private javax.swing.JTextField TxfTitel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
