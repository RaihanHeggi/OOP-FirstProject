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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import eLearning.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class adminCRUDmatapelajaranController extends MouseAdapter implements ActionListener{
    private View.Admin_CRUDMataPelajaranNew view = new View.Admin_CRUDMataPelajaranNew();
    private Application model;
    private Database db = new Database();
    private List<Kelas> newKelas = new ArrayList<>();
    private List<Tentor> tenTor = new ArrayList();
    private int selectedIdx;
    
    public adminCRUDmatapelajaranController() {
        view.listenerAdminCRUDkelas(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        model = new Application();
        newKelas = db.getAllKelas();
        tenTor = db.getAllTentor();
        loadMapel();
        loadTableKelas();
        loadTableTentor();
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getbuttInsert()))
        {
            String name = view.gettf_mapelName();
            String id = view.gettf_mapelId();
            
            if (name.isEmpty() || id.isEmpty()){
                JOptionPane.showMessageDialog(null, "KOLOM TIDAK BOLEH KOSONG");
            }else{
                mataPelajaran model = new mataPelajaran(name, id);
                db.insertMapel(model);
                view.resetView();
            }
        }
        else if(src.equals(view.getbuttEdit()))
        {
            String name = view.gettf_mapelName();
            String namaBaru = view.getTf_mapelNameBaru();
            String id = view.gettf_mapelId();
            String idKelas = view.getTf_idKelas();
            mataPelajaran baru = new mataPelajaran(namaBaru, id);
            mataPelajaran lama = new mataPelajaran(name,id);
            db.updateDataMapel(lama, baru, idKelas);
            loadMapel();
        }
        else if(src.equals(view.getbuttDelete()))
        {
            String id = view.getTf_idKelas();
            String namaMapel = view.gettf_mapelName();
            String idMapel = view.gettf_mapelId();
            String namaTentor = view.getTf_tentorNamaTentor();
            mataPelajaran m = new mataPelajaran(idMapel,namaMapel);
            Kelas k = findKelasData(id);
            if(id.equals("")){
                db.deleteMataPelajaran(m);
            }else {
                db.deleteMataPelajaran(m);
                db.updateKelasMapelHapus(k);
            }
        }
        else if(src.equals(view.getButtAddKelas()))
        {
            String nama = view.gettf_mapelName();
            String id = view.gettf_mapelId();
            String idKelas = view.getTf_idKelas();
            String namaTentor = view.getTf_tentorNamaTentor();
            if(!(nama.equals("") || (id.equals("") || (idKelas.equals("") || namaTentor.equals(""))))){
                try {
                    if(model.checkKelasAvaible(idKelas) && model.checkTentorAvaible(namaTentor)){
                        mataPelajaran m = new mataPelajaran(id,nama);
                        Kelas k = findKelasData(idKelas);
                        Tentor t = findTentorData(namaTentor);
                        if(k == null){
                        JOptionPane.showMessageDialog(null, "KELAS TIDAK VALID");   
                        }else{
                            k.addMapel(m);
                            db.insertKelas(k);
                            db.updateKelas(k, t);
                            db.insertKelasTentor(k, namaTentor);
                            db.insertMapel(m);
                            db.updateMapel(m, k.getName());
                            loadTableKelas();
                            view.resetView();  
                        }        
                    }else{
                        JOptionPane.showMessageDialog(null, "DATA TIDAK VALID");
                        view.resetView();        
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(adminCRUDmatapelajaranController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
               JOptionPane.showMessageDialog(null, "KOLOM TIDAK BOLEH KOSONG"); 
            }  
        }   
        else 
        {
            view.dispose();
            new adminMenuController();
        }
    }
    
    public void loadMapel() {
        DefaultTableModel tabelMapel = new DefaultTableModel(new String[]{"Nama ","ID "}, 0);
        ArrayList<mataPelajaran> list = db.getAllMapel();
        for (int i=0;i<list.size();i++) {
            tabelMapel.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdMapel()});
        }
        view.setCRUDmataPelajaran(tabelMapel);
    }
    
    public void loadTableKelas() {
        DefaultTableModel tabelCRUDTentor = new DefaultTableModel(new String[]{"Nama "}, 0);
        List<Kelas> listKelas = newKelas;
        for (int i=0;i<listKelas.size();i++) {
            tabelCRUDTentor.addRow(new Object[]{listKelas.get(i).getIdKelas()});
        }
        view.setCRUDKelas(tabelCRUDTentor);
    }
    
    public void loadTableTentor() {
        DefaultTableModel tabelCRUDTentor = new DefaultTableModel(new String[]{"Nama "}, 0);
        List<Tentor> listKelas = tenTor;
        for (int i=0;i<listKelas.size();i++) {
            tabelCRUDTentor.addRow(new Object[]{listKelas.get(i).getName()});
        }
        view.setCRUDKelas1(tabelCRUDTentor);
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
    public Kelas findKelasData(String idKelas){
        Kelas t = null;
        List<Kelas> newKelas = db.getAllKelas();
        for(int i = 0; i<newKelas.size();i++){
            if (newKelas.get(i).getIdKelas().equals(idKelas)){
                t = newKelas.get(i);
                break;
            }
        }
        return t;
    } 
}