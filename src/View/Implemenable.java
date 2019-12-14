/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author user
 */
public interface Implemenable {
    public void Listener(ActionListener e);
    public void Adapter(MouseAdapter e);
    public void ResetView();
}
