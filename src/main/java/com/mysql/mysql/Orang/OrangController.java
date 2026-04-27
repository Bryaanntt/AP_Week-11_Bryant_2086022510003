package com.mysql.mysql.Orang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/orang")
public class OrangController {

    @Autowired
    private OrangRepository orangRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewOrang(
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String kelas,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist) {

        Orang o = new Orang();
        o.setnama(nama);
        o.setnim(nim);
        o.setkelas(kelas);
        o.setkill(kill);
        o.setdeath(death);
        o.setassist(assist);

        orangRepository.save(o);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Orang> getAllOrang() {
        return orangRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Orang getOrangById(@PathVariable int id) {
        return orangRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateOrang(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String kelas,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist) {

        Orang o = orangRepository.findById(id).orElse(null);
        if (o == null) return "Data tidak ditemukan";

        o.setnama(nama);
        o.setnim(nim);
        o.setkelas(kelas);
        o.setkill(kill);
        o.setdeath(death);
        o.setassist(assist);

        orangRepository.save(o);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteOrang(@PathVariable int id) {
        orangRepository.deleteById(id);
        return "Deleted";
    }
}