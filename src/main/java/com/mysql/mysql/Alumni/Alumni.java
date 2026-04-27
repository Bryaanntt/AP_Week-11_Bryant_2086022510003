package com.mysql.mysql.Alumni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nama;
    public String nim;
    public int angkatan;
    public String campus;
    public String jurusan;

    public Alumni() {}

    public Alumni(int id, String nama, String nim, int angkatan, String campus, String jurusan) {
        this.id = id; 
        this.nama = nama; 
        this.nim = nim; 
        this.angkatan = angkatan;
        this.campus = campus;
        this.jurusan = jurusan;
    }

    public int getid(){ return id; } 
    public void setid(int id){ this.id = id; }

    public String getnama(){ return nama; } 
    public void setnama(String nama){ this.nama = nama; }

    public String getnim(){ return nim; } 
    public void setnim(String nim){ this.nim = nim; }

    public String getcampus(){ return campus; } 
    public void setcampus(String campus){ this.campus = campus; }

    public int getangkatan(){ return angkatan; } 
    public void setangkatan(int angkatan){ this.angkatan = angkatan; }

    public String getjurusan(){ return jurusan; } 
    public void setjurusan(String jurusan){ this.jurusan = jurusan; }
}