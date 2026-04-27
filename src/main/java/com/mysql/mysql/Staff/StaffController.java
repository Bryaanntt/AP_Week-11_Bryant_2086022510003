package com.mysql.mysql.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addStaff(
            @RequestParam String nama,
            @RequestParam String nik,
            @RequestParam String campus,
            @RequestParam String pekerjaan,
            @RequestParam String gender) {

        Staff s = new Staff();
        s.setnama(nama);
        s.setnik(nik);
        s.setcampus(campus);
        s.setpekerjaan(pekerjaan);
        s.setgender(gender);

        staffRepository.save(s);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Staff getStaffById(@PathVariable int id) {
        return staffRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateStaff(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nik,
            @RequestParam String campus,
            @RequestParam String pekerjaan,
            @RequestParam String gender) {

        Staff s = staffRepository.findById(id).orElse(null);
        if (s == null) return "Data tidak ditemukan";

        s.setnama(nama);
        s.setnik(nik);
        s.setcampus(campus);
        s.setpekerjaan(pekerjaan);
        s.setgender(gender);

        staffRepository.save(s);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteStaff(@PathVariable int id) {
        staffRepository.deleteById(id);
        return "Deleted";
    }
}