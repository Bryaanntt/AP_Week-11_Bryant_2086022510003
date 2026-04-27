package com.mysql.mysql.Alumni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/alumni")
public class AlumniController {

    @Autowired
    private AlumniRepository alumniRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addAlumni(
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam int angkatan,
            @RequestParam String campus,
            @RequestParam String jurusan) {

        Alumni a = new Alumni();
        a.setnama(nama);
        a.setnim(nim);
        a.setangkatan(angkatan);
        a.setcampus(campus);
        a.setjurusan(jurusan);

        alumniRepository.save(a);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Alumni> getAllAlumni() {
        return alumniRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Alumni getAlumniById(@PathVariable int id) {
        return alumniRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateAlumni(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam int angkatan,
            @RequestParam String campus,
            @RequestParam String jurusan) {

        Alumni a = alumniRepository.findById(id).orElse(null);
        if (a == null) return "Data tidak ditemukan";

        a.setnama(nama);
        a.setnim(nim);
        a.setangkatan(angkatan);
        a.setcampus(campus);
        a.setjurusan(jurusan);

        alumniRepository.save(a);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteAlumni(@PathVariable int id) {
        alumniRepository.deleteById(id);
        return "Deleted";
    }
}