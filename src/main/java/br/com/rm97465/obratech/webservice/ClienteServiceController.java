package br.com.rm97465.obratech.webservice;

import br.com.rm97465.obratech.model.Cliente;
import br.com.rm97465.obratech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service/cliente")
public class ClienteServiceController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping ("cadastra")
    public Cliente insertCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @PutMapping("atualiza")
    public void updateCliente(@RequestBody Cliente cliente){
        
    }
    @GetMapping("lista")
    public List<Cliente> listCliente(){
        return clienteRepository.findAll();
    }
    @DeleteMapping ("deleta")
    public ResponseEntity deleteCliente (@PathVariable Integer id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
