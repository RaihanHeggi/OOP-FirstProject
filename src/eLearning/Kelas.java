/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;
import Database.Database;
import java.util.*;

/**
 *
 * @author user
 */
public class Kelas {
    private ArrayList<Student> listStudent = new ArrayList<>();
    private ArrayList<Materi> listMateri = new ArrayList<>();
    private mataPelajaran mapel;
    private int hitungMateri;
    private int hitungSiswa;
    private String namaKelas;
    private String idKelas;
    private static int id = 1;
    Database db = new Database();
    
    //constructor
    public Kelas(String namaKelas,String idKelas){
        setNamaKelas(namaKelas);
        setIdKelas(idKelas);
       
    }
    
    //setter
    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
    public void setIdKelas(String IdKelas){
        this.idKelas = IdKelas;
    }      
    public void addStudent(Student S){
        listStudent.add(S);
        hitungSiswa++;
    }
    public void addMapel(mataPelajaran mapel) {
        this.mapel = mapel;
    }
    
    //getter
    public String getIdKelas(){
        return idKelas;
    }
    public String getName(){
        return namaKelas;
    }
    public Student getListStudent(int idx) {
        Student S = listStudent.get(idx); 
        return S;
    }
    public Materi getListMateri(int idx) {
        Materi M = listMateri.get(idx);
        return M;
    }
    public mataPelajaran getMapel() {
        return mapel;
    }
   
    
    
    //Composition relationship
    public void createMateri(String idMateri,String name){
        Materi m = new Materi(name,idMateri);
        addMateri(m);
    }
    
    public void addMateri(Materi m){
        listMateri.add(m);
        hitungMateri++;
    }
    
    public String getNamaMateri(){
        String s = "DAFTAR MATERI DI KELAS "+getName()+"\n";
               s += ""+"\n";
        for(int i=1;i<listMateri.size();i++){
                s +=(i)+" "+listMateri.get(i).getName()+"\n";
        }
        return s;
    }
    
    public void removeMateri(Materi m){
        int i = 0;
        while ((i < listMateri.size()) && (m.getIdMateri().equals(listMateri.get(i).getIdMateri()))){
            i++;
        }
        listMateri.remove(listMateri.get(i));
    }
    
    public void removeStudent(Student s){
        int i = 0;
        while ((i < listStudent.size() && (s.getName().equals(listStudent.get(i).getName())))){
            i++;
        }
        listStudent.remove(listStudent.get(i));
    }
  
     public String tampilKelas()
    {
        String s = "Nama : "+namaKelas+"\n"
                + "ID Kelas : "+idKelas+"\n"
                + "Mata Pelajaran : "+mapel.getName()+"\n";
        return s;
    }

   
    
}
