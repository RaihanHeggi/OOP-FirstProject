/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.*;
import eLearning.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class adminViewKelasStudentTentorController extends MouseAdapter implements ActionListener{
    View.Admin_viewKelasStudentTentor view = new Admin_viewKelasStudentTentor();;
    eLearning.Application model = new eLearning.Application();
    private List<Student> mahaSiswa = new ArrayList();
    private List<Tentor> Tentor = new ArrayList();
    private List<Kelas> kelasTentor = new ArrayList();
    private Database db;
    private String selectedIndex,selectedIdx;
    private Tentor t;

    public adminViewKelasStudentTentorController() {
        view = new Admin_viewKelasStudentTentor();
        model = new Application();
        db = new Database();
        view.listenerTentorViewKelasStudent(this);
        view.mouseAdapter(this);
        view.setVisible(true);
        Tentor = db.getAllTentor();
        mahaSiswa = db.getAllStudent();
        view.setListTentor(getTentorNama());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
        if (src.equals(view.getbuttbacktoAdminMenu()))
        {
            new adminMenuController();
            view.dispose();
        }else if(src.equals(view.getButtTampilKelas())){
            kelasTentor = db.loadKelasTertentu(selectedIdx);
            if(kelasTentor != null){
                view.setListKelas(getKelasNama(kelasTentor));
            }else {
                view.setListStudent(getStudentError());
            }        
            
        }else if(src.equals(view.getButtTampilStudent())){
            Kelas k = model.findKelasrData(selectedIndex);
        try {
            if(k != null && (model.checkKelasTentor(k, selectedIdx))){
                view.setListStudent(getTentorKelasNama(k.getName(),selectedIdx));
            }else {
                view.setListStudent(getStudentError());
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminViewKelasStudentTentorController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }    
    }
    
      @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getJlist_Kelas())) 
        {
            selectedIndex = view.getSelectedKelas();
            System.out.println(selectedIndex);
        }else if(source.equals(view.getJlist_Tentor())){
            selectedIdx = view.getSelectedTentor();
            System.out.println(selectedIdx);
        }       
    }
    
    public String [] getTentorKelasNama(String idKelas,String namaTentor){
        List<Student> kelasSpesifik = db.loadStudentTentorTertentu(idKelas, namaTentor);
        List<Student> kelasBaru = mahaSiswa;
        List<Student> finalList = new ArrayList();
        if(kelasSpesifik.size() == 1){
           Student s = findStudentData(kelasSpesifik.get(0).getName());
           finalList.add(s);
        }else if (kelasSpesifik.size() <= kelasBaru.size()){
            for(int z = 0 ;z<kelasSpesifik.size();z++){
                Student s = findStudentData(kelasSpesifik.get(z).getName());
                finalList.add(s);
            }
        }else{
            for(int i = 0;i<kelasBaru.size();i++){
                for(int j=0; j<kelasSpesifik.size();j++){
                    if(kelasBaru.get(i).getIdSiswa().equals(kelasSpesifik.get(j).getName())){
                        finalList.add(new Student(kelasBaru.get(j).getName(),kelasBaru.get(j).getUmur(),kelasBaru.get(j).getIdSiswa(),kelasBaru.get(j).getUsernameSiswa(),kelasBaru.get(j).getPassSiswa()));
                    }
                }    
            }    
        }
        String [] listId = new String [finalList.size()];
        for (int i = 0; i < finalList.size();i++){
            listId[i] = finalList.get(i).getName();
        }
        return listId;
    }
    
    public String [] getKelasNama(List<Kelas> kelas){
        List<Kelas> kelasSpesifik = kelas;
        String [] listId = new String [kelasSpesifik.size()];
        for (int i = 0; i < kelasSpesifik.size();i++){
            listId[i] = kelasSpesifik.get(i).getName();
        }
        return listId;
    }
    
    public String [] getTentorNama(){
        List<Tentor> kelasSpesifik = Tentor;
        String [] listId = new String [kelasSpesifik.size()];
        for (int i = 0; i < kelasSpesifik.size();i++){
            listId[i] = kelasSpesifik.get(i).getName();
        }
        return listId;
    }
    
    public String [] getStudentError(){
        String [] listId = new String [1];
        listId [0] = "Tidak Ada Kelas/Siswa";
        return listId;
    }
    
     
    public Tentor findTentorData(String nama){
        List<Tentor> findTentor = db.getAllTentor();
        Tentor s = null;
        for(Tentor p : findTentor){
            if(p.getName().equals(nama)){
                s = new Tentor(p.getName(),p.getIdTentor(),p.getAge(),p.getUsernameTentor(),p.getPassTentor());
                break;
            }
        }
        return s;
    }
     
    public Student findStudentData(String nama){
        List<Student> findTentor = db.getAllStudent();
        Student s = null;
        for(Student p : findTentor){
            if(p.getIdSiswa().equals(nama)){
                s = new Student(p.getName(),p.getUmur(),p.getIdSiswa(),p.getUsernameSiswa(),p.getPassSiswa());
                break;
            }
        }
        return s;
    }
}
