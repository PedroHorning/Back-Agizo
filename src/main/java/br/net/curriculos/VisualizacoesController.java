
package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visualizacoes")
public class VisualizacoesController {

    @Autowired
    private VisualizacoesRepository visualizacoesRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Visualizacoes> getAllVisualizacoes() {
        return visualizacoesRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{idusuario}")
    public List<Visualizacoes> getVisualizacoesByIdUsuario(@PathVariable Integer idusuario) {
        return visualizacoesRepository.findByidusuario(idusuario);
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Visualizacoes createVisualizacoes(@RequestBody Visualizacoes visualizacoes) { 
    	Visualizacoes savedVisualizacoes = visualizacoesRepository.save(visualizacoes);
        
        return savedVisualizacoes;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Visualizacoes Visualizacoes(@PathVariable Integer id, @RequestBody Visualizacoes visualizacoesData) {
    	Visualizacoes visualizacoes = visualizacoesRepository.findById(id).orElse(null);
        if (visualizacoes != null) {
        	visualizacoes.setQuantidade(visualizacoesData.getQuantidade());

            return visualizacoesRepository.save(visualizacoes);
        }
        return null;
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/incrementar-quantidade/{idusuario}")
    public ResponseEntity<String> incrementQuantityByIdUsuario(@PathVariable Integer idusuario) {
        try {
            visualizacoesRepository.incrementQuantityByIdusuario(idusuario);
            return ResponseEntity.ok("Quantidade incrementada com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incrementar a quantidade: " + e.getMessage());
        }
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteVisualizacoes(@PathVariable Integer id) {
    	visualizacoesRepository.deleteById(id);
    }
}
