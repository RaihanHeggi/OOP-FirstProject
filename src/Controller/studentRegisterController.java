/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.HomeGUIController;
import Controller.adminLoginController;
import Controller.studentMenuController;
import Controller.tentorLoginController;
import Database.Database;
import eLearning.Kelas;
import eLearning.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class studentRegisterController extends MouseAdapter implements ActionListener{
    View.Student_register view = new View.Student_register();;
    eLearning.Student model = new eLearning.Student("",0);
    Database db;

    public studentRegisterController() {
        view.listenerStudentLogin(this);
        view.setVisible(true);
        db = new Database();
        db.connect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(view.getbutttentorLogintoAdmin())){
            new adminLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbuttstudentLogintoStudent()))
        {
            new tentorLoginController();
            view.dispose();
        }
        else if (src.equals(view.getButtSignUp()))
        {
            if (db.cekSiswa(view.gettf_studentRegName()))
            {
                JOptionPane.showMessageDialog(null, "SUDAH ADA");
                view.resetView();
            }
            else
            {
                view.daftarStudent();
                view.dispose();
            }           
        }
        else
        {
            new HomeGUIController();
            view.dispose();
        }
    }
    
    
}
