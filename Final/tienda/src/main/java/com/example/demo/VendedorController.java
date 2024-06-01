package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("vendedor")
public class VendedorController {
    @Autowired
    private VendedorInterface VendedorServicio;

    @GetMapping(value = "/vendedorInsertar")
    public String vendedorInsertar(Model model) {
        Vendedor vendedor = new Vendedor();
        model.addAttribute("vendedor", vendedor);
        model.addAttribute("mensaje", "Nueva Vendedor");

        return "vendedorInsertar";
    }

    @PostMapping("/insertar")
    public String insertar(@ModelAttribute(name = "vendedor") Vendedor vendedor, Model model, SessionStatus status) {
        VendedorServicio.guardar(vendedor);
        status.setComplete();
        return "redirect:/vendedorListar";
    }

    @GetMapping("/vendedorListar")
    public String vendedor(Model model) {
        List<Vendedor> vendedor = VendedorServicio.listado();
        model.addAttribute("vendedor",vendedor);
        model.addAttribute("mensaje","Listado");
        return "/vendedorListar";
    }

    @GetMapping("/consultar/{id}")
    public String consultar(@PathVariable(name="id")Integer id, Model model){
        Vendedor vendedor = VendedorServicio.consultar(id);
        model.addAttribute("vendedor", vendedor);
        model.addAttribute("mensaje", "consultar");
        return "redirect:/vendedorListar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(name="id")Integer id, Model model){
        Vendedor vendedor = VendedorServicio.consultar(id);
        VendedorServicio.eliminar(id);
        return "redirect:/vendedorListar";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable(name="id")Integer id, Model model){
        Vendedor vendedor = VendedorServicio.consultar(id);
        model.addAttribute("vendedor", vendedor);
        model.addAttribute("mensaje", "modificar");
        return "vendedorInsertar";
    }






}

