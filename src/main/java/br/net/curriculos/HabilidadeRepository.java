package br.net.curriculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Integer>{
	
	@Query("SELECT c FROM Habilidade c WHERE c.idusuario = :idusuario")
    List<Habilidade> findByidusuario(Integer idusuario);
	
	@Query("SELECT DISTINCT CONCAT(UPPER(SUBSTRING(c.descricao, 1, 1)), LOWER(SUBSTRING(c.descricao, 2))) FROM Habilidade c")
    List<String> findUniqueHabilidade();
}
