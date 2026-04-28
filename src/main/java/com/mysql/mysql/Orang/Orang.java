package com.mysql.mysql.Orang;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public String nama;
    public String nim;
    public String kelas;
    public int kill;
    public int death;
    public int assist;


    public Orang() {}

    public Orang(int id, String nama, String nim, String kelas, int kill, int death, int assist) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
    }

    public int getid(){ return id; }
    public void setid(int id){ this.id = id; }

    public String getnama(){ return nama; }
    public void setnama(String nama){ this.nama = nama; }

    public String getnim(){ return nim; }
    public void setnim(String nim){ this.nim = nim; }

    public String getkelas(){ return kelas; }
    public void setkelas(String kelas){ this.kelas = kelas; }
    
    public int getkill(){ return kill; }
    public void setkill(int kill){ this.kill = kill; }

    public int getdeath(){ return death; }
    public void setdeath(int death){ this.death = death; }

    public int getassist(){ return assist; }
    public void setassist(int assist){ this.assist = assist; }
    
}