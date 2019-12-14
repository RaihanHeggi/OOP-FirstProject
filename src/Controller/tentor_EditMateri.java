/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.*;
import eLearning.Materi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author user
 */
public class tentor_EditMateri extends MouseAdapter implements ActionListener {
    private View.Tentor_EditMateri view;
    private Database db = new Database();
    private String username;

    public tentor_EditMateri(String uname){
        view = new Tentor_EditMateri();
        view.addActionListener(this);
        view.setVisible(true);
        username = uname;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src.equals(view.getButtonEdit()))
        {
            String idKelas = view.getTf_tentorKelas();
            String namaMateri = view.getTf_tentorMateri();
            String namaBaru = view.getTf_tentorMateriBaru();
            String idMateri = view.getTf_tentorIDMateri();
            Materi lama = new Materi(idMateri,namaMateri);
            Materi baru = new Materi(idMateri,namaBaru);
            db.updateDataMateri(lama,baru,idKelas);
        }
        else
        {
            new tentorCRUDMateriController(username);
            view.dispose();
        }
    }
}
