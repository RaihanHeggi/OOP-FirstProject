/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import eLearning.*;
import java.util.*;
/**
 *
 * @author user
 */
public class Database {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<Student> mahaSiswa = new ArrayList();
    private ArrayList<Tentor> dosen = new ArrayList();
    private ArrayList<Kelas>  kelas = new ArrayList();
    private ArrayList<Kelas> kelasTentor = new ArrayList();
    private ArrayList<Kelas> kelasStudent = new ArrayList();
    private ArrayList<mataPelajaran> mapel = new ArrayList();
    private ArrayList<Materi> materi = new  ArrayList();
    private Admin admin;
    
    public Database(){
    }
    
    public void connect(){
        try {
            String url = "jdbc:mysql://localhost/elearning";
            String user = "root";
            String pass = "";
            this.con = DriverManager.getConnection(url, user, pass);
            this.stmt = con.createStatement();
            System.out.println("Connected Success");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failed.");
        }
    }
    
    public void Disconnect(){
        try {
            this.con.close();
            this.stmt.close();
            System.out.println("Disconnected.");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Disconnect failed");
        }
    }
    
    public Connection getConnection(){
        return con;
    } 
    public Statement getStatement(){
        return stmt;
    }
    public ResultSet getResultSet(){
        return rs;
    }
    public void setConnection(Connection con){
        this.con = con;
    }
    public void setStatement(Statement stmt){
        this.stmt = stmt;
    }
    public void setResultSet(String query) {
        try {
            this.rs = this.stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isResultSetEmpty(ResultSet rs) throws SQLException{
        return !rs.isBeforeFirst();
    }
    
    public boolean Manipulate(String query){
        boolean cek = false;
        try {
            int rows = this.stmt.executeUpdate(query);
            if(rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    //load to List
    public void loadStudent(){
        connect();
        try {
            String Query = "SELECT * FROM STUDENTTABLE";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                mahaSiswa.add(new Student(rs.getString("NAMA"),rs.getInt("UMUR"),rs.getString("ID_SISWA"),rs.getString("USERNAME"),rs.getString("PASSWORD")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
    
    public void loadTentor(){
        connect();
        try {
            String Query = "SELECT * FROM TENTORTABLE";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                dosen.add(new Tentor(rs.getString("NAMA"),rs.getString("ID_TENTOR"),rs.getInt("UMUR"),rs.getString("USERNAME"),rs.getString("PASSWORD")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
    
    public void loadKelas(){
        connect();
        try {
            String Query = "SELECT * FROM KELASTABLE";
            List<Materi> newMateri = new ArrayList<>();
            List<mataPelajaran> newMapel = new ArrayList<>();
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                Kelas k = new Kelas(rs.getString("NAMAKELAS"),rs.getString("ID_KELAS"));
                mataPelajaran ma = new mataPelajaran(rs.getString("ID_MAPEL"),"");
                Materi m = new Materi(rs.getString("ID_MATERI"),"");
                k.addMateri(m);
                k.addMapel(ma);
                kelas.add(k);
            }
            for(Kelas p : kelas){
                newMateri = loadMateriTertentu(p.getIdKelas());
                newMapel = loadMapelTertentu(p.getIdKelas());
                for(Materi s : newMateri){
                    p.addMateri(s);
                }
                for(mataPelajaran r : newMapel){
                    p.addMapel(r);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
    
    public void loadKelasStudent(String idSiswa){
        connect();
        try {
            String Query = "SELECT * FROM LISTSTUDENTTABLE WHERE ID_SISWA = '"+idSiswa+"'";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                Kelas k = new Kelas(rs.getString("NAMA_KELASLIST"),rs.getString("ID_KELASLIST"));
                kelasStudent.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
    public void loadKelasTentor(String nama){
       connect();
       try {
            String Query = "SELECT * FROM LISTKELASTENTOR WHERE NAMATENTORLT = '"+nama+"'";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                Kelas k = new Kelas(rs.getString("NAMAKELASLT"),rs.getString("ID_KELASLT"));
                kelasTentor.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect(); 
    }
    
    public void loadMapel(){
       connect();
        try {
            String Query = "SELECT * FROM MATAPELAJARANTABLE";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                mapel.add(new mataPelajaran(rs.getString("ID_MAPEL"),rs.getString("NAMAMAPEL")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect(); 
    }
    
    public void loadMateri(){
        connect();
        try {
            String Query = "SELECT * FROM MATERITABLE";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                materi.add(new Materi(rs.getString("ID_MATERI"),rs.getString("NAMAMATERI")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();  
    }
    
    
    public ArrayList<Kelas> getAllKelas(){
       loadKelas();
       return kelas;
    }
    
    public ArrayList<Kelas> getAllKelasStudent(String idSiswa){
        loadKelasStudent(idSiswa);
        return kelasStudent;
    }
    public ArrayList<Kelas> getAllKelasTentor(String nama){
        loadKelasTentor(nama);
        return kelasTentor;
    }
    public ArrayList<mataPelajaran> getAllMapel(){
        loadMapel();
        return mapel;
    }
    public ArrayList<Student> getAllStudent(){
        loadStudent();
        return mahaSiswa;
    }
    public ArrayList<Tentor> getAllTentor(){
        loadTentor();
        return dosen;
    }
    public ArrayList<Materi> getAllMateri(){
        loadMateri();
        return materi;
    }
    
    //Insert 
    public void insertStudent(Student s)
    {
        connect();
        String query = "INSERT INTO STUDENTTABLE VALUES('";
                        query +=  s.getIdSiswa() +"','";
                        query +=  s.getName() +"','";
                        query +=  s.getUmur() +"','";
                        query +=  s.getUsernameSiswa() +"','";
                        query +=  s.getPassSiswa() +"')";
                        
        
        System.out.println(query);
        if (Manipulate(query))
        {
            mahaSiswa.add(s);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    }
    public void insertTentor(Tentor t){
        connect();
        String query = "INSERT INTO TENTORTABLE VALUES('";
                        query +=  t.getIdTentor()+"','";
                        query +=  t.getName() +"','";
                        query +=  t.getAge() +"','";
                        query +=  t.getUsernameTentor() +"','";
                        query +=  t.getPassTentor()+"')";
        System.out.println(query);
        if (Manipulate(query))
        {
            dosen.add(t);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    }
    public void insertKelas(Kelas k){
        connect();
        String query = "INSERT INTO KELASTABLE VALUES('";
                        query +=  k.getIdKelas() +"','";
                        query +=  k.getName() +"','";
                        query +=  k.getMapel().getIdMapel() +"','";
                        query +=  null +"','";
                        query +=  null+"')";
        System.out.println(query);
        if (Manipulate(query))
        {
            kelas.add(k);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    }
    public void insertKelasStudent(Kelas k,Student s,String namaTentor){
        connect();
        String query = "INSERT INTO LISTSTUDENTTABLE VALUES('";
                        query +=  0 +"','";
                        query +=  k.getIdKelas() +"','";
                        query +=  k.getName() +"','";
                        query +=  s.getName()+"','";
                        query +=  namaTentor+"')";
        System.out.println(query);
        if (Manipulate(query))
        {
            kelasStudent.add(k);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    } 
    public void insertKelasTentor(Kelas k,String namaTentor){
        connect();
        String query = "INSERT INTO LISTKELASTENTOR VALUES('";
                        query +=  0 +"','";
                        query +=  k.getIdKelas() +"','";
                        query +=  k.getName() +"','";
                        query +=  namaTentor +"')";
        System.out.println(query);
        if (Manipulate(query))
        {
            kelasTentor.add(k);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    } 
    public void insertMateri(Materi m){
        connect();
        String query = "INSERT INTO MATERITABLE VALUES('";
                        query +=  0 +"','";
                        query +=  m.getIdMateri()+ "','";
                        query +=  m.getName() +"','";
                        query +=  "" +"')";
        System.out.println(query);
        if (Manipulate(query))
        {
            materi.add(m);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    }
    public void insertMapel(mataPelajaran mapelInsert){
        connect();
        String query = "INSERT INTO MATAPELAJARANTABLE VALUES('";
                        query +=  mapelInsert.getIdMapel()+"','";
                        query +=  mapelInsert.getName()+ "','";
                        query +=  ""+"')";
        System.out.println(query);
        if (Manipulate(query))
        {
            mapel.add(mapelInsert);
        }
        else
        {
            System.out.println("FAILED");
        }
        Disconnect();
    }
    
    //delete 
    public void deleteStudent(Student s)
    {
        connect();
        String query = "DELETE FROM `STUDENTTABLE` WHERE USERNAME = '"+s.getUsernameSiswa()+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    public void deleteTentor(Tentor t)
    {
        connect();
        String query = "DELETE FROM `TENTORTABLE` WHERE ID_TENTOR = '"+t.getIdTentor()+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<dosen.size();i++){
                if(dosen.get(i).getUsernameTentor().equals(t.getUsernameTentor())){
                    dosen.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    public void deleteKelas(Kelas k)
    {
        connect();
        String query = "DELETE FROM `KELASTABLE` WHERE ID_KELAS= '"+k.getIdKelas()+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<kelas.size();i++){
                if(kelas.get(i).getIdKelas().equals(k.getIdKelas())){
                    kelas.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    public void deleteKelasTentor(Kelas k, Tentor t)
    {
        connect();
        String query = "DELETE FROM `KELASTABLE` WHERE NAMA_TENTOR = '"+t.getName()+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<kelas.size();i++){
                if(kelas.get(i).getIdKelas().equals(k.getIdKelas())){
                    kelas.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    public void deleteMateri(Materi m)
    {
        connect();
        String query = "DELETE FROM `MATERITABLE` WHERE ID_MATERI = '"+m.getIdMateri()+"' AND NAMAMATERI ='"+m.getName()+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<materi.size();i++){
                if(materi.get(i).getIdMateri().equals(m.getClass())){
                    materi.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    public void deleteMataPelajaran(mataPelajaran mapel1)
    {
        connect();
        String query = "DELETE FROM `MATAPELAJARANTABLE` WHERE ID_MAPEL= '"+mapel1.getIdMapel()+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<mapel.size();i++){
                if(mapel.get(i).getIdMapel().equals(mapel1.getIdMapel())){
                    mapel.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    public void deleteListStudent(Student s, String namaKelas)
    {
        connect();
        String query = "DELETE FROM liststudenttable WHERE ID_SISWA = "+s.getName()+" AND NAMA_KELASLIST = '"+namaKelas+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<kelasStudent.size();i++){
                if(kelasStudent.get(i).getListStudent(i).getName().equals(s.getName()) && kelasStudent.get(i).getName().equals(namaKelas)){
                    kelasStudent.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    
    public void deleteListStudentTentor(Kelas k,String namaTentor)
    {
        connect();
        String query = "DELETE FROM liststudenttable WHERE NAMATENTOR = '"+namaTentor+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
            for(int i = 0; i<kelasStudent.size();i++){
                if(kelasStudent.get(i).getName().equals(k.getName())){
                    kelasStudent.remove(i);
                }
            }
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
    
    public void deleteListTentor(Kelas k,String namaTentor)
    {
        connect();
        String query = "DELETE FROM LISTKELASTENTOR WHERE NAMAKELASLT = '"+k.getName()+"' AND NAMATENTORLT = '"+namaTentor+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
     public void deleteListTentorAll(String namaTentor)
    {
        connect();
        String query = "DELETE FROM LISTKELASTENTOR WHERE NAMATENTORLT = '"+namaTentor+"';";
        if (Manipulate(query))
        {
            System.out.println("TERHAPUS");
        }
        else
        {
            System.out.println("GAGAL");
    
        }
        Disconnect();
    }
     
    //getObject
    public Student loadOneStudent(String nama)
    {
    try{
        String query = "SELECT * FROM 'STUDENTTABLE' WHERE ID_SISWA ='"+nama+"';" ;
        stmt  = con.createStatement();
        rs = stmt.executeQuery(query);
        Student s = null;
        while (rs.next()){
            String name = rs.getString("NAMA");
            int umur = rs.getInt("UMUR");
            String id = rs.getString("ID_SISWA");
            String userName = rs.getString("USERNAME");
            String passSt = rs.getString("PASSWORD");               
            s = new Student(name,umur,id,userName,passSt);
        }
        return s;
    }catch(SQLException se){
        return null;
    }
    }
    
    public Tentor loadOneTentor(String idTentor)
    {
        try{
            String query = "SELECT * FROM TENTORTABLE WHERE ID_TENTOR ='"+idTentor+"';";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            Tentor t = null;
            while(rs.next()){
                String name = rs.getString("NAMA");
                String id = rs.getString("ID_TENTOR");
                int umur = rs.getInt("UMUR");
                String userName = rs.getString("USERNAME");
                String passSt = rs.getString("PASSWORD");
                t = new Tentor(name,id,umur,userName,passSt);
            }
            return t;
        }catch (SQLException se){
            return null;
    }
    }
    public String loadIdMateri(String idKelas)
    {
        try{
            String query = "SELECT ID_MATERI FROM KELASTABLE WHERE ID_KELAS ='"+idKelas+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            String name = "";
            while(rs.next()){
                name += rs.getString("ID_MATERI");
            }    
            return name;
        }catch(SQLException se){
                return null;
        }
    }
    
    public mataPelajaran loadOneMapel(String idMapel){
        try{
            String query = "SELECT * FROM 'MATAPELAJARANTABLE' WHERE ID_MAPEL'"+idMapel+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            mataPelajaran mapel = null;
            while(rs.next()){
                String nama = rs.getString("NAMAKELAS");
                String id = rs.getString("ID_MAPEL");
                mapel = new mataPelajaran(id,nama);
            }
            return mapel;
        }catch (SQLException se){
            return null;
        }
    }
    public Materi loadOneMateri(String idMateri){
        try{
            String query = "SELECT * FROM MATERITABLE WHERE ID_MATERI'"+idMateri+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            Materi materi = null;
            while (rs.next()){
                String nama = rs.getString("NAMAMATERI");
                String id = rs.getString("ID_MATERI");
                materi = new Materi(id,nama);
            }
            return materi;
        }catch (SQLException se){
            return null;
        }
    }
    
    //update
    public void updateStudent(Student s, String idSiswa) {
        connect();
        String query = "UPDATE STUDENTTABLE SET";
        query += " `NAMA`='" + s.getName() + "',";
        query += " `UMUR` ='" + s.getUmur() + "',";
        query += " `USERNAME`='" + s.getUsernameSiswa() + "',";
        query += " `PASSWORD`='" + s.getPassSiswa() + "'";
        query += " WHERE `ID_SISWA` ='" +idSiswa+ "';";
        if (Manipulate(query)){
            for (Student find : mahaSiswa) {
                if (find.getIdSiswa().equals(idSiswa)){
                    find.setName(s.getName());
                    find.setIdSiswa(s.getIdSiswa());
                    find.setAge(s.getUmur());
                    find.setUsernameSiswa(s.getUsernameSiswa());
                    find.setPassSiswa(s.getPassSiswa());
                    break;
                }
            }
        }
        Disconnect();
    }
    public void updateTentor(Tentor t, String nama){
        connect();
        String query = "UPDATE TENTORTABLE SET";
        query += " `NAMA` = '" + t.getName() + "',";
        query += " `ID_TENTOR` = '" + t.getIdTentor() + "',";
        query += " `UMUR` = '" + t.getAge()+ "',";
        query += " `USERNAME`='" + t.getUsernameTentor() + "',";
        query += " `PASSWORD`='" + t.getPassTentor() + "'";
        query += " WHERE `NAMA` ='"+nama+"';";
        if(Manipulate(query)){
            for(Tentor find : dosen){
                if (find.getName().equals(nama)){
                    find.setName(t.getName());
                    find.setIdTentor(t.getIdTentor());
                    find.setAge(t.getAge());
                    find.setUsernameTentor(t.getUsernameTentor());
                    find.setPassTentor(t.getPassTentor());
                    break;
                }
            }
        }
    }
    public void updateKelas(Kelas k, Tentor t){
        connect();
        String query = "UPDATE KELASTABLE SET";
        query += " `NAMA_TENTOR` ='" + t.getName() + "'";
        query += "  WHERE  ID_KELAS ='" +k.getIdKelas()+ "';";
        if(Manipulate(query)){
            loadTentor();
            for(Tentor find : dosen){
                for(Kelas p : kelas){
                    if (p.getIdKelas().equals(k.getIdKelas())){
                        find.addKelas(p);
                        break;
                     }
                }             
            }
        }
    }  
    
    public void updateKelasMapel(Kelas k, mataPelajaran m){
        connect();
        String query = "UPDATE KELASTABLE SET";
        query += " `NAMAKELAS` ='" + k.getName() + "',";
        query += " `ID_MAPEL` ='" + m.getIdMapel() + "'";
        query += "  WHERE  ID_KELAS ='" +k.getIdKelas()+ "';";
        Manipulate(query);
    }
    public void updateKelasMapelHapus(Kelas k){
        connect();
        String query = "UPDATE KELASTABLE SET";
        query += " `NAMAKELAS` ='" + k.getName() + "',";
        query += " `ID_MAPEL` ='" + "" + "'";
        query += "  WHERE  ID_KELAS ='" +k.getIdKelas()+ "';";
        Manipulate(query);
    }
    public void updateKelasTentorHapus(Kelas k,String namaTentor){
        connect();
        String query = "UPDATE KELASTABLE SET";
        query += " `NAMA_TENTOR` ='" +  namaTentor+ "',";
        query += "  WHERE  ID_KELAS ='" +k.getIdKelas()+ "';";
        Manipulate(query);
    }
     
    public void updateKelasMateri(Kelas k, Materi m){
        connect();
        String query = "UPDATE KELASTABLE SET";
        query += " `ID_MATERI` ='" + m.getIdMateri() + "'";
        query += "  WHERE  ID_KELAS ='" +k.getIdKelas()+ "';";
        if(Manipulate(query)){
            loadMateri();
            loadKelas();
            for(Kelas find : kelas){
                for(Materi p : materi){
                    if (find.getIdKelas().equals(k.getIdKelas())){
                        find.addMateri(m);
                        break;
                     }
                }             
            }
        }
    }
    public void updateMateri(Materi m, String idKelas){
        connect();
        String query = "UPDATE MATERITABLE SET";
        query += "  ID_KELAS ='" + idKelas + "'";
        query += "  WHERE  ID_MATERI ='" +m.getIdMateri()+ "';";
        Manipulate(query);
    }
    public void updateDataMateri(Materi lama,Materi baru,String idKelas){
        connect();
        String query = "UPDATE MATERITABLE SET";
        query += "  ID_MATERI ='" + baru.getIdMateri() + "',";
        query += "  NAMAMATERI ='" +baru.getName() + "',";
        query += "  ID_KELAS ='" + idKelas + "'";
        query += "  WHERE  ID_KELAS ='" +idKelas+ "' AND NAMAMATERI = '"+lama.getName()+"';";
        Manipulate(query);
//        if(Manipulate(query)){
//            List<Materi> newMateri;
//            loadKelas();
//            for (Kelas p : kelas) {
//                newMateri = loadMateriTertentu(p.getIdKelas());
//                for(int i =0; i<newMateri.size();i++){
//                    newMateri.get(i).setName(baru.getName());
//                    newMateri.get(i).setIdMateri(baru.getIdMateri());
//                }
//                break;
//            }                       
//        }
    }
     public void updateListStudent(String namaTentor){
        connect();
        String query = "UPDATE LISTSTUDENTTABLE SET";
        query += "  NAMATENTOR ='" + "" + "'";
        query += "  WHERE  NAMATENTOR = '" +namaTentor+ "';";
        Manipulate(query);
    }
    public void updateMapel(mataPelajaran m, String idKelas){
        connect();
        String query = "UPDATE MATAPELAJARANTABLE SET";
        query += "  ID_KELAS ='" + idKelas + "'";
        query += "  WHERE  ID_MAPEL='" +m.getIdMapel()+ "';";
        Manipulate(query);
    }
    public void updateMapelHapus(mataPelajaran m){
        connect();
        String query = "UPDATE MATAPELAJARANTABLE SET";
        query += "  ID_KELAS ='" + "" + "'";
        query += "  WHERE  ID_MAPEL='" +m.getIdMapel()+ "';";
        Manipulate(query);
    }
     public void updateMapelTentor(String idKelas){
        connect();
        String query = "UPDATE MATAPELAJARANTABLE SET";
        query += "  ID_KELAS ='" + "" + "'";
        query += "  WHERE  ID_KELAS='" +idKelas+ "';";
        Manipulate(query);
    }
      public void updateMateriTentor(String idKelas){
        connect();
        String query = "UPDATE MATERITABLE SET";
        query += "  ID_KELAS ='" + "" + "'";
        query += "  WHERE  ID_KELAS ='" +idKelas+ "';";
        Manipulate(query);
    }
     public void updateDataMapel(mataPelajaran lama,mataPelajaran baru,String idKelas){
        connect();
        String query = "UPDATE MATAPELAJARANTABLE SET";
        query += "  ID_MAPEL='" + baru.getIdMapel() + "',";
        query += "  NAMAMAPEL ='" +baru.getName() + "',";
        query += "  ID_KELAS ='" + idKelas + "'";
        query += "  WHERE  ID_KELAS ='" +idKelas+ "' AND NAMAMAPEL = '"+lama.getName()+"';";
        Manipulate(query);
//        if(Manipulate(query)){
//            List<Materi> newMateri;
//            loadKelas();
//            for (Kelas p : kelas) {
//                newMateri = loadMateriTertentu(p.getIdKelas());
//                for(int i =0; i<newMateri.size();i++){
//                    newMateri.get(i).setName(baru.getName());
//                    newMateri.get(i).setIdMateri(baru.getIdMateri());
//                }
//                break;
//            }                       
//        }
    }
    
    //Load Tertentu
    public List<Kelas> loadKelasTertentu(String anam){
        connect();
        List<Kelas> newKelas = new ArrayList<>();
        try {
            String Query = "SELECT * FROM KELASTABLE WHERE NAMA_TENTOR = '"+anam+"';";
            List<Materi> newMateri = new ArrayList<>();
            List<mataPelajaran> newMapel = new ArrayList<>();
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                Kelas k = new Kelas(rs.getString("NAMAKELAS"),rs.getString("ID_KELAS"));
                mataPelajaran ma = new mataPelajaran(rs.getString("ID_MAPEL"),"");
                Materi m = new Materi(rs.getString("ID_MATERI"),"");
                k.addMateri(m);
                k.addMapel(ma);
                newKelas.add(k);
            }
            for(Kelas p : newKelas){
                newMateri = loadMateriTertentu(p.getIdKelas());
                newMapel = loadMapelTertentu(p.getIdKelas());
                for(Materi s : newMateri){
                    p.addMateri(s);
                }
                for(mataPelajaran r : newMapel){
                    p.addMapel(r);
                }
            }
        Disconnect();  
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newKelas; 
    }
    public List<Materi> loadMateriTertentu(String idKelas){
        connect();
        List<Materi> newMateri = new ArrayList<>();
        try {
            String Query = "SELECT * FROM MATERITABLE WHERE ID_KELAS = '"+idKelas+"';";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                newMateri.add(new Materi(rs.getString("ID_MATERI"),rs.getString("NAMAMATERI")));
            }
        Disconnect();  
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newMateri;
    }
    public List<mataPelajaran> loadMapelTertentu(String idKelas){
        connect();
        List<mataPelajaran> newMapel = new ArrayList<>();
        try {
            String Query = "SELECT * FROM MATAPELAJARANTABLE WHERE ID_KELAS = '"+idKelas+"';";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                newMapel.add(new mataPelajaran(rs.getString("ID_MAPEL"),rs.getString("NAMAMAPEL")));
            }
        Disconnect();  
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newMapel;
    }
    public List<Student> loadStudentKelasTertentu(String idKelas){
       connect();
        List<Student> newStudent = new ArrayList<>();
        try {
            String Query = "SELECT * FROM LISTSTUDENTTABLE WHERE ID_KELASLIST = '"+idKelas+"';";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                newStudent.add(new Student(rs.getString("ID_SISWA"),0));
            }
        Disconnect();  
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newStudent; 
    }
    
    public List<Student> loadStudentTentorTertentu(String idKelas , String namaTentor){
       connect();
        List<Student> newStudent = new ArrayList<>();
        try {
            String Query = "SELECT * FROM LISTSTUDENTTABLE WHERE ID_KELASLIST = '"+idKelas+"' AND NAMATENTOR = '"+namaTentor+"';";
            rs = stmt.executeQuery(Query);
            while (rs.next())
            {
                newStudent.add(new Student(rs.getString("ID_SISWA"),0));
            }
        Disconnect();  
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newStudent; 
    }
    
    public boolean cekSiswa(String user)
    {
        for (Student p : mahaSiswa)
        {
            if ( user.equals(p.getIdSiswa()))
            {
                return true;
            }
        }
        return false;
    }
    public boolean cekTentor(String user,String nama)
    {
        for (Tentor p : dosen)
        {
            if ((user.equals(p.getIdTentor()) && (!nama.equals(p.getName()))))
            {
                return true;
            }
        }
        return false;
    }
   
  
}
