package br.net.curriculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Integer>{
	@Query("SELECT c FROM Formacao c WHERE c.idusuario = :idusuario")
    List<Formacao> findByidusuario(Integer idusuario);
	
	@Query("SELECT DISTINCT CONCAT(UPPER(SUBSTRING(c.curso, 1, 1)), LOWER(SUBSTRING(c.curso, 2))) FROM Formacao c")
    List<String> findUniqueFormacao();
}
