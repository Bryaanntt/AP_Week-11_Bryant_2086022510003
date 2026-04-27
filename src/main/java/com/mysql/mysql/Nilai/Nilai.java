package com.mysql.mysql.Nilai;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nim;
    public String mata_kuliah;
    public String semester;
    public double nilai_akhir;
    public String grade;
    public String status_lulus; // lulus, tidak lulus

    public Nilai() {}

    public Nilai(int id, String nim, String mata_kuliah, String semester, double nilai_akhir, String grade, String status_lulus) {
        this.id = id;
        this.nim = nim;
        this.mata_kuliah = mata_kuliah;
        this.semester = semester;
        this.nilai_akhir = nilai_akhir;
        this.grade = grade;
        this.status_lulus = status_lulus;
    }

    public int getid() { return id; }
    public void setid(int id) { this.id = id; }

    public String getnim() { return nim; }
    public void setnim(String nim) { this.nim = nim; }

    public String getmata_kuliah() { return mata_kuliah; }
    public void setmata_kuliah(String mata_kuliah) { this.mata_kuliah = mata_kuliah; }

    public String getsemester() { return semester; }
    public void setsemester(String semester) { this.semester = semester; }

    public double getnilai_akhir() { return nilai_akhir; }
    public void setnilai_akhir(double nilai_akhir) { this.nilai_akhir = nilai_akhir; }

    public String getgrade() { return grade; }
    public void setgrade(String grade) { this.grade = grade; }

    public String getstatus_lulus() { return status_lulus; }
    public void setstatus_lulus(String status_lulus) { this.status_lulus = status_lulus; }
}