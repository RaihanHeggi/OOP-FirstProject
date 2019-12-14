/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

/**
 *
 * @author user
 */
public class mataPelajaran {
    private String name;
    private String idMapel;

    //constructor
    public mataPelajaran(String idMapel, String name) {
        setName(name);
        setIdMapel(idMapel);
    }
   
    
    //setter
    public void setName(String name) {
        if(!" ".equals(name)){
            this.name = name;
        }
    }

    public void setIdMapel(String idMapel) {
        this.idMapel = idMapel;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getIdMapel() {
        return idMapel;
    }
    
    public String viewMapel(){
        String s = "Nama : "+getName()+"\n"
                + "idMapel :"+getIdMapel();
        return s;
    }
    
}
