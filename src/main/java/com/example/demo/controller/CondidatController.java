package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Condidat;
import com.example.demo.service.CondidatService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/condidat/")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @PostMapping()
    public Condidat postMethodName(@RequestBody Condidat condidat) {

        return condidatService.add(condidat);
    }

    @GetMapping
    public List<Condidat> getAllCondidat() {
        return condidatService.findAll();
    }

    @GetMapping("{id}")
    public Condidat getCondidat(@PathVariable("id") Long id) {

        return condidatService.findById(id);
    }

}
