package com.mysql.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/orang")
public class OrangController {

    @Autowired
    private OrangRepository orangRepository;

    // POST /orang/add — tambah data baru
    @PostMapping(path = "/add")
    public @ResponseBody String addNewOrang(
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String campus,
            @RequestParam String kelas,
            @RequestParam String hobby,
            @RequestParam String gender,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist,   
            @RequestParam String rank,
            @RequestParam String role) {

        Orang o = new Orang();
        o.setnama(nama);
        o.setnim(nim);
        o.setcampus(campus);
        o.setkelas(kelas);
        o.sethobby(hobby);
        o.setgender(gender);
        o.setkill(kill);
        o.setdeath(death);
        o.setassist(assist);
        o.setrank(rank);
        o.setrole(role);

        orangRepository.save(o);
        return "Saved";
    }

    // GET /orang/all — ambil semua data
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Orang> getAllOrang() {
        return orangRepository.findAll();
    }

    // GET /orang/{id} — ambil data by ID
    @GetMapping(path = "/{id}")
    public @ResponseBody Orang getOrangById(@PathVariable int id) {
        return orangRepository.findById(id).orElse(null);
    }

    // PUT /orang/update/{id} — update data by ID
    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateOrang(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String campus,
            @RequestParam String kelas,
            @RequestParam String hobby,
            @RequestParam String gender,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist,
            @RequestParam String rank,
            @RequestParam String role) {

        Orang o = orangRepository.findById(id).orElse(null);
        if (o == null) return "Data tidak ditemukan";

        o.setnama(nama);
        o.setnim(nim);
        o.setcampus(campus);
        o.setkelas(kelas);
        o.sethobby(hobby);
        o.setgender(gender);
        o.setkill(kill);
        o.setdeath(death);
        o.setassist(assist);
        o.setrank(rank);
        o.setrole(role);

        orangRepository.save(o);
        return "Updated";
    }

    // DELETE /orang/delete/{id} — hapus data by ID
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteOrang(@PathVariable int id) {
        orangRepository.deleteById(id);
        return "Deleted";
    }
}