/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

import java.util.ArrayList;
import java.util.List;
import Database.Database;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class Application {
    Scanner scanner = new Scanner(System.in);
    private List<Student> daftarStudent; 
    private List<Tentor> daftarDosen; 
    private List<mataPelajaran> daftarMataPelajaran; 
    private List<Kelas> daftarKelasApp;
    private List<Kelas> daftarKelasStudent;
    Database db;
    
    
    public Application(){
        daftarStudent = new ArrayList();
        daftarDosen = new ArrayList();
        daftarMataPelajaran = new ArrayList();
        daftarKelasApp = new ArrayList();
        daftarKelasStudent = new ArrayList();
        db = new Database();
        db.connect();
    }
    //input
    public void inputTentor(String name,String idTentor,int age,String username, String passTentor){
        Tentor dosen = new Tentor(name,idTentor,age,username,passTentor);
        db.insertTentor(dosen);
    }
    public void inputStudent(String name,int umur, String idSiswa, String username, String passStudent){
        Student mahaSiswa = new Student(name,umur,idSiswa,username,passStudent);
        db.insertStudent(mahaSiswa);
    }
    public void inputMapel(String name, String idMapel){
        mataPelajaran mapel = new mataPelajaran(name,idMapel);
        db.insertMapel(mapel);
    }
    public void inputKelas(String idKelas, String nama){
        Kelas kelas = new Kelas(idKelas,nama);
        db.insertKelas(kelas);
    }
    
    
    //load Array
    public void loadStudentArray(){
        daftarStudent = db.getAllStudent();
    }
    public void loadTentorArray(){
        daftarDosen = db.getAllTentor();
    }
    public void loadMapelArray(){
        daftarMataPelajaran = db.getAllMapel();
    }
    public void loadKelasArray(){
        daftarKelasApp = db.getAllKelas();
    }
    
    //get ArrayList
    public List<Student> getListStudent(){
        return daftarStudent;
    }
    public List<Tentor> getListTentor(){
        return daftarDosen;
    }
    public List<mataPelajaran> getListMapel(){
        return daftarMataPelajaran;
    }
    public List<Kelas> getListKelas(){
        return daftarKelasApp;
    }
    
    public List<Kelas> getListKelasStudent(String idSiswa){
        daftarKelasStudent = db.getAllKelasStudent(idSiswa);
        return daftarKelasStudent;
    }
    
    public List<Kelas> getListKelasTertentu(String username){
        List<Kelas> listKelasStudent = new ArrayList<>(); 
        for(int i =0 ;i<daftarKelasApp.size();i++){
            if(daftarKelasApp.get(i).getListStudent(i).getUsernameSiswa().equals(username)){
                listKelasStudent.add(daftarKelasApp.get(i));
            }                      
        }
        return listKelasStudent;
    } 
    
    public boolean checkID(String idKelas) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM KELASTABLE WHERE ID_KELAS LIKE '"+idKelas+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if(!db.getResultSet().getString("ID_KELAS").equals(idKelas)){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
    public boolean checkTentor(String idTentor, String nama) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM TENTORTABLE WHERE ID_TENTOR LIKE '"+idTentor+"' AND NAMA ='"+nama+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if((db.getResultSet().getString("NAMA").equals(nama)) && (db.getResultSet().getString("ID_TENTOR").equals(idTentor))){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
    public boolean checkStudent(String idSiswa, String nama) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM STUDENTTABLE WHERE ID_SISWA LIKE '"+idSiswa+"' AND NAMA ='"+nama+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if((db.getResultSet().getString("NAMA").equals(nama)) && (db.getResultSet().getString("ID_SISWA").equals(idSiswa))){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
    public boolean checkKelasAvaible(String idKelas) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM KELASTABLE WHERE ID_KELAS LIKE '"+idKelas+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if(db.getResultSet().getString("ID_MAPEL").equals("")){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
    public boolean checkKelasTentor(Kelas k , String namaTentor) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM KELASTABLE WHERE ID_KELAS LIKE '"+k.getIdKelas()+"' AND NAMA_TENTOR = '"+namaTentor+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if(db.getResultSet().getString("NAMA_TENTOR").equals(namaTentor)){
                    valid = true;
                }else{
                    System.out.println("BUKAN KELAS TENTOR");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
    public boolean checkTentorAvaible(String idTentor) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM TENTORTABLE WHERE NAMA_TENTOR LIKE '"+idTentor+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if(db.getResultSet().getString("NAMA_TENTOR").equals("")){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
     
    public boolean checkTentorKelas(String idTentor) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM KELASTABLE WHERE NAMA_TENTOR LIKE '"+idTentor+"'";
        db.setResultSet(query);
            while(db.getResultSet().next()){
                if(db.getResultSet().getString("NAMA_TENTOR").equals(idTentor)){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        db.Disconnect();
        return valid;
    }
    
    public Kelas findKelasrData(String namaKelas){
        List<Kelas> masterKelas = db.getAllKelas();
        Kelas s = null;
        for(int i=0;i<masterKelas.size();i++){
            if(masterKelas.get(i).getName().equals(namaKelas)){
                s = new Kelas(masterKelas.get(i).getIdKelas(),masterKelas.get(i).getName());
                break;
            }
        }
        return s;
    }
    
    
}
