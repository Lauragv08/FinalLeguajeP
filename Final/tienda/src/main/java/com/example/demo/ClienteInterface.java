package com.example.demo;

import java.util.List;

public interface ClienteInterface {
    public void guardarCliente(Cliente cliente);
    public List<Cliente> listadoCliente();
    public Cliente consultarCliente(Integer id);
    public void eliminarCliente(Integer id);
}
