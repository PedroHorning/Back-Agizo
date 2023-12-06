package br.net.curriculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabecalhoRepository extends JpaRepository<Cabecalho, Integer> {
    
    @Query("SELECT c FROM Cabecalho c WHERE c.idusuario = :idusuario")
    List<Cabecalho> findByidusuario(Integer idusuario);
    
    @Query("SELECT DISTINCT CONCAT(UPPER(SUBSTRING(c.cidade, 1, 1)), LOWER(SUBSTRING(c.cidade, 2))) FROM Cabecalho c")
    List<String> findUniqueCities();
    
    @Query("SELECT DISTINCT CONCAT(UPPER(SUBSTRING(c.estado, 1, 1)), UPPER(SUBSTRING(c.estado, 2))) FROM Cabecalho c")
    List<String> findUniqueEstados();
}
