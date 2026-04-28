package com.mysql.mysql.Dosen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dosen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public String nama;
    public String nid;
    public String campus;
    public String Mata_Kuliah;
    public String gender;


    public Dosen() {}

    public Dosen(int id, String nama, String nid, String campus, String Mata_Kuliah, String gender) {
        this.id = id; 
        this.nama = nama; 
        this.nid = nid; 
        this.campus = campus;
        this.Mata_Kuliah = Mata_Kuliah;
        this.gender = gender;
    }

    public int getid(){ return id; } 
    public void setid(int id){ this.id = id; }

    public String getnama(){ return nama; } 
    public void setnama(String nama){ this.nama = nama; }

    public String getnid(){ return nid; } 
    public void setnid(String nid){ this.nid = nid; }

    public String getcampus(){ return campus; } 
    public void setcampus(String campus){ this.campus = campus; }

    public String getMata_Kuliah(){ return Mata_Kuliah; } 
    public void setMata_Kuliah(String Mata_Kuliah){ this.Mata_Kuliah = Mata_Kuliah; }

    public String getgender(){ return gender; } 
    public void setgender(String gender){ this.gender = gender; }

}