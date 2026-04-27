package com.mysql.mysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orang{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nama;
    public String nim;
    public String campus;
    public String kelas;
    public String hobby;
    public String gender;
    public int kill;
    public int death;
    public int assist;
    public String rank;
    public String role;


    public Orang() {}

    public Orang(int id, String nama, String nim, String campus, String kelas, String hobby, String gender, int kill, int death, int assist, String rank, String role) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.campus = campus;
        this.kelas = kelas;
        this.hobby = hobby;
        this.gender = gender;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
        this.rank = rank;
        this.role = role;
    }

    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }

    public String getnama(){
        return nama;
    }
    public void setnama(String nama){
        this.nama = nama;
    }

    public String getnim(){
        return nim;
    }
    public void setnim(String nim){
        this.nim = nim;
    }

    public String getcampus(){
        return campus;
    }
    public void setcampus(String campus){
        this.campus = campus;
    }

    public String gethobby(){
        return hobby;
    }
    public void sethobby(String hobby){
        this.hobby = hobby;
    }

    public String getgender(){
        return gender;
    }
    public void setgender(String gender){
        this.gender = gender;
    }

    public String getkelas(){
        return kelas;
    }
    public void setkelas(String kelas){
        this.kelas = kelas;
    }

    public int getkill(){
        return kill;
    }
    public void setkill(int kill){
        this.kill = kill;
    }

    public int getdeath(){
        return death;
    }
    public void setdeath(int death){
        this.death = death;
    }

    public int getassist(){
        return assist;
    }
    public void setassist(int assist){
        this.assist = assist;
    }

    public String getrank(){
        return rank;
    }
    public void setrank(String rank){
        this.rank = rank;
    }

    public String getrole(){
        return role;
    }
    public void setrole(String role){
        this.role = role;
    }

}