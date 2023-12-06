package br.net.curriculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumoRepository extends JpaRepository<Resumo, Integer> {
    
    @Query("SELECT c FROM Resumo c WHERE c.idusuario = :idusuario")
    List<Resumo> findByidusuario(Integer idusuario);
}
