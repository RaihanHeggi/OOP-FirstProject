/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.HomeGUIController;
import Controller.HomeGUIController;
import Controller.adminLoginController;
import Controller.adminLoginController;
import Controller.studentLoginController;
import Controller.studentMenuController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


/**
 *
 * @author ACER
 */
public class tentorRegisterController extends MouseAdapter implements ActionListener{

    View.Tentor_register view = new View.Tentor_register();;
    eLearning.Tentor model = new eLearning.Tentor("",0);

    public tentorRegisterController() {
        view.listenerTentorRegister(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
        if (src.equals(view.getbuttTentorSignUp()))
        {
            view.daftarTentor();
            view.dispose();
        }
        else if(src.equals(view.getbutttentorLoginBackAdmin())){
            new adminLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbuttTentorLoginToMahasiswa()))
        {
            new studentLoginController();
            view.dispose();
        }
        else
        {
            new HomeGUIController();
            view.dispose();
        }
    }
    
}
