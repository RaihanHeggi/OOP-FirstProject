/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.Tentor_CRUDMateriNew;
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
public class tentorCRUDMateriController extends MouseAdapter implements ActionListener {
    private View.Tentor_CRUDMateriNew view;
    private Materi model;
    private Database db;
    private List<Materi> materi = new ArrayList();
    private List<Kelas> newKelas = new ArrayList();
    private Materi materiInput;
    private int selectedIdx,selectedIndex;
    private String username;

    public tentorCRUDMateriController(String uname) {
        view = new Tentor_CRUDMateriNew();
        model = new Materi("","");
        db = new Database();
        view.listenerTentorCRUDMateri(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        username = uname;
        Tentor t = findTentorData(uname);
        materi = db.getAllMateri();
        newKelas = db.getAllKelasTentor(t.getName());
        loadTableIDKelas();
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getbuttInsert()))
        {
            String namaMateri = view.gettf_tentorMateri();
            String idMateri = view.getTf_tentorIDMateri();
            String idKelas = view.gettf_tentorKelas();
            String namaKelas = view.gettf_tentorNameKelas();
            if(!((idKelas.equals("")) || (idMateri.equals("")) || (namaMateri.equals("")))){
                Kelas k = new Kelas(namaKelas,idKelas);       
                Materi m = new Materi(idMateri,namaMateri);
                db.insertMateri(m);
                db.updateMateri(m, idKelas);    
                db.updateKelasMateri(k, m); 
                view.resetView();
                resetTable();
            }else {
               JOptionPane.showMessageDialog(null, "KOLOM IDKELAS,IDMAPEL,NAMAKELAS TIDAK BOLEH KOSONG");
               view.resetView();
            }   
        }
        else if(src.equals(view.getbuttEdit()))
        {
            new tentor_EditMateri(username);
            view.dispose();
 
        }
        else if(src.equals(view.getbuttDelete()))
        {
            String id = view.getTf_tentorIDMateri();
            String name = view.gettf_tentorMateri();
            Materi m = new Materi(id,name);
            if(!((id.equals("")) || (name.equals("")))){
                db.deleteMateri(m);
            }else {
               JOptionPane.showMessageDialog(null, "KOLOM IDMAPEL,NAMAMAPEL TIDAK BOLEH KOSONG");
               view.resetView();
            }
            
        }
        else if (src.equals(view.getButtTampilData()))
        {          
          loadTabletenTor(newKelas.get(selectedIndex).getIdKelas());  
            
        }
        else 
        {
            view.dispose();
            new tentorDataDiriController(username);
        }
    }
    
     @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getTabelKelas())) 
        {
            selectedIdx = view.getSelectedKelas();
            System.out.println(selectedIdx);
        } 
        else if(source.equals(view.getTabelIDKelas())){
            selectedIndex = view.getSelectedIDKelas();
            System.out.println(selectedIndex);
        }
    }
    
    public void loadTabletenTor(String idKelas) {
        DefaultTableModel tabelMateri = new DefaultTableModel(new String[]{"Materi ", "ID Materi "}, 0);
        List<Kelas> list = newKelas;
        List<Materi> newMateri = db.loadMateriTertentu(idKelas);
        for(int i =0; i<newMateri.size();i++){
            tabelMateri.addRow(new Object[]{newMateri.get(i).getName(),newMateri.get(i).getIdMateri()}); 
        }
        view.setCRUDMateri(tabelMateri);
    }
    
    public void loadTableIDKelas() {
        DefaultTableModel tabelCRUDKelas = new DefaultTableModel(new String[]{"Nama Kelas","ID Kelas"}, 0);
        List<Kelas> list = newKelas;
        for (int i=0;i<list.size();i++) {
            tabelCRUDKelas.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdKelas()});
        }
        view.setTableIDKelas(tabelCRUDKelas);
    }
    
    public void resetTable(){
        DefaultTableModel tabelMateri = new DefaultTableModel(new String[]{"Materi","ID Materi"}, 0);
        tabelMateri.addRow(new Object[]{"",""});
        view.setCRUDMateri(tabelMateri);
    }
    
   public Tentor findTentorData(String username){
        List<Tentor> findTentor = db.getAllTentor();
        Tentor s = null;
        for(Tentor p : findTentor){
            if(p.getUsernameTentor().equals(username)){
                s = new Tentor(p.getName(),p.getIdTentor(),p.getAge(),p.getUsernameTentor(),p.getPassTentor());
                break;
            }
        }
        return s;
    }
}

