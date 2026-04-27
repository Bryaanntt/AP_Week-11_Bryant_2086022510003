package com.mysql.mysql.Nilai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/nilai")
public class NilaiController {

    @Autowired
    private NilaiRepository nilaiRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNilai(
            @RequestParam String nim,
            @RequestParam String mata_kuliah,
            @RequestParam String semester,
            @RequestParam double nilai_akhir) {

        Nilai n = new Nilai();
        n.setnim(nim);
        n.setmata_kuliah(mata_kuliah);
        n.setsemester(semester);
        n.setnilai_akhir(nilai_akhir);

        // Grade & status otomatis
        if (nilai_akhir >= 85) n.setgrade("A");
        else if (nilai_akhir >= 75) n.setgrade("B");
        else if (nilai_akhir >= 65) n.setgrade("C");
        else if (nilai_akhir >= 55) n.setgrade("D");
        else n.setgrade("E");

        n.setstatus_lulus(nilai_akhir >= 55 ? "Lulus" : "Tidak Lulus");

        nilaiRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Nilai> getAllNilai() {
        return nilaiRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Nilai getNilaiById(@PathVariable int id) {
        return nilaiRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateNilai(
            @PathVariable int id,
            @RequestParam String nim,
            @RequestParam String mata_kuliah,
            @RequestParam String semester,
            @RequestParam double nilai_akhir) {

        Nilai n = nilaiRepository.findById(id).orElse(null);
        if (n == null) return "Data tidak ditemukan";

        n.setnim(nim);
        n.setmata_kuliah(mata_kuliah);
        n.setsemester(semester);
        n.setnilai_akhir(nilai_akhir);

        // Grade & status otomatis
        if (nilai_akhir >= 85) n.setgrade("A");
        else if (nilai_akhir >= 75) n.setgrade("B");
        else if (nilai_akhir >= 65) n.setgrade("C");
        else if (nilai_akhir >= 55) n.setgrade("D");
        else n.setgrade("E");

        n.setstatus_lulus(nilai_akhir >= 55 ? "Lulus" : "Tidak Lulus");

        nilaiRepository.save(n);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteNilai(@PathVariable int id) {
        nilaiRepository.deleteById(id);
        return "Deleted";
    }
}