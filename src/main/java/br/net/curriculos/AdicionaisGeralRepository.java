package br.net.curriculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionaisGeralRepository extends JpaRepository<AdicionaisGeral, Integer> {
	
	@Query("SELECT c FROM AdicionaisGeral c WHERE c.id = :id")
    List<AdicionaisGeral> findByid(Integer id);		 
}
