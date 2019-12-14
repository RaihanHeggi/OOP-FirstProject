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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class studentDataDiriController extends MouseAdapter implements ActionListener {
    private Student_DataDiri view;
    private Student model;
    private Database db;
    private ArrayList<Student> mahaSiswa= new ArrayList();
    private int selectedIdx;
    private String username;
    
    public studentDataDiriController(String uname){
        view = new Student_DataDiri();
        model = new Student("",0);
        db = new Database();
        view.listenerStudentLogin(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        mahaSiswa = db.getAllStudent();
        username = uname;
        loadTableMahaSiswa();
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object src = ae.getSource();
        if(src.equals(view.getbuttedit())){
            String name = view.gettf_studenteditName();
            String id = view.gettf_studenteditID();
            String uname = view.gettf_studenteditUsername();
            String pass = view.gettf_studenteditPass();
            int umur = view.getCb_studenteditUmur()+15;
            Student s = new Student(name, umur, id, uname, pass);
            Student p = findStudentData(username);
           try {
               if(!model.checkIDSiswa(p.getIdSiswa(), id)){
                   db.updateStudent(s, p.getIdSiswa());
                   loadTableMahaSiswa();
                   view.resetView();
               }else {
                   JOptionPane.showMessageDialog(null, "ID INPUT ANDA MILIK ORANG LAIN");
                   view.resetView();            
               }
           } catch (SQLException ex) {
               Logger.getLogger(studentDataDiriController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            new studentMenuController(username);
            view.dispose();
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
    
    public void loadTableMahaSiswa() {
        DefaultTableModel tblSiswa = new DefaultTableModel(new String[]{"Nama "," ID", "Umur ", "Username ","Password"}, 0);
        ArrayList<Student> list = mahaSiswa;
        for (int i=0;i<list.size();i++) {
            if(list.get(i).getUsernameSiswa().equals(username)){
                tblSiswa.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdSiswa(),list.get(i).getUmur(),list.get(i).getUsernameSiswa(),list.get(i).getPassSiswa()});
            } 
        }
        view.setDataDiri(tblSiswa);
    }
    
    public Student findStudentData(String uname){
        Student s = null;
        for(int i = 0; i<mahaSiswa.size();i++){
            if (mahaSiswa.get(i).getUsernameSiswa().equals(uname)){
                s = mahaSiswa.get(i);
                break;
            }
        }
        return s;
    }
    
    
}
