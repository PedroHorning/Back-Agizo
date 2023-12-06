package br.net.curriculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdicionaisRepository extends JpaRepository<Adicionais, Integer> {
    
    @Query("SELECT c FROM Adicionais c WHERE c.idusuario = :idusuario")
    List<Adicionais> findByidusuario(Integer idusuario);
}
