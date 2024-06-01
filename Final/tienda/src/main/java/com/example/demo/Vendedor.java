package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "vendedores")
public class Vendedor {
    
    @Id
    private int id;
    private String cedula;
    private String nombre;
    
   @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<Cliente> clientes;

   public Vendedor() {
    clientes = new ArrayList<>();
   }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Vendedor [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + "]";
    }
    
   public List<Cliente> getClientes() {
        return clientes;
    }


   public void setProductos(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
