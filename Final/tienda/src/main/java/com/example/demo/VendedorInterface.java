package com.example.demo;

import java.util.List;

public interface VendedorInterface {
    public void guardar(Vendedor vendedor);
    public List<Vendedor> listado();
    public Vendedor consultar(Integer id);
    public void eliminar(Integer id);
}
