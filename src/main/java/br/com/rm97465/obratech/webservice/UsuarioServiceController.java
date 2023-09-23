package br.com.rm97465.obratech.webservice;

import br.com.rm97465.obratech.model.Usuario;
import br.com.rm97465.obratech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service/usuario")
public class UsuarioServiceController {
    //@Autowired o Spring vai instanciar o repository automaticamente
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Usuario é o tipo do retorno
    //insertUsuario é o nome do método
    //() é o parâmetro do tipo Usuario e nome da referência
    @PostMapping("cadastra")
    public Usuario insertUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    //@RequestBody representa um objeto com várias informações
   @PutMapping("atualiza")
    public void updateUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
    @GetMapping("lista")
    public List<Usuario> listUsuario() {
        return usuarioRepository.findAll();
    }


    //nome do parâmetro id tem que ser igual do método
    @DeleteMapping("deleta/{id}")
    public ResponseEntity deleteUsuario(@PathVariable Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
