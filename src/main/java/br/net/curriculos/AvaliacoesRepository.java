package br.net.curriculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Integer> {
    
    @Query("SELECT c FROM Avaliacoes c WHERE c.idusuario = :idusuario")
    List<Avaliacoes> findByidusuario(Integer idusuario);
}
