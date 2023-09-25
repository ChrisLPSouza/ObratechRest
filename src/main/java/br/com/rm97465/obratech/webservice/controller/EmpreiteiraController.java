package br.com.rm97465.obratech.webservice.controller;

import br.com.rm97465.obratech.model.Empreiteira;
import br.com.rm97465.obratech.repository.EmpreiteiraRepository;
import br.com.rm97465.obratech.webservice.services.EmpreiteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empreiteira")
public class EmpreiteiraController {
    @Autowired
    private EmpreiteiraService empreiteiraService;

    @GetMapping
    public List<Empreiteira> listEmpreiteira(){
        return empreiteiraService.listaEmpreiteira();
    }

    @PostMapping("cadastra")
    public String insertEmpreiteira(@RequestBody Empreiteira empreiteira){
        return empreiteiraService.cadastraEmpreiteira(empreiteira);
    }
    @PutMapping("atualiza")
    public String updateEmpreiteira(@RequestBody Empreiteira empreiteira) {
        return empreiteiraService.atualizaEmpreiteira(empreiteira);
    }

    @DeleteMapping("deleta/{id}")
    public ResponseEntity deleteEmpreiteira(@PathVariable Integer id) {
        return empreiteiraService.deletaEmpreiteiraPorId(id);
    }
}
