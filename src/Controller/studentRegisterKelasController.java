/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Database.Database;
import View.*;
import eLearning.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class studentRegisterKelasController extends MouseAdapter implements ActionListener{
    private Student_registerKelas view = new Student_registerKelas();
    private List<Kelas> kelas= new ArrayList();
    private Database db = new Database();
    private int selectedIdx ;
    private String username;

    public studentRegisterKelasController(String uname) {
        view.listenerStudentRegisterKelas(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTableKelas();
        LoadTableTentorKelas();
        username = uname;
        view.setTf_studentRegisKelasName(username);
        view.resetView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src.equals(view.getbuttInsert()))
        {
            String nama = view.gettf_studentRegisKelasName();
            String namaKelas = view.gettf_studentRegisKelas();
            String Tentor = view.gettf_studentRegisKelasTentor();
            Student p = new Student(nama,0);
            Kelas k = findKelasData(namaKelas);
            System.out.println(k.getName());
            db.insertKelasStudent(k, p, Tentor);
            view.resetView();
           
        }
        else if(src.equals(view.getbuttDelete()))
        {
            String kelas = view.gettf_studentRegisKelas();
            String nama = view.gettf_studentRegisKelasName();
            String Tentor = view.gettf_studentRegisKelasTentor();
            Student s = new Student(nama,0);
            db.deleteListStudent(s,kelas);
        }
        else 
        {
           new studentMenuController(username);
           view.dispose();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getTabelKelas())) 
        {
            selectedIdx = view.getSelectedKelas();
            System.out.println(selectedIdx);
        }
    }
    
    public void loadTableKelas() {
        DefaultTableModel tblKelas = new DefaultTableModel(new String[]{"Nama Kelas", "Tentor "}, 0);
        ArrayList<Tentor> list = db.getAllTentor();
        List<Kelas> newKelas = new ArrayList();
        for (Tentor p : list) {
            newKelas = db.loadKelasTertentu(p.getName());
            for(int i=0;i<newKelas.size();i++){
                tblKelas.addRow(new Object[]{newKelas.get(i).getName(), p.getName()});            
            }            
        } 
        view.setKelas(tblKelas);
    }
    
    public void LoadTableTentorKelas(){
        ArrayList<Tentor> list = db.getAllTentor();
        List<Kelas> newKelas = new ArrayList();
        for (Tentor p : list) {
            newKelas = db.loadKelasTertentu(p.getName());
            for(int i=0;i<newKelas.size();i++){
                kelas.add(newKelas.get(i));
            }            
        } 
    }
    
    public Kelas findKelasData(String namaKelas){
        Kelas s = null;
        for(int i = 0; i<kelas.size();i++){
            if (kelas.get(i).getName().equals(namaKelas)){
                s = kelas.get(i);
                break;
            }
        }
        return s;
    }
        
        
}
    
 
