package br.net.curriculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface VisualizacoesRepository extends JpaRepository<Visualizacoes, Integer> {
	@Query("SELECT c FROM Visualizacoes c WHERE c.idusuario = :idusuario")
    List<Visualizacoes> findByidusuario(Integer idusuario);
	
	@Modifying
    @Transactional
    @Query("UPDATE Visualizacoes v SET v.quantidade = v.quantidade + 1 WHERE v.idusuario = :idusuario")
    void incrementQuantityByIdusuario(@Param("idusuario") Integer idusuario);
}
