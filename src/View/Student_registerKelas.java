/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Student_registerKelas extends javax.swing.JFrame {

    /**
     * Creates new form Student_registerKelas
     */
    public Student_registerKelas() {
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
        tf_studentRegisKelasTentor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        tf_studentRegisKelasName = new javax.swing.JTextField();
        buttInsert = new javax.swing.JButton();
        tf_studentRegisKelas = new javax.swing.JTextField();
        buttDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKelas = new javax.swing.JTable();
        buttstudentRegistKelasBackHome = new javax.swing.JButton();
        lbALog4 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 40, 51));

        tf_studentRegisKelasTentor.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tf_studentRegisKelasTentor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_studentRegisKelasTentorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Kelas");

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("Tentor");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("ID Siswa");

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(11, 12, 16));
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 153, 0));
        label3.setText("Student Page E-Learning System ");

        buttInsert.setBackground(new java.awt.Color(204, 204, 204));
        buttInsert.setText("Tambah");

        buttDelete.setBackground(new java.awt.Color(204, 204, 204));
        buttDelete.setText("Hapus");
        buttDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttDeleteActionPerformed(evt);
            }
        });

        tabelKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Tentor", "Kelas"
            }
        ));
        jScrollPane2.setViewportView(tabelKelas);

        buttstudentRegistKelasBackHome.setBackground(new java.awt.Color(204, 204, 204));
        buttstudentRegistKelasBackHome.setText("Home");

        lbALog4.setAlignment(java.awt.Label.CENTER);
        lbALog4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbALog4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lbALog4.setForeground(new java.awt.Color(255, 153, 0));
        lbALog4.setText("Student Registrasi Kelas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_studentRegisKelasName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_studentRegisKelasTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_studentRegisKelas)))
                .addGap(184, 184, 184))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(lbALog4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(buttstudentRegistKelasBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(598, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttDelete)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbALog4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_studentRegisKelasName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_studentRegisKelasTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_studentRegisKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttInsert)
                    .addComponent(buttDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(buttstudentRegistKelasBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void buttDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttDeleteActionPerformed

    private void tf_studentRegisKelasTentorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_studentRegisKelasTentorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_studentRegisKelasTentorActionPerformed

//get button 
    public JButton getbuttInsert(){
        return buttInsert;
    }
    
    public JButton getbuttDelete(){
        return buttDelete;
    }
    
    public JButton buttstudentRegistKelasBackHome(){
        return buttstudentRegistKelasBackHome;
    }
    
    public void listenerStudentRegisterKelas(ActionListener AL){
       buttInsert.addActionListener(AL);
       buttDelete.addActionListener(AL);
       buttstudentRegistKelasBackHome.addActionListener(AL);
    }
    public void addMouseAdapter(MouseAdapter ma){
        tabelKelas.addMouseListener(ma);
    }

    
    //Set Tabel
    public void setKelas(DefaultTableModel tabel)
    {
        tabelKelas.setModel(tabel);
    }
    public int getSelectedKelas()
    {
        return tabelKelas.getSelectedRow();
    }
    public void resetView()
    {
        tf_studentRegisKelas.setText("");
        tf_studentRegisKelasName.setText("");
        tf_studentRegisKelasTentor.setText("");
    }

    public JTable getTabelKelas() {
        return tabelKelas;
    }
    
    
//get text field
    
    public void setTf_studentRegisKelasName(String s){
        tf_studentRegisKelasName.setText(s);
    }

    public String gettf_studentRegisKelas() {
        return tf_studentRegisKelas.getText();
    }
    
    public String gettf_studentRegisKelasName(){
        return tf_studentRegisKelasName.getText();
    }
    
    public String gettf_studentRegisKelasTentor(){
        return tf_studentRegisKelasTentor.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttDelete;
    private javax.swing.JButton buttInsert;
    private javax.swing.JButton buttstudentRegistKelasBackHome;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label3;
    private java.awt.Label lbALog4;
    private javax.swing.JTable tabelKelas;
    private javax.swing.JTextField tf_studentRegisKelas;
    private javax.swing.JTextField tf_studentRegisKelasName;
    private javax.swing.JTextField tf_studentRegisKelasTentor;
    // End of variables declaration//GEN-END:variables
}
