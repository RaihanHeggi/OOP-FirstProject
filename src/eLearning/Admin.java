/*
 * T?o change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Admin{
    private String usernameAdmin = "admin"; 
    private String passAdmin = "123456";
    private List<Tentor> Dosen = new ArrayList();
    int idx;
    Scanner input = new Scanner(System.in);
   
    public void adminLogin(){
        while((!usernameAdmin.equals("admin")) || (!passAdmin.equals("12345"))){
            System.out.print("Username : ");
            usernameAdmin = input.nextLine();
            System.out.print("Password : ");
            passAdmin = input.nextLine();
        }
    }
    
    public String getAdminUsername() {
        return usernameAdmin;
    }

    public String getAdminPass() {
        return passAdmin;
    }
    
    public void tambahTentor(String name,String idTentor,int age,String username, String passTentor)
    {
        Dosen.add(new Tentor(name,idTentor,age,username,passTentor));
        
    }
    
    public void hapusTentor(int idx) {
        Dosen.remove(idx);
    }
    
    public void TampilStudent(){
        int idx = 0;
        for(Tentor showSiswa : Dosen){    
            String s = "Nama : "+showSiswa.getListKelas(idx).getListStudent(idx).getName()+"\n"
                 +"NIM : "+showSiswa.getListKelas(idx).getListStudent(idx).getIdSiswa()+"\n"
                 +"Kelas : "+showSiswa.getListKelas(idx).getName()+"\n"
                 +"Username : "+showSiswa.getListKelas(idx).getListStudent(idx).getUsernameSiswa()+"\n"
                 +"Password : "+showSiswa.getListKelas(idx).getListStudent(idx).getPassSiswa()+"\n";
             System.out.println(s);
             idx++;
        }
    }
    
        
    public void TampilKelas(int idx){
        System.out.println("Nama Kelas: "+Dosen.get(idx).getListKelas(idx).getName()+"\n");
        System.out.println("Tentor : "+Dosen.get(idx).getName()+"\n");     
        System.out.println("Data Siswa"); 
        System.out.println();
        for(int i=0;i<Dosen.size();i++){    
            String s = "Nama : "+Dosen.get(i).getListKelas(i).getListStudent(i).getName()+"\n"
                +"NIM : "+Dosen.get(i).getListKelas(i).getListStudent(i).getIdSiswa()+"\n";
            System.out.println(s);
        }       
    }
    
    public void tampilMateri(String Materi){
        int idx = 0;
        while((idx < Dosen.size())&&(Dosen.get(idx).getListKelas(idx).getListMateri(idx).getName() != Materi)){
            idx++;
        }
        if(idx == Dosen.size()){
            System.out.println("Data Tidak Ada");
        }else {
            System.out.println("Nama Kelas :"+Dosen.get(idx).getListKelas(idx).getName());
            System.out.println("List Materi ");
            for(int i=0;i<Dosen.size();i++){
                System.out.println(i+1);
                System.out.println(Dosen.get(idx).getListKelas(i).getListMateri(i).getName());
            }
        }
    }    
}

