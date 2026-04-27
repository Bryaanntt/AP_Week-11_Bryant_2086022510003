package com.mysql.mysql.Dosen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/dosen")
public class DosenController {

    @Autowired
    private DosenRepository dosenRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addDosen(
            @RequestParam String nama,
            @RequestParam String nid,
            @RequestParam String campus,
            @RequestParam String Mata_Kuliah,
            @RequestParam String gender) {

        Dosen d = new Dosen();
        d.setnama(nama);
        d.setnid(nid);
        d.setcampus(campus);
        d.setMata_Kuliah(Mata_Kuliah);
        d.setgender(gender);

        dosenRepository.save(d);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Dosen> getAllDosen() {
        return dosenRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Dosen getDosenById(@PathVariable int id) {
        return dosenRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateDosen(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nid,
            @RequestParam String campus,
            @RequestParam String Mata_Kuliah,
            @RequestParam String gender) {

        Dosen d = dosenRepository.findById(id).orElse(null);
        if (d == null) return "Data tidak ditemukan";

        d.setnama(nama);
        d.setnid(nid);
        d.setcampus(campus);
        d.setMata_Kuliah(Mata_Kuliah);
        d.setgender(gender);

        dosenRepository.save(d);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteDosen(@PathVariable int id) {
        dosenRepository.deleteById(id);
        return "Deleted";
    }
}