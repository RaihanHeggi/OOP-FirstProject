/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Tentor_ViewStudentKelas;
import Database.Database;
import View.*;
import eLearning.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class tentorViewKelasStudentController extends MouseAdapter implements ActionListener{

    private Tentor_ViewStudentKelas view;
    private Application model;
    private Database db;
    private ArrayList<Student> mahaSiswa = new ArrayList();
    private ArrayList<Kelas> kelasTentor = new ArrayList();
    private Tentor t;
    private String selectedIdx;
    private String username;
    
    public tentorViewKelasStudentController(String uname) {
        view = new Tentor_ViewStudentKelas();
        model = new Application();
        db = new Database();
        view.listenerTentorViewKelasStudent(this);
        view.mouseAdapter(this);
        view.setVisible(true);
        username = uname;
        t = findTentorData(username);
        kelasTentor = db.getAllKelasTentor(t.getName());
        view.setListKelas(getKelasNama(kelasTentor));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
        
        if(src.equals(view.getbuttTampil()))
        {
            Kelas k = model.findKelasrData(selectedIdx);
            view.setListStudent(getTentorKelasNama(k.getName()));
        }
        else 
        {
            view.dispose();
            new tentorMenuController(username);
        }
    
    }
    
     @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getJlist_Kelas())) 
        {
            selectedIdx = view.getSelectedKelas();
            System.out.println(selectedIdx);
        }       
    }
    
    public String [] getTentorKelasNama(String idKelas){
        List<Student> kelasSpesifik = db.loadStudentKelasTertentu(idKelas);
        List<Student> kelasBaru = db.getAllStudent();
        List<Student> finalList = new ArrayList();
        for(int i = 0;i<kelasBaru.size();i++){
            for(int j=0; j<kelasSpesifik.size();j++){
                if(kelasBaru.get(i).getIdSiswa().equals(kelasSpesifik.get(j).getName())){
                    finalList.add(new Student(kelasBaru.get(j).getName(),kelasBaru.get(j).getUmur(),kelasBaru.get(j).getIdSiswa(),kelasBaru.get(j).getUsernameSiswa(),kelasBaru.get(j).getPassSiswa()));
                }
            }
                
        }
        String [] listId = new String [finalList.size()];
        for (int i = 0; i < finalList.size();i++){
            listId[i] = finalList.get(i).getName();
        }
        return listId;
    }
    
    public String [] getKelasNama(ArrayList<Kelas> kelas){
        ArrayList<Kelas> kelasSpesifik = kelas;
        String [] listId = new String [kelasSpesifik.size()];
        for (int i = 0; i < kelasSpesifik.size();i++){
            listId[i] = kelasSpesifik.get(i).getName();
        }
        return listId;
    }
     
     public Tentor findTentorData(String username){
        List<Tentor> findTentor = db.getAllTentor();
        Tentor s = null;
        for(Tentor p : findTentor){
            if(p.getUsernameTentor().equals(username)){
                s = new Tentor(p.getName(),p.getIdTentor(),p.getAge(),p.getUsernameTentor(),p.getPassTentor());
                break;
            }
        }
        return s;
    }
}
