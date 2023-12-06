package br.net.curriculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Integer> {
	
	@Query("SELECT c FROM Nivel c WHERE c.id = :id")
    List<Nivel> findByid(Integer id);		 
}
