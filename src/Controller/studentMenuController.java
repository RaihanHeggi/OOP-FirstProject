/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.*;
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
 * @author user
 */
public class studentMenuController extends MouseAdapter implements ActionListener {
    private List<Kelas> daftarKelasStudent;
    private View.Student_Menu view;
    private eLearning.Application model;
    Database db = new Database();
    private String username;
    private int selectedIndex;
    
    public studentMenuController(String uname){
            daftarKelasStudent = new ArrayList();
            view = new Student_Menu();
            model = new Application();
            view.addActionListener(this);
            view.addMouseAdapter(this);
            view.setVisible(true);  
            username = uname;
            Student s = findStudent(uname);
            daftarKelasStudent = db.getAllKelasStudent(s.getIdSiswa());
            loadTableIDKelas();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if(src.equals(view.getButtonUbahDiri())){
            new studentDataDiriController(username);
            view.dispose();
        }else if (src.equals(view.getButtonRegistrasiKelas())){
            new studentRegisterKelasController(username);
            view.dispose();
        }else if (src.equals(view.getButtTampilData())){ 
            System.out.println(selectedIndex);
            loadTabletenTor(daftarKelasStudent.get(selectedIndex).getIdKelas());    
        }else{
            new studentLoginController();
            view.dispose();
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

    
    
    public Student findStudent(String username){
        List<Student> findStudent = db.getAllStudent();
        Student s = null;
        for(Student p : findStudent){
            if(p.getUsernameSiswa().equals(username)){
                s = new Student(p.getName(),p.getUmur(),p.getIdSiswa(),p.getUsernameSiswa(),p.getPassSiswa());
                break;
            }
        }
        return s;
    }
    
    public void loadTabletenTor(String idKelas) {
        DefaultTableModel tabelMateri = new DefaultTableModel(new String[]{"Materi ", "ID Materi "}, 0);
        List<Kelas> list = daftarKelasStudent;
        List<Materi> newMateri = db.loadMateriTertentu(idKelas);
        for(int i =0; i<newMateri.size();i++){
            tabelMateri.addRow(new Object[]{newMateri.get(i).getName(),newMateri.get(i).getIdMateri()}); 
        }
        view.setCRUDMateri(tabelMateri);
    }
    
    public void loadTableIDKelas() {
        DefaultTableModel tabelCRUDKelas = new DefaultTableModel(new String[]{"Nama Kelas"}, 0);
        List<Kelas> list = daftarKelasStudent;
        for (int i=0;i<list.size();i++) {
            tabelCRUDKelas.addRow(new Object[]{list.get(i).getName()});
        }
        view.setTableIDKelas(tabelCRUDKelas);
    }

}
