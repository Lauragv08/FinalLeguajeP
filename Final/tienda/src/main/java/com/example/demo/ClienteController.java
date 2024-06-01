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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    private ClienteInterface ClienteServicio;
    @Autowired
    private VendedorInterface VendedorServicio;

    @GetMapping(value = "/clienteInsertar")

    public String clienteInsertar(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("mensaje", "Nuevo cliente");
        return "clienteInsertar";
    }

    @ModelAttribute("vendedor")
    public List<Vendedor> datosVendedor() {
        return VendedorServicio.listado();
    }

    @PostMapping("/insertarCliente")
    public String insertarCliente(@ModelAttribute(name = "cliente") Cliente cliente, Model model,
            SessionStatus status) {
        ClienteServicio.guardarCliente(cliente);
        status.setComplete();
        return "redirect:/clienteListar";
    }

    @GetMapping("/clienteListar")
    public String clienteListar(Model model) {
        List<Cliente> cliente = ClienteServicio.listadoCliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("mensaje", "Listado clientes");
        return "clienteListar";
    }

    @GetMapping("/consultarCliente/{id}")
    public String consultar(@PathVariable(name="id") Integer id, Model model){
        Cliente cliente = ClienteServicio.consultarCliente(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("mensaje", "Consultar");
        return "redirect:/clienteListar";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminar(@PathVariable(name="id") Integer id, Model model){
        Cliente cliente = ClienteServicio.consultarCliente(id);
        ClienteServicio.eliminarCliente(id);
        return "redirect:/clienteListar";
    }
    @GetMapping("/modificarCliente/{id}")
    public String modificar(@PathVariable(name="id") Integer id, Model model){
        Cliente cliente = ClienteServicio.consultarCliente(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("mensaje", "Consultar");
        return "clienteInsertar";
    }


}