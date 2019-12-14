 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

import Database.Database;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Student extends Person{
    private String name;
    private int umur;
    private String idSiswa;
    private String usernameSiswa = "PelajarSehat" ,passSiswa = "123456";
    Database db = new Database();
    
    //constructor
    public Student(String name,int umur, String idSiswa, String username , String passStudent){
        super(name,umur);
        setIdSiswa(idSiswa);
        setUsernameSiswa(username);
        setPassSiswa(passStudent);
        
    }
    public Student(String name, int umur){
        super(name,umur);
    }
    
    //setter
    @Override
    public void setName(String name) {
        if(!" ".equals(name)){
             this.name = name;
        }  
    }
    @Override
    public void setAge(int umur) {
        if(umur >= 0 ){
          this.umur = umur;  
        }        
    }    
    public void setIdSiswa(String idSiswa){
        this.idSiswa = idSiswa;
        
    }    
    public void setUsernameSiswa(String usernameSiswa){
        this.usernameSiswa = usernameSiswa;
    }    
    public void setPassSiswa(String passSiswa){
        this.passSiswa = passSiswa;
    }

    //getter
    public String getUsernameSiswa() {
        return usernameSiswa;
    }
    public String getPassSiswa() {
        return passSiswa;
    }       
    public String getName() {
        return name;
    }
    public int getUmur() {
        return umur;
    }
    public String getIdSiswa() {
        return idSiswa;
    }
    
    //check user
     public boolean checkUser(String Username, String Pass) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM `STUDENTTABLE` WHERE `USERNAME` LIKE '"+Username+"'";
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
    
     public boolean checkIDSiswa(String IDinput, String IDupdate) throws SQLException{
        boolean valid = true;
        db.connect();
        String query = "SELECT * FROM `STUDENTTABLE` WHERE `ID_SISWA` LIKE '"+IDinput+"'";
        System.out.println(query);
        db.setResultSet(query);
       while(db.getResultSet().next()){
            if(db.getResultSet().getString("ID_SISWA").equals(IDupdate)){
                valid = false;
            }else{
                System.out.println("ID ADA");
            }
        }    
        db.Disconnect();
        return valid;
    }
    
}
