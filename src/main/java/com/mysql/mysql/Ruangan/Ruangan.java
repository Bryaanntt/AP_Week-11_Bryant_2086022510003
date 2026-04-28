package com.mysql.mysql.Ruangan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ruangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public String kode_ruang;
    public String nama_ruang;
    public int kapasitas;
    public String status;

    public Ruangan() {}

    public Ruangan(int id, String kode_ruang, String nama_ruang, int kapasitas, String status) {
        this.id = id;
        this.kode_ruang = kode_ruang;
        this.nama_ruang = nama_ruang;
        this.kapasitas = kapasitas;
        this.status = status;
    }

    public int getid() { return id; }
    public void setid(int id) { this.id = id; }

    public String getkode_ruang() { return kode_ruang; }
    public void setkode_ruang(String kode_ruang) { this.kode_ruang = kode_ruang; }

    public String getnama_ruang() { return nama_ruang; }
    public void setnama_ruang(String nama_ruang) { this.nama_ruang = nama_ruang; }

    public int getkapasitas() { return kapasitas; }
    public void setkapasitas(int kapasitas) { this.kapasitas = kapasitas; }

    public String getstatus() { return status; }
    public void setstatus(String status) { this.status = status; }
}