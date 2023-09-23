package br.com.rm97465.obratech.repository;

import br.com.rm97465.obratech.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//<Entity, ID>
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
