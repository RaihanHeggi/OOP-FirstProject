/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.*;
import eLearning.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class tentorMenuController extends MouseAdapter implements ActionListener{
    private View.Tentor_Menu view = new View.Tentor_Menu();;
    private eLearning.Tentor model = new eLearning.Tentor("",0);
    private List<Kelas> newKelas;  
    private Tentor t;
    private Database db;
    private String uname;
    private int selectedIndex;

    public tentorMenuController(String username) {
        view.addActionListener(this);
        view.addMouseListener(this);
        view.setVisible(true);
        db = new Database();
        uname = username;
        t = findTentorData(username);
        newKelas = db.getAllKelasTentor(t.getName());
        loadTableIDKelas();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getButtonLihatKelasDanStudent()))
        {
            new tentorViewKelasStudentController(uname);
            view.dispose();
        }
        else if (src.equals(view.getButtonUbahDataDiri()))
        {
            new tentorDataDiriController(uname);
            view.dispose();
            
        }
        else if (src.equals(view.getButtTampilData()))
        {
          loadTabletenTor(newKelas.get(selectedIndex).getIdKelas());    
        }
        else 
        {
            view.dispose();
            new HomeGUIController();
        }
    }
    
       
    @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if(source.equals(view.getTabelIDKelas())){
            selectedIndex = view.getSelectedIDKelas();
            System.out.println(selectedIndex);
        }
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
        DefaultTableModel tabelCRUDKelas = new DefaultTableModel(new String[]{"Nama Kelas"}, 0);
        List<Kelas> list = newKelas;
        for (int i=0;i<list.size();i++) {
            tabelCRUDKelas.addRow(new Object[]{list.get(i).getName()});
        }
        view.setTableIDKelas(tabelCRUDKelas);
    }


}
