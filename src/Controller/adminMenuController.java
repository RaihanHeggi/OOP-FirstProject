/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class adminMenuController extends MouseAdapter implements ActionListener{
    View.Admin_Menu view = new View.Admin_Menu();;
    eLearning.Application model = new eLearning.Application();

    public adminMenuController() {
        view.addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.getbuttTentorCR()))
        {
            new adminCRtentorController();
            view.dispose();
        }
        else if(src.equals(view.getbuttViewStudent())){
            new adminViewStudentController();
        }
        else if (src.equals(view.getbuttCRUDmatapelajaran()))
        {
            new adminCRUDmatapelajaranController();
            view.dispose();
        }
        else if (src.equals(view.getbuttCRUDkelas()))
        {
            new adminCRUDkelasController();
            view.dispose();
        }
        else if (src.equals(view.getbuttViewKelasStudentTentor())){
            new adminViewKelasStudentTentorController();
            view.dispose();
        }
        else if(src.equals(view.getbuttMateriKelas())){
            new adminViewMateriController();
        }
        else {
           new adminLoginController();
           view.dispose();
        }
    }  
}
