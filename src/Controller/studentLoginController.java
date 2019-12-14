package Controller;

import Controller.HomeGUIController;
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
public class studentLoginController  extends MouseAdapter implements ActionListener{
    View.Student_Login view = new View.Student_Login();;
    eLearning.Student model = new eLearning.Student("",0);

    public studentLoginController() {
        view.listenerStudentLogin(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.getbuttStudentLogin()))
        {
            String user = view.gettf_studentLogin1();
            String pass = view.gettf_studentLogin2();
            try {
                if (model.checkUser(user, pass))
                {
                    String username = user;
                    new studentMenuController(username);
                    view.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Username / Password");
                }
            } catch (SQLException ex) {
                Logger.getLogger(studentLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(src.equals(view.getbuttstudentLoginToAdmin())){
            new adminLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbuttstudentLogintoTentor()))
        {
            new tentorLoginController();
            view.dispose();
        }
        else if (src.equals(view.getbuttSignStudent()))
        {
            new studentRegisterController();
            view.dispose();
        }
        else
        {
            view.dispose();
            new HomeGUIController();      
        }
    }  
}
