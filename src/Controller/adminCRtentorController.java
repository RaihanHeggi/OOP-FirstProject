/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Admin_CRTentorNew;
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
public class adminCRtentorController extends MouseAdapter implements ActionListener{
    private View.Admin_CRTentorNew view = new View.Admin_CRTentorNew();
    private Application model;
    private Database db;
    private List<Tentor> tenTor = new ArrayList<>();
    private int selectedIdx;

    public adminCRtentorController() {
        view = new Admin_CRTentorNew();
        model = new Application();
        db = new Database();
        view.listenerAdminCRUDkelas(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        tenTor = db.getAllTentor();
        loadTabletenTor();
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getbuttInsert()))
        {
            String nama = view.gettf_tentorName();
            String id = view.getTf_tentorID();
            int umur = view.getTf_tentorUmur();
            String username = view.gettf_tentorUsername();
            String pass = view.getTf_tentorPass();            
            if (nama.isEmpty() && id.isEmpty() && username.isEmpty() && pass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error");
                view.resetView();
            }else{
                try {
                    if(model.checkTentor(id, nama)){
                        Tentor t = new Tentor(nama,id,umur,username,pass);
                        db.insertTentor(t);
                    }else {
                        JOptionPane.showMessageDialog(null, "Error");
                        view.resetView();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(adminCRtentorController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }   
        }
        else if(src.equals(view.getbuttHapus()))
        {
            String nama = view.gettf_tentorName();
            String id = view.getTf_tentorID();
            int umur = view.getTf_tentorUmur();
            String username = view.gettf_tentorUsername();
            String pass = view.getTf_tentorPass();    
            Tentor t = new Tentor(nama,id,umur,username,pass);
             if (nama.isEmpty() || id.isEmpty() || username.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error");
                view.resetView();
            } else{
                try {
                    if(model.checkTentorKelas(nama)){
                        List<Kelas> newKelas = db.getAllKelasTentor(t.getName());
                        db.deleteTentor(t);
                        db.deleteListTentorAll(nama);
                        for(Kelas p : newKelas){
                            db.updateMateriTentor(p.getIdKelas());
                            db.updateMapelTentor(p.getIdKelas());
                            db.deleteListStudentTentor(p,nama);
                            db.deleteKelasTentor(p, t);
                        }
                }else {
                    db.deleteTentor(t);
                }
            } catch (SQLException ex) {
                Logger.getLogger(adminCRtentorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        else if (src.equals(view.getbuttadminLoginBackHome()))
        {
            new adminMenuController();
            view.dispose();
        }
    }
        public void loadTabletenTor() {
        DefaultTableModel tabelCRTentor = new DefaultTableModel(new String[]{"Nama ","ID","Umur","Username","Password"}, 0);
        List<Tentor> list = tenTor;
        for (int i=0;i<list.size();i++) {
            tabelCRTentor.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdTentor(),list.get(i).getAge(),list.get(i).getUsernameTentor(),list.get(i).getPassTentor()});
        }
        view.setCRTentor(tabelCRTentor);
        }
}