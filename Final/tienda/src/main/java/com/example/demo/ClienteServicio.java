package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio implements ClienteInterface {

    @Autowired 
    private ClienteDAO clienteDAO;
    @Autowired
    private VendedorDAO vendedorDAO;

    @Override
    @Transactional
    public void guardarCliente(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    @Transactional
    public List<Cliente> listadoCliente() {
       return clienteDAO.findAll();
    }

    @Override
    @Transactional
    public Cliente consultarCliente(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarCliente(Integer id) {
        clienteDAO.deleteById(id);
    }    
}   

