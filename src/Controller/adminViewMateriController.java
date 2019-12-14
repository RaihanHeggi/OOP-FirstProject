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
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class adminViewMateriController extends MouseAdapter implements ActionListener{
    private View.Admin_viewMateri view = new Admin_viewMateri();
    private eLearning.Application model = new eLearning.Application();
    private List<Kelas> kelas = new ArrayList();
    private int selectedIdx,selectedIndex;
    private Database db;
    
    
    public adminViewMateriController() {
        view.listenerAdminViewMateri(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        db = new Database();
        kelas = db.getAllKelas();
        loadTableIDKelas();
        model = new eLearning.Application();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
        if (src.equals(view.getbuttbacktoAdminMenu()))
        {
            new adminMenuController();
            view.dispose();
        }
        else if(src.equals(view.getButtTampilData()))
        {
            loadTabletenTor(kelas.get(selectedIndex).getIdKelas());  

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
        List<Kelas> list = kelas;
        List<Materi> newMateri = db.loadMateriTertentu(idKelas);
        for(int i =0; i<newMateri.size();i++){
            tabelMateri.addRow(new Object[]{newMateri.get(i).getName(),newMateri.get(i).getIdMateri()}); 
        }
        view.setCRUDMateri(tabelMateri);
    }
    
    public void loadTableIDKelas() {
        DefaultTableModel tabelCRUDKelas = new DefaultTableModel(new String[]{"Nama Kelas","ID Kelas"}, 0);
        List<Kelas> list = kelas;
        for (int i=0;i<list.size();i++) {
            tabelCRUDKelas.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdKelas()});
        }
        view.setTableIDKelas(tabelCRUDKelas);
    }
    
}
