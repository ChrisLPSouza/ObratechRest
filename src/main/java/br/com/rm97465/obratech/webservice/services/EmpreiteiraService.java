package br.com.rm97465.obratech.webservice.services;

import br.com.rm97465.obratech.model.Cliente;
import br.com.rm97465.obratech.model.Empreiteira;
import br.com.rm97465.obratech.repository.EmpreiteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmpreiteiraService {
    @Autowired
    private final EmpreiteiraRepository empreiteiraRepository;

    public EmpreiteiraService(EmpreiteiraRepository empreiteiraRepository) {
        this.empreiteiraRepository = empreiteiraRepository;
    }

    @Transactional
    public String cadastraEmpreiteira(Empreiteira empreiteira) {
        String mensagem = "";
        if(this.empreiteiraRepository.findById(empreiteira.getId()).isPresent()){
            mensagem = "Já existe uma empreiteira com esse número de id, tente novamente";
        } else {
            this.empreiteiraRepository.save(empreiteira);
            mensagem = "Empreiteira cadastrada com sucesso";
        }
        return mensagem;
    }

    @Transactional
    public String atualizaEmpreiteira(Empreiteira empreiteira){
        String mensagem = "";
        if(this.empreiteiraRepository.findById(empreiteira.getId()).isPresent()){
            this.empreiteiraRepository.save(empreiteira);
            mensagem = "Empreiteira atualizada com sucesso";
        } else {
            mensagem = "Não foi encontrado nenhuma empreiteira com esse número de id, tente novamente";
        }
        return mensagem;
    }

    @Transactional
    public List<Empreiteira> listaEmpreiteira() {
        return this.empreiteiraRepository.findAll();
    }

    @Transactional
    public ResponseEntity<String> deletaEmpreiteiraPorId(Integer id) {
        if (this.empreiteiraRepository.existsById(id)){
            this.empreiteiraRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
