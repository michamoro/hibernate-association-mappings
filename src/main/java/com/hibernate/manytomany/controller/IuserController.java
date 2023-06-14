package com.hibernate.manytomany.controller;

import com.hibernate.manytomany.entity.Iuser;
import com.hibernate.manytomany.repository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/iusers")
public class IuserController {

    private final IuserRepository iuserRepository;

    @Autowired
    public IuserController(IuserRepository iuserRepository) {
        this.iuserRepository = iuserRepository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Iuser addNewUser(@RequestBody Iuser user) {
        return iuserRepository.save(user);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Iuser> getIusers() {
        List<Iuser> iusers = new ArrayList<>();
        iuserRepository.findAll().iterator().forEachRemaining(iusers::add);
        return iusers;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Iuser> getIuserById(@PathVariable("id") int id) {
        Iuser iuser = iuserRepository.findById(id).orElse(null);
        if (iuser != null) {
            return ResponseEntity.ok(iuser);
        } else return ResponseEntity.notFound().build();
    }

}
