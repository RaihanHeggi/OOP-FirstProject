package Controller;

import Controller.HomeGUIController;
import Controller.HomeGUIController;
import Controller.adminLoginController;
import Controller.studentLoginController;
import View.*;
import eLearning.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author user
 */
public class tentorLoginController  extends MouseAdapter implements ActionListener{
    View.Tentor_Login view = new View.Tentor_Login();;
    eLearning.Tentor model = new eLearning.Tentor("",0);

    public tentorLoginController() {
        view.listenerTentorLogin(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.getbuttLoginTentor()))
        {
            String user = view.gettf_tentorLogin1();
            String pass = view.gettf_tentorLogin2();
            try {
                if (model.checkUser(user, pass))
                {
                    new tentorMenuController(user);
                    view.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Username / Password");
                }
            } catch (SQLException ex) {
                Logger.getLogger(tentorLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(src.equals(view.getbutttentorLogintoAdmin())){
            new adminLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbutttentorLogintoStudent()))
        {
            new studentLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbuttSignupTentor()))
        {
            new tentorRegisterController();
            view.dispose();
        }
        else
        {
            view.dispose();
            new HomeGUIController();
        }
    }  
}
