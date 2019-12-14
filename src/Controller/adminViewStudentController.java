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
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class adminViewStudentController extends MouseAdapter implements ActionListener{
    private View.Admin_viewStudent view = new Admin_viewStudent();
    private eLearning.Application model = new eLearning.Application();
    private List<Student> student = new ArrayList();
    private Database db;

    public adminViewStudentController() {
        view.listenerAdminViewStudent(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        db = new Database();
        loadStudent();
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
    }
    
    public void loadStudent() {
        DefaultTableModel tabelStudent= new DefaultTableModel(new String[]{"Nama ","Id ","Umur "}, 0);
        List<Student> list = db.getAllStudent();
        for (int i=0;i<list.size();i++) {
            tabelStudent.addRow(new Object[]{list.get(i).getName(),list.get(i).getIdSiswa(),list.get(i).getUmur()});
        }
        view.settabelStudent(tabelStudent);
    }
}
