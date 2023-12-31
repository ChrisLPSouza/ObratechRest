package br.com.rm97465.obratech.repository;

import br.com.rm97465.obratech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository chama uma instância do banco
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
