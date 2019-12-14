/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.*;
import eLearning.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class adminCRUDkelasController extends MouseAdapter implements ActionListener{
   private View.Admin_CRUDKelasNew view = new Admin_CRUDKelasNew();
   private Application model;
   private Database db = new Database();
   private List<Kelas> kelas = new ArrayList();
   private List<Tentor> tenTor = new ArrayList();
   private int selectedIdx;

    public adminCRUDkelasController()
    {
        model = new Application();
        view.listenerAdminCRUDkelas(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        tenTor = db.getAllTentor();
        kelas = db.getAllKelas();
        loadTableKelas();
        loadTableTentor();
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getbuttInsert()))
        {
            String name = view.getTf_tentorNamaTentor();
            String namaKelas = view.getTf_tentorKelas();
            String buatKelasID = view.getTf_tentorIDKelas();
            String namaMapel = view.getTf_tentorNamaMapel();
            String idMapel = view.getTf_tentorIDMapel1();
            if(!(name.equals("") && namaKelas.equals("") && buatKelasID.equals("") && namaMapel.equals("") && idMapel.equals(""))){
                try {
                if(model.checkID(view.getTf_tentorIDKelas())){
                    mataPelajaran m = new mataPelajaran(idMapel,namaMapel);
                    Kelas k = new Kelas(namaKelas,buatKelasID);
                    Tentor t = findTentorData(name);
                    System.out.println(k.getIdKelas());
                    k.addMapel(m);
                    db.insertKelas(k);
                    db.updateKelas(k, t);
                    db.insertKelasTentor(k, name);
                    db.insertMapel(m);
                    db.updateMapel(m, buatKelasID);
                    loadTableKelas();
                    view.resetView();
                    }else{
                        JOptionPane.showMessageDialog(null, "ID KELAS SUDAH ADA");
                        view.resetView();        
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(tentorDataDiriController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }else {
                JOptionPane.showMessageDialog(null, "KOLOM HARUS DIISI");
                view.resetView(); 
            }
            
           
        } 
        else if(src.equals(view.getbuttEdit()))
        {
            String name = view.getTf_tentorKelas();
            String id = view.getTf_tentorIDKelas();
            String namaMapel = view.getTf_tentorNamaMapel();
            String idMapel = view.getTf_tentorIDMapel1();
            mataPelajaran lama = findMapelData(idMapel);
            mataPelajaran baru = new mataPelajaran(idMapel,namaMapel);
            Kelas k = new Kelas(name,id);
            db.updateDataMapel(lama, baru, id);
            db.updateKelasMapel(k, baru);
            loadTableKelas();
            view.resetView();
        }
        else if(src.equals(view.getbuttDelete()))
        {
            String name = view.getTf_tentorKelas();
            String id = view.getTf_tentorIDKelas();
            String namaMapel = view.getTf_tentorNamaMapel();
            String idMapel = view.getTf_tentorIDMapel1();
            String namaTentor = view.getTf_tentorNamaTentor();
            mataPelajaran m = new mataPelajaran(idMapel,namaMapel);
            Kelas k = new Kelas(name,id);
            db.deleteKelas(k);
            db.updateMapelHapus(m);
            db.deleteListTentor(k, namaTentor);
            loadTableKelas();
            
        }
        else 
        {
            view.dispose();
            new adminMenuController();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getTabelKelas())) 
        {
            selectedIdx = view.getSelectedKelas();
        }
       
    }
        
    public void loadTableKelas() {
        DefaultTableModel tabelCRUDKelas = new DefaultTableModel(new String[]{"Nama ","Id "}, 0);
        List<Kelas> list = kelas;
        for (int i=0;i<list.size();i++) {
            tabelCRUDKelas.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdKelas()});
        }
        view.setCRUDKelas(tabelCRUDKelas);
    }
    public void loadTableTentor() {
        DefaultTableModel tabelCRUDTentor = new DefaultTableModel(new String[]{"Nama "}, 0);
        List<Tentor> listTentor = tenTor;
        for (int i=0;i<listTentor.size();i++) {
            tabelCRUDTentor.addRow(new Object[]{listTentor.get(i).getName()});
        }
        view.setCRUDTentor(tabelCRUDTentor);
    }

    public Tentor findTentorData(String nama){
        Tentor t = null;
        for(int i = 0; i<tenTor.size();i++){
            if (tenTor.get(i).getName().equals(nama)){
                t = tenTor.get(i);
                break;
            }
        }
        return t;
    }  
    public mataPelajaran findMapelData(String idMapel){
        mataPelajaran t = null;
        List<mataPelajaran> newMapel = db.getAllMapel();
        for(int i = 0; i<newMapel.size();i++){
            if (newMapel.get(i).getIdMapel().equals(idMapel)){
                t = newMapel.get(i);
                break;
            }
        }
        return t;
    }  
}
