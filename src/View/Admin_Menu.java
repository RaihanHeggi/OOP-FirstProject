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
 * @author ACER
 */
public class Admin_Menu extends javax.swing.JFrame {

    /**
     * Creates new form Admin_CR_Tentor
     */
    public Admin_Menu() {
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
        label1 = new java.awt.Label();
        lbALog1 = new java.awt.Label();
        buttViewStudent = new javax.swing.JButton();
        buttTentorCR = new javax.swing.JButton();
        buttCRUDmatapelajaran = new javax.swing.JButton();
        buttCRUDkelas = new javax.swing.JButton();
        buttAdminLoginBackHome = new javax.swing.JButton();
        buttViewKelasStudentTentor = new javax.swing.JButton();
        buttMateriKelas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 40, 51));
        jPanel1.setForeground(new java.awt.Color(255, 204, 0));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(11, 12, 16));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 153, 0));
        label1.setText("Admin Page E-Learning System ");

        lbALog1.setAlignment(java.awt.Label.CENTER);
        lbALog1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbALog1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lbALog1.setForeground(new java.awt.Color(255, 153, 0));
        lbALog1.setText("Menu Admin");

        buttViewStudent.setBackground(new java.awt.Color(204, 204, 204));
        buttViewStudent.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttViewStudent.setForeground(new java.awt.Color(31, 40, 51));
        buttViewStudent.setText("View Student");
        buttViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttViewStudentActionPerformed(evt);
            }
        });

        buttTentorCR.setBackground(new java.awt.Color(204, 204, 204));
        buttTentorCR.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttTentorCR.setForeground(new java.awt.Color(31, 40, 51));
        buttTentorCR.setText("CR Tentor");
        buttTentorCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttTentorCRActionPerformed(evt);
            }
        });

        buttCRUDmatapelajaran.setBackground(new java.awt.Color(204, 204, 204));
        buttCRUDmatapelajaran.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttCRUDmatapelajaran.setForeground(new java.awt.Color(31, 40, 51));
        buttCRUDmatapelajaran.setText("CRUD Mata Pelajaran");
        buttCRUDmatapelajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttCRUDmatapelajaranActionPerformed(evt);
            }
        });

        buttCRUDkelas.setBackground(new java.awt.Color(204, 204, 204));
        buttCRUDkelas.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttCRUDkelas.setForeground(new java.awt.Color(31, 40, 51));
        buttCRUDkelas.setText("CRUD Kelas");
        buttCRUDkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttCRUDkelasActionPerformed(evt);
            }
        });

        buttAdminLoginBackHome.setBackground(new java.awt.Color(204, 204, 204));
        buttAdminLoginBackHome.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        buttAdminLoginBackHome.setText("HOME");

        buttViewKelasStudentTentor.setBackground(new java.awt.Color(204, 204, 204));
        buttViewKelasStudentTentor.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttViewKelasStudentTentor.setForeground(new java.awt.Color(31, 40, 51));
        buttViewKelasStudentTentor.setText("View Kelas Student Tentor");
        buttViewKelasStudentTentor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttViewKelasStudentTentorActionPerformed(evt);
            }
        });

        buttMateriKelas.setBackground(new java.awt.Color(204, 204, 204));
        buttMateriKelas.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttMateriKelas.setForeground(new java.awt.Color(31, 40, 51));
        buttMateriKelas.setText("View Materi tiap Kelas");
        buttMateriKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttMateriKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lbALog1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttCRUDmatapelajaran)
                            .addComponent(buttViewStudent)
                            .addComponent(buttCRUDkelas)
                            .addComponent(buttViewKelasStudentTentor)
                            .addComponent(buttMateriKelas)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttAdminLoginBackHome)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(273, 273, 273)
                    .addComponent(buttTentorCR)
                    .addContainerGap(287, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbALog1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttViewStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttCRUDmatapelajaran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttCRUDkelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttViewKelasStudentTentor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttMateriKelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(buttAdminLoginBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(buttTentorCR)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttViewStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttViewStudentActionPerformed

    private void buttTentorCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttTentorCRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttTentorCRActionPerformed

    private void buttCRUDmatapelajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttCRUDmatapelajaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttCRUDmatapelajaranActionPerformed

    private void buttCRUDkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttCRUDkelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttCRUDkelasActionPerformed

    private void buttViewKelasStudentTentorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttViewKelasStudentTentorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttViewKelasStudentTentorActionPerformed

    private void buttMateriKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttMateriKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttMateriKelasActionPerformed

    //get button
    public JButton getbuttTentorCR() {
        return buttTentorCR;
    }

    public JButton getbuttViewStudent() {
        return buttViewStudent;
    }

    public JButton getbuttCRUDmatapelajaran() {
        return buttCRUDmatapelajaran;
    }

    public JButton getbuttCRUDkelas() {
        return buttCRUDkelas;
    }

    public JButton getbuttViewKelasStudentTentor() {
        return buttViewKelasStudentTentor;
    }
    
    public JButton getbuttMateriKelas(){
        return buttMateriKelas;
    }
    
    public JButton getbuttAdminLoginBackHome(){
        return buttAdminLoginBackHome;
    }

    //listener 
    public void addActionListener(ActionListener AL){
        buttAdminLoginBackHome.addActionListener(AL);
        buttCRUDmatapelajaran.addActionListener(AL);
        buttCRUDkelas.addActionListener(AL);
        buttViewStudent.addActionListener(AL);
        buttTentorCR.addActionListener(AL);
        buttViewKelasStudentTentor.addActionListener(AL);
        buttMateriKelas.addActionListener(AL);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttAdminLoginBackHome;
    private javax.swing.JButton buttCRUDkelas;
    private javax.swing.JButton buttCRUDmatapelajaran;
    private javax.swing.JButton buttMateriKelas;
    private javax.swing.JButton buttTentorCR;
    private javax.swing.JButton buttViewKelasStudentTentor;
    private javax.swing.JButton buttViewStudent;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label lbALog1;
    // End of variables declaration//GEN-END:variables
}
