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
public class Admin_CRUDKelasNew extends javax.swing.JFrame {

    /**
     * Creates new form Admin_CRUDKelasNew
     */
    public Admin_CRUDKelasNew() {
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
        jPanel2 = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        buttInsert = new javax.swing.JButton();
        buttDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKelas = new javax.swing.JTable();
        buttEdit = new javax.swing.JButton();
        buttadminLoginBackHome = new javax.swing.JButton();
        lbALog4 = new java.awt.Label();
        jLabel11 = new javax.swing.JLabel();
        tf_tentorKelas = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tf_tentorIDKelas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tf_tentorNamaMapel = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tf_tentorNamaTentor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_tentorIDMapel1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTentor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(31, 40, 51));

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(11, 12, 16));
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 153, 0));
        label3.setText("Admin Page E-Learning System ");

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
                "ID ", "Nama"
            }
        ));
        jScrollPane2.setViewportView(tabelKelas);

        buttEdit.setBackground(new java.awt.Color(204, 204, 204));
        buttEdit.setText("Edit");

        buttadminLoginBackHome.setBackground(new java.awt.Color(204, 204, 204));
        buttadminLoginBackHome.setText("Home");

        lbALog4.setAlignment(java.awt.Label.CENTER);
        lbALog4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbALog4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lbALog4.setForeground(new java.awt.Color(255, 153, 0));
        lbALog4.setText("Admin CRUD Kelas");

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("KELAS");

        tf_tentorKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tentorKelasActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 0));
        jLabel17.setText("ID KELAS");

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 153, 0));
        jLabel18.setText("MAPEL");

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 0));
        jLabel19.setText("NAMA TENTOR");

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 0));
        jLabel20.setText("ID MAPEL");

        tableTentor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Tentor"
            }
        ));
        jScrollPane1.setViewportView(tableTentor);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_tentorNamaMapel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tentorIDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tentorKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tentorIDMapel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tentorNamaTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(lbALog4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(buttadminLoginBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(384, 384, 384))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbALog4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tentorKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tf_tentorIDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tf_tentorNamaMapel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_tentorIDMapel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_tentorNamaTentor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addComponent(buttInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(buttadminLoginBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttDeleteActionPerformed

    private void tf_tentorKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tentorKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tentorKelasActionPerformed

    public void resetView()
    {
      tf_tentorIDKelas.setText("");    
      tf_tentorNamaTentor.setText("");
      tf_tentorIDMapel1.setText("");
      tf_tentorKelas.setText("");
      tf_tentorNamaMapel.setText("");
      
    }

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
    
    public JButton getbuttadminLoginBackHome(){
        return buttadminLoginBackHome;
    }
    
  
    
    public void listenerAdminCRUDkelas(ActionListener AL){
       buttInsert.addActionListener(AL);
       buttEdit.addActionListener(AL);
       buttDelete.addActionListener(AL);
       buttadminLoginBackHome.addActionListener(AL);
    }
    
    public void addMouseAdapter(MouseAdapter ma){
        tabelKelas.addMouseListener(ma);
        tableTentor.addMouseListener(ma);
    }
    
    public void setCRUDKelas(DefaultTableModel tabel)
    {
        tabelKelas.setModel(tabel);
    }
    
    public int getSelectedKelas()
    {
        return tabelKelas.getSelectedRow();
    }

    public JTable getTabelKelas() {
        return tabelKelas;
    }
    
    public void setCRUDTentor(DefaultTableModel tabel)
    {
        tableTentor.setModel(tabel);
    }
    
    public int getSelectedTentor()
    {
        return tableTentor.getSelectedRow();
    }

    public JTable getTabelTentor() {
        return tableTentor;
    }
    
//get text field
        
    public String getTf_tentorIDKelas() {
        return tf_tentorIDKelas.getText();
    }

    public String getTf_tentorNamaTentor() {
        return tf_tentorNamaTentor.getText();
    }

    public String getTf_tentorIDMapel1() {
        return tf_tentorIDMapel1.getText();
    }

    public String getTf_tentorKelas() {
        return tf_tentorKelas.getText();
    }

    public String getTf_tentorNamaMapel() {
        return tf_tentorNamaMapel.getText();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttDelete;
    private javax.swing.JButton buttEdit;
    private javax.swing.JButton buttInsert;
    private javax.swing.JButton buttadminLoginBackHome;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label3;
    private java.awt.Label lbALog4;
    private javax.swing.JTable tabelKelas;
    private javax.swing.JTable tableTentor;
    private javax.swing.JTextField tf_tentorIDKelas;
    private javax.swing.JTextField tf_tentorIDMapel1;
    private javax.swing.JTextField tf_tentorKelas;
    private javax.swing.JTextField tf_tentorNamaMapel;
    private javax.swing.JTextField tf_tentorNamaTentor;
    // End of variables declaration//GEN-END:variables
}
