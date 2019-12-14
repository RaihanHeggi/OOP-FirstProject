/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import eLearning.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class adminLoginController  extends MouseAdapter implements ActionListener{
    View.Admin_Login view = new View.Admin_Login();;
    eLearning.Admin model = new eLearning.Admin();

    public adminLoginController() {
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.getbuttHomeAdmin()))
        {
            String user = view.gettf_adminLogin1();
            String pass = view.gettf_adminLogin2();
            if (user.equals(model.getAdminUsername()) && pass.equals(model.getAdminPass()))
            {
                new adminMenuController();
                view.dispose();
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Wrong Username / Password");
            }
        }
        else if(src.equals(view.getbuttadminLogintoStudent())){
            new studentLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbuttadminLogintoTentor()))
        {
            new tentorLoginController();
            view.dispose();
        }
        else
        {
            view.dispose();
            new HomeGUIController();
        }
    }  
}
