/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

import java.sql.SQLException;
import Database.Database;

/**
 *
 * @author user
 */
public class Materi {
    private String name;
    private String idMateri;
    private Database db  = new Database();

    //constructor
    public Materi(String idMateri,String name) {
        setName(name);
        setIdMateri(idMateri);
    }
    
    //setter
    public void setName(String name) {
       if(!" ".equals(name)){
            this.name = name;
       }
    }
    public void setIdMateri(String idMateri) {
        this.idMateri = idMateri;
    }

    //getter
    public String getName() {
        return name;
    }
    public String getIdMateri() {
        return idMateri;
    }    
    public String viewMateri(){
        String s = "Nama :"+getName()+"\n"
                + "ID :"+getIdMateri();
        return s;
    }
    
    public boolean checkKelas() throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM KELASTABLE WHERE ID_MATERI LIKE '"+" "+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if(!db.getResultSet().getString("ID_MATERI").equals(" ")){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
    public boolean checkIDMateri(String idMateri) throws SQLException{
        boolean valid = false;
        db.connect();
        String query = "SELECT * FROM MATERITABLE WHERE ID_MATERI LIKE '"+idMateri+"'";
        db.setResultSet(query);
        if (db.isResultSetEmpty(db.getResultSet())) {
            valid = true;
        }else {
            while(db.getResultSet().next()){
                if(!db.getResultSet().getString("ID_MATERI").equals(idMateri)){
                    valid = true;
                }else{
                    System.out.println("ID SUDAH ADA");
                }
            }
        }
        db.Disconnect();
        return valid;
    }
    
}
