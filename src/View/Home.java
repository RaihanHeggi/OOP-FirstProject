/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author user
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
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

        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        buttHomeStudent = new javax.swing.JButton();
        buttHomeAdmin = new javax.swing.JButton();
        buttHomeTentor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(11, 12, 16));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 153, 0));
        label1.setText("Login Page E-Learning System ");

        jPanel2.setBackground(new java.awt.Color(31, 40, 51));
        jPanel2.setForeground(new java.awt.Color(255, 204, 0));

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 153, 0));
        label3.setText("LOGIN SEBAGAI");

        buttHomeStudent.setBackground(new java.awt.Color(204, 204, 204));
        buttHomeStudent.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        buttHomeStudent.setText("MAHASISWA");
        buttHomeStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttHomeStudentActionPerformed(evt);
            }
        });

        buttHomeAdmin.setBackground(new java.awt.Color(204, 204, 204));
        buttHomeAdmin.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        buttHomeAdmin.setText("ADMIN");
        buttHomeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttHomeAdminActionPerformed(evt);
            }
        });

        buttHomeTentor.setBackground(new java.awt.Color(204, 204, 204));
        buttHomeTentor.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        buttHomeTentor.setText("DOSEN");
        buttHomeTentor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttHomeTentorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttHomeStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(buttHomeAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttHomeTentor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(buttHomeAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttHomeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttHomeTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttHomeStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttHomeStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttHomeStudentActionPerformed

    private void buttHomeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttHomeAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttHomeAdminActionPerformed

    private void buttHomeTentorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttHomeTentorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttHomeTentorActionPerformed

    
    //get Button

    public JButton getButtHomeAdmin(){
        return buttHomeAdmin;
    }
    public JButton getButtHomeStudent(){
        return buttHomeStudent;
    }
    public JButton getButtHomeTentor(){
        return buttHomeTentor;
    }
    
    //Listener and Adapter
    
    public void addListener(ActionListener AL){
       buttHomeAdmin.addActionListener(AL);
       buttHomeStudent.addActionListener(AL);
       buttHomeTentor.addActionListener(AL);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttHomeAdmin;
    private javax.swing.JButton buttHomeStudent;
    private javax.swing.JButton buttHomeTentor;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
}