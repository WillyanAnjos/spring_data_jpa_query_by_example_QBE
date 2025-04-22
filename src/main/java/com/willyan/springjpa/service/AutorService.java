package com.willyan.springjpa.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.willyan.springjpa.entity.Autor;
import com.willyan.springjpa.entity.InfoAutor;
import com.willyan.springjpa.projection.AutorInfoProjection;
import com.willyan.springjpa.repository.AutorRepository;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    @Transactional(readOnly = false)
    public void save(Autor autor) {
        this.repository.save(autor);
    }

    @Transactional(readOnly = false)
    public void update(Autor autor) {
        this.repository.save(autor);
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Autor findById(Long id) {
        //return this.repository.findById(id).get();
        //return this.repository.findById(id).orElseGet(Autor::new);
        return this.repository.findById(id).orElseThrow(
                () -> new RuntimeException("Autor id=" + id + " não encontrado.")
        );
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Autor> findAllByNomeOrSobrenome(String termo) {
        return this.repository.findAllByNomeOrSobrenome("%" + termo + "%");
    }

    @Transactional(readOnly = true)
    public Long getTotalElements() {
        return this.repository.count();
    }

    @Transactional(readOnly = false)
    public Autor saveInfoAutor(InfoAutor infoAutor, Long autorId) {
        Autor autor = findById(autorId);
        autor.setInfoAutor(infoAutor);
        return autor;
    }

    @Transactional(readOnly = true)
    public List<Autor> findByCargo(String cargo) {
        return this.repository.findByCargo("%" + cargo + "%");
    }

    @Transactional(readOnly = true)
    public AutorInfoProjection findAutorInfoById(Long id) {
        return this.repository.findAutorInfoById(id);
    }

}
