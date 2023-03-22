package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Condidat;
import com.example.demo.repository.CondidatRepository;

@Service

public class CondidatService {

    @Autowired
    private CondidatRepository condidatRepository;

    @Transactional
    public Condidat add(Condidat condidat) {
        return condidatRepository.save(condidat);

    }

    public Condidat findById(Long id) {
        return condidatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("cannot find condidat with id" + id));
    }

    public List<Condidat> findAll() {
        return condidatRepository.findAll();
    }

}
