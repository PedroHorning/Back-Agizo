package br.net.curriculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaAtuacaoRepository extends JpaRepository<AreaAtuacao, Integer> {
	
	@Query("SELECT c FROM AreaAtuacao c WHERE c.id = :id")
    List<AreaAtuacao> findByid(Integer id);		 
}
