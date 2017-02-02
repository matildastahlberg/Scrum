/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproject;

/**
 *
 * @author johan
 */
public class MailFrame extends javax.swing.JFrame {

    /**
     * Creates new form MailFrame
     */
    public MailFrame() {
        initComponents();
    }

  
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMailAvbryt = new javax.swing.JButton();
        lblMailNamn = new javax.swing.JLabel();
        lblMailMail = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        scrllPnlMailMeddelande = new javax.swing.JScrollPane();
        txtAreaMailMeddelande = new javax.swing.JTextArea();
        btnMailSkicka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMailAvbryt.setBackground(new java.awt.Color(255, 153, 153));
        btnMailAvbryt.setText("Avbryt");
        btnMailAvbryt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMailAvbrytActionPerformed(evt);
            }
        });

        lblMailNamn.setText("Namn");

        lblMailMail.setText("Mail");

        txtAreaMailMeddelande.setColumns(20);
        txtAreaMailMeddelande.setRows(5);
        scrllPnlMailMeddelande.setViewportView(txtAreaMailMeddelande);

        btnMailSkicka.setBackground(new java.awt.Color(204, 255, 204));
        btnMailSkicka.setText("Skicka");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMailNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMailMail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMailSkicka, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMailAvbryt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrllPnlMailMeddelande, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamn, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMailNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMailMail, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrllPnlMailMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMailAvbryt, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(btnMailSkicka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMailAvbrytActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMailAvbrytActionPerformed
        
        this.setVisible(false);
        this.dispose();
     
    }//GEN-LAST:event_btnMailAvbrytActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMailAvbryt;
    private javax.swing.JButton btnMailSkicka;
    private javax.swing.JLabel lblMailMail;
    private javax.swing.JLabel lblMailNamn;
    private javax.swing.JScrollPane scrllPnlMailMeddelande;
    private javax.swing.JTextArea txtAreaMailMeddelande;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNamn;
    // End of variables declaration//GEN-END:variables
}
