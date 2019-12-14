/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Tentor extends Person{
    private String name;
    private String idTentor;
    private int age;
    private String usernameTentor,passTentor;
    private List<Kelas> listKelas = new ArrayList<>();
    private int hitungKelas;
    Database db = new Database();
    
    //constructor
    public Tentor(String name,String idTentor,int age,String username, String passTentor){
        super(name,age);
        setIdTentor(idTentor);
        setUsernameTentor(username);
        setPassTentor(passTentor);
    }       
    public Tentor(String name ,int age){
        super(name,age);
    }
    
    //setter
    public void setUsernameTentor(String usernameTentor) {
        this.usernameTentor = usernameTentor;
    }
    @Override
    public void setName(String name) {
        if(!" ".equals(name)){
            this.name = name;
        }        
    }

    @Override
    public void setAge(int age) {
        if(age >= 0){
            this.age = age;
        }
    }
    
    public void setIdTentor(String idTentor){
        this.idTentor = idTentor;
    }
        
    public void setPassTentor(String passTentor) {
        this.passTentor = passTentor;
    }
    
    //getter 
     public String getName() {
        return name;
    }

    public String getIdTentor() {
        return idTentor;
    }

    public int getAge() {
        return age;
    }

    public String getUsernameTentor() {
        return usernameTentor;
    }

    public String getPassTentor() {
        return passTentor;
    }
    
    //agregation relationship with Kelas class
    public void createKelas(String nama, String idKelas){
        Kelas kelas = new Kelas(nama,idKelas);
        addKelas(kelas);
    }
    
    public void addKelas(Kelas k){
        listKelas.add(k);
        hitungKelas++;
    }
    
    public void removeClass(Kelas k){
        int i = 0;
        while((i<listKelas.size()) && (k.getName() != listKelas.get(i).getName())){
            i++;
        }
        listKelas.remove(listKelas.get(i));
    } 
    
    //Get Kelas From ListKelas
    public Kelas getListKelas(int idx) {
        Kelas k = listKelas.get(idx);
        return k;
    }
    
    public boolean checkUser(String Username, String Pass) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM `TENTORTABLE` WHERE `USERNAME` LIKE '"+Username+"'";
        System.out.println(query);
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            System.out.println("USERNAME TIDAK ADA");
        }else {
            while(db.getResultSet().next()){
                if(db.getResultSet().getString("PASSWORD").equals(Pass)){
                    valid = true;
                }else{
                    System.out.println("PASSWORD SALAH");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
}
