package br.com.rm97465.obratech.webservice;

import br.com.rm97465.obratech.model.Empreiteira;
import br.com.rm97465.obratech.repository.EmpreiteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service/empreiteira")
public class EmpreiteiraServiceController {
    @Autowired
    private EmpreiteiraRepository empreiteiraRepository;

    @PostMapping("cadastra")
    public Empreiteira insertEmpreiteira(@RequestBody Empreiteira empreiteira){
        return empreiteiraRepository.save(empreiteira);
    }
    @PutMapping("atualiza")
    public void updateEmpreiteira(@RequestBody Empreiteira empreiteira) {
    }
    @GetMapping("lista")
    public ResponseEntity listEmpreiteira(){
        List<Empreiteira> lista = empreiteiraRepository.findAll();
        if (lista.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("deleta")
    public ResponseEntity deleteEmpreiteira(@PathVariable Integer id){
        if (empreiteiraRepository.existsById(id)){
            empreiteiraRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
