/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Admin_CRUDMataPelajaranNew extends javax.swing.JFrame {

    /**
     * Creates new form Admin_CRUDMataPelajaranNew
     */
    public Admin_CRUDMataPelajaranNew() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        tf_mapelId = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        tf_mapelName = new javax.swing.JTextField();
        buttInsert = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelmataPelajaran = new javax.swing.JTable();
        buttadminLoginBackHome = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbALog4 = new java.awt.Label();
        jLabel14 = new javax.swing.JLabel();
        buttDelete = new javax.swing.JButton();
        buttEdit = new javax.swing.JButton();
        buttAddKelas = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tf_idKelas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tf_mapelNameBaru = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTentor = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        tf_tentorNamaTentor = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableTentor1 = new javax.swing.JTable();

        jScrollPane1.setViewportView(jEditorPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 40, 51));

        tf_mapelId.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tf_mapelId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mapelIdActionPerformed(evt);
            }
        });

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(11, 12, 16));
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 153, 0));
        label3.setText("Admin Page E-Learning System ");

        buttInsert.setBackground(new java.awt.Color(204, 204, 204));
        buttInsert.setText("Tambah Mapel");
        buttInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttInsertActionPerformed(evt);
            }
        });

        TabelmataPelajaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Id"
            }
        ));
        jScrollPane2.setViewportView(TabelmataPelajaran);

        buttadminLoginBackHome.setBackground(new java.awt.Color(204, 204, 204));
        buttadminLoginBackHome.setText("Home");

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("ID KELAS");

        lbALog4.setAlignment(java.awt.Label.CENTER);
        lbALog4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbALog4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lbALog4.setForeground(new java.awt.Color(255, 153, 0));
        lbALog4.setText("Admin CRUD MataPelajaran");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("NAMA ");

        buttDelete.setBackground(new java.awt.Color(204, 204, 204));
        buttDelete.setText("Hapus");
        buttDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttDeleteActionPerformed(evt);
            }
        });

        buttEdit.setBackground(new java.awt.Color(204, 204, 204));
        buttEdit.setText("Edit");

        buttAddKelas.setBackground(new java.awt.Color(204, 204, 204));
        buttAddKelas.setText("Kelas");

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("ID MAPEL");

        tf_idKelas.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tf_idKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idKelasActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 0));
        jLabel15.setText("NAMA BARU ");

        tableTentor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Kelas"
            }
        ));
        jScrollPane3.setViewportView(tableTentor);

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 0));
        jLabel19.setText("NAMA TENTOR");

        tableTentor1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Tentor"
            }
        ));
        jScrollPane5.setViewportView(tableTentor1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_mapelName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_mapelNameBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_mapelId, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_idKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tentorNamaTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(buttadminLoginBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttAddKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbALog4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbALog4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(tf_mapelName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_mapelNameBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_mapelId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_idKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_tentorNamaTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(28, 28, 28)
                .addComponent(buttInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttDelete)
                            .addComponent(buttEdit)
                            .addComponent(buttAddKelas))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(buttadminLoginBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_mapelIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mapelIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mapelIdActionPerformed

    private void buttDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttDeleteActionPerformed

    private void tf_idKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idKelasActionPerformed

    private void buttInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttInsertActionPerformed

    //get button 
    public JButton getbuttInsert(){
        return buttInsert;
    }
    
    public JButton getbuttEdit(){
        return buttEdit;
    }
    
    public JButton getbuttDelete(){
        return buttDelete;
    }

    public JButton getButtAddKelas() {
        return buttAddKelas;
    }
    public JButton getbuttadminLoginBackHome(){
        return buttadminLoginBackHome;
    }
    
    
    public void listenerAdminCRUDkelas(ActionListener AL){
       buttInsert.addActionListener(AL);
       buttEdit.addActionListener(AL);
       buttDelete.addActionListener(AL);
       buttAddKelas.addActionListener(AL);
       buttadminLoginBackHome.addActionListener(AL);
    }
    
    public void addMouseAdapter(MouseAdapter ma){
        TabelmataPelajaran.addMouseListener(ma);
    }
    
    public void setCRUDmataPelajaran(DefaultTableModel tabel)
    {
        TabelmataPelajaran.setModel(tabel);
    }
    
    public int getSelectedMatapelajaran()
    {
        return TabelmataPelajaran.getSelectedRow();
    }

    public JTable getTabelMatapelajaran() {
        return TabelmataPelajaran;
    }
    public void setCRUDKelas(DefaultTableModel tabel)
    {
        tableTentor.setModel(tabel);
    }
    
    public int getSelectedKelas()
    {
        return tableTentor.getSelectedRow();
    }

    public JTable getTabelKelas() {
        return tableTentor;
    }
    public void setCRUDKelas1(DefaultTableModel tabel)
    {
        tableTentor1.setModel(tabel);
    }
    
    public int getSelectedKelas1()
    {
        return tableTentor1.getSelectedRow();
    }

    public JTable getTabelKelas1() {
        return tableTentor1;
    }
    
//get text field
    public void resetView()
    {
        tf_mapelName.setText("");
        tf_mapelId.setText("");
        tf_idKelas.setText("");
        tf_mapelNameBaru.setText("");
        tf_tentorNamaTentor.setText("");
    }
    
    public String gettf_mapelName(){
        return tf_mapelName.getText();
    }
    
    public String gettf_mapelId(){
        return tf_mapelId.getText();
    }

    public String getTf_idKelas() {
        return tf_idKelas.getText();
    }

    public String getTf_mapelNameBaru() {
        return tf_mapelNameBaru.getText();
    }

    public String getTf_tentorNamaTentor() {
        return tf_tentorNamaTentor.getText();
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelmataPelajaran;
    private javax.swing.JButton buttAddKelas;
    private javax.swing.JButton buttDelete;
    private javax.swing.JButton buttEdit;
    private javax.swing.JButton buttInsert;
    private javax.swing.JButton buttadminLoginBackHome;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label label3;
    private java.awt.Label lbALog4;
    private javax.swing.JTable tableTentor;
    private javax.swing.JTable tableTentor1;
    private javax.swing.JTextField tf_idKelas;
    private javax.swing.JTextField tf_mapelId;
    private javax.swing.JTextField tf_mapelName;
    private javax.swing.JTextField tf_mapelNameBaru;
    private javax.swing.JTextField tf_tentorNamaTentor;
    // End of variables declaration//GEN-END:variables
}
