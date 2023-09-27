package br.net.curriculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabecalhoRepository extends JpaRepository<Cabecalho, Integer>{
	
}
