package com.mysql.mysql.Ruangan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/ruangan")
public class RuanganController {

    @Autowired
    private RuanganRepository ruanganRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addRuangan(
            @RequestParam String kode_ruang,
            @RequestParam String nama_ruang,
            @RequestParam int kapasitas,
            @RequestParam String status) {

        Ruangan r = new Ruangan();
        r.setkode_ruang(kode_ruang);
        r.setnama_ruang(nama_ruang);
        r.setkapasitas(kapasitas);
        r.setstatus(status);

        ruanganRepository.save(r);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ruangan> getAllRuangan() {
        return ruanganRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Ruangan getRuanganById(@PathVariable int id) {
        return ruanganRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateRuangan(
            @PathVariable int id,
            @RequestParam String kode_ruang,
            @RequestParam String nama_ruang,
            @RequestParam int kapasitas,
            @RequestParam String status) {

        Ruangan r = ruanganRepository.findById(id).orElse(null);
        if (r == null) return "Data tidak ditemukan";

        r.setkode_ruang(kode_ruang);
        r.setnama_ruang(nama_ruang);
        r.setkapasitas(kapasitas);
        r.setstatus(status);

        ruanganRepository.save(r);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteRuangan(@PathVariable int id) {
        ruanganRepository.deleteById(id);
        return "Deleted";
    }
}