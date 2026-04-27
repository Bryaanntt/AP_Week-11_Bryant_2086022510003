package com.mysql.mysql.Staff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nama;
    public String nik;
    public String campus;
    public String pekerjaan;
    public String gender;

    public Staff() {}

    public Staff(int id, String nama, String nik, String campus, String pekerjaan, String gender) {
        this.id = id; 
        this.nama = nama; 
        this.nik = nik; 
        this.campus = campus;
        this.pekerjaan = pekerjaan;
        this.gender = gender;
    }

    public int getid(){ return id; } 
    public void setid(int id){ this.id = id; }

    public String getnama(){ return nama; } 
    public void setnama(String nama){ this.nama = nama; }

    public String getnik(){ return nik; } 
    public void setnik(String nik){ this.nik = nik; }

    public String getcampus(){ return campus; } 
    public void setcampus(String campus){ this.campus = campus; }

    public String getpekerjaan(){ return pekerjaan;} 
    public void setpekerjaan(String pekerjaan){ this.pekerjaan = pekerjaan; }

    public String getgender(){ return gender; } 
    public void setgender(String gender){ this.gender = gender; }
}