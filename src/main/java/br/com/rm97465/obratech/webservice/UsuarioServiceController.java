package br.com.rm97465.obratech.webservice;

import br.com.rm97465.obratech.model.Usuario;
import br.com.rm97465.obratech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service/usuario")
public class UsuarioServiceController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Usuario é o tipo do retorno
    //insertUsuario é o nome do método
    //() é o parâmetro do tipo Usuario e nome da referência
    @PostMapping("cadastra")
    public Usuario insertUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
