package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class VendedorServicio implements VendedorInterface{

    @Autowired 
    private VendedorDAO vendedorDAO;

    @Override
    @Transactional
    public void guardar(Vendedor vendedor) {
       vendedorDAO.save(vendedor);
    }

    @Override
    @Transactional
    public List<Vendedor> listado(){
        return vendedorDAO.findAll();
    }

    @Override
    @Transactional
    public Vendedor consultar(Integer id) {
        return vendedorDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        vendedorDAO.deleteById(id);
    }
    
}
