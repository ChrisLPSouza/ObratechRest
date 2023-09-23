package br.com.rm97465.obratech.repository;

import br.com.rm97465.obratech.model.Empreiteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpreiteiraRepository extends JpaRepository<Empreiteira, Integer> {
}
