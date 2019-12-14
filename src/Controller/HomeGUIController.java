/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import eLearning.*;
import java.awt.event.*;

/**
 *
 * @author user
 */
public class HomeGUIController  extends MouseAdapter implements ActionListener{
   private View.Home view = new View.Home();

    public HomeGUIController() {
        view.addListener(this);
        view.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getButtHomeAdmin()))
        {
            view.dispose();
            new adminLoginController();
        }
        else if (src.equals(view.getButtHomeStudent()))
        {
            view.dispose();
            new studentLoginController();
        }
        else if (src.equals(view.getButtHomeTentor()))
        {
            view.dispose();
            new tentorLoginController();
        }
    }
}
