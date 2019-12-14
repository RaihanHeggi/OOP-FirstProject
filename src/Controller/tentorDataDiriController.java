/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.*;
import eLearning.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class tentorDataDiriController extends MouseAdapter implements ActionListener {
    private Tentor_dataDirinew view;
    private Application model;
    private Database db;
    private ArrayList<Tentor> tenTor = new ArrayList();
    private List<Kelas> kelasSpesifik = new ArrayList<>();
    private List<Kelas> kelas = new ArrayList<>();
    private int selectedIdx,selectedIndex;
    private Tentor tentor ;
    private String uname;
    
    public tentorDataDiriController(String username) {
        view = new Tentor_dataDirinew();
        model = new Application();
        db = new Database();
        view.listenerTentorDataDiri(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        uname = username;     
        tenTor = db.getAllTentor();
        tentor = findTentorData(uname);
        kelas = model.getListKelas();
        kelasSpesifik = db.getAllKelasTentor(tentor.getName());
        loadTableKelasAjar();
        loadTabletenTor();
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getbuttEdit()))
        {
            String name = view.gettf_tentorName();
            String uname = view.gettf_tentorUsername();
            String pass = view.getTf_tentorPassword();
            String kelas = view.gettf_tentorKelas();
            String id = view.gettf_tentorID();
            int umur = view.getcb_tentorUmurValue();
            Tentor x = findTentorData(uname);
            Tentor t = new Tentor(name,id,umur,uname,pass);           
            Tentor n = findTentorData(uname);
            db.updateTentor(t, n.getName());
                     
        }
        else if(src.equals(view.getbuttDelete()))
        {
            String name = view.gettf_tentorName();
            String kelas = view.gettf_tentorKelas();
            String idKelas = view.getTf_tentorIDKelas();
            String id = view.gettf_tentorID();
            System.out.println(selectedIndex);
            Kelas k = new Kelas(kelas,idKelas);
            db.deleteListTentor(k,name);
            db.deleteKelas(k);
            kelasSpesifik = db.loadKelasTertentu(tentor.getName());
            loadTableKelasAjar();
            view.resetView();
        }
        else if(src.equals(view.getButtTambah()))
        {
            String name = view.gettf_tentorName();
            String kelas = view.gettf_tentorKelas();
            String id = view.gettf_tentorID();
            int idKelas = selectedIndex;
            String buatKelasID = view.getTf_tentorIDKelas();
            String namaMapel = view.getTf_tentorNamaMapel();
            String idMapel = view.getTf_tentorIDMapel();
            try {
                if(model.checkID(view.getTf_tentorIDKelas())){
                    mataPelajaran m = new mataPelajaran(idMapel,namaMapel);
                    Kelas k = new Kelas(kelas,buatKelasID);
                    Tentor t = findTentorData(uname);
                    System.out.println(k.getIdKelas());
                    k.addMapel(m);
                    db.insertKelas(k);
                    db.updateKelas(k, t);
                    db.insertKelasTentor(k, name);
                    db.insertMapel(m);
                    loadTableKelasAjar();
                    view.resetView();
                }else{
                    JOptionPane.showMessageDialog(null, "ID KELAS SUDAH ADA");
                    view.resetView();        
                }
            } catch (SQLException ex) {
                Logger.getLogger(tentorDataDiriController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
        else if(src.equals(view.getTambahMateri()))
        {
            new tentorCRUDMateriController(uname);
            view.dispose();
        }
        else 
        {
            view.dispose();
            new tentorMenuController(uname);
        }        
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getTabelTentorDataDiri())) 
        {
            selectedIdx = view.getSelectedTentor();
            System.out.println(selectedIdx);
        }       
    }
    
    public void loadTabletenTor() {
        DefaultTableModel tabelCRUDmateri = new DefaultTableModel(new String[]{"Nama"," ID"," Umur"," Username"," Password"}, 0);
        ArrayList<Tentor> list = tenTor;
        for (int i=0;i<list.size();i++) {
            if(list.get(i).getUsernameTentor().equals(uname)){
            tabelCRUDmateri.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdTentor(),list.get(i).getAge(),list.get(i).getUsernameTentor(),list.get(i).getPassTentor()});
            }
        }
        view.setTentorDataDiri(tabelCRUDmateri);
    }
    public void loadTableKelasAjar() {
        DefaultTableModel tabelCRUDKelas = new DefaultTableModel(new String[]{"Kelas"}, 0);
        List<Kelas> list = kelasSpesifik;
        for (int i=0;i<list.size();i++) {
            tabelCRUDKelas.addRow(new Object[]{list.get(i).getName()});
        }
        view.setTentorKelasAjar(tabelCRUDKelas);
    }
    
    public Tentor findTentorData(String username){
        Tentor t = null;
        for(int i = 0; i<tenTor.size();i++){
            if (tenTor.get(i).getUsernameTentor().equals(username)){
                t = tenTor.get(i);
                break;
            }
        }
        return t;
    }    
        
    
     public boolean checkIDKelas(String idKelas,String namaKelas){
        for (int i = 0; i<kelas.size();i++)
        {
            if (kelas.get(i).getIdKelas().equals(idKelas))
            {
                return false;
            }
        }
        return true;
    }
}
