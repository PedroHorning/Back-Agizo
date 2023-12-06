
package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacoesController {

    @Autowired
    private AvaliacoesRepository avaliacoesRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Avaliacoes> getAllAvaliacoes() {
        return avaliacoesRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{idusuario}")
    public List<Avaliacoes> getAvaliacoesByIdUsuario(@PathVariable Integer idusuario) {
        return avaliacoesRepository.findByidusuario(idusuario);
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Avaliacoes createAvaliacoes(@RequestBody Avaliacoes avaliacoes) { 
    	Avaliacoes savedAvaliacoes = avaliacoesRepository.save(avaliacoes);
        
        return savedAvaliacoes;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Avaliacoes Avaliacoes(@PathVariable Integer id, @RequestBody Avaliacoes avaliacoesData) {
    	Avaliacoes avaliacoes = avaliacoesRepository.findById(id).orElse(null);
        if (avaliacoes != null) {
        	avaliacoes.setAvaliacao(avaliacoesData.getAvaliacao());
        	avaliacoes.setIdrecrutador(avaliacoesData.getIdrecrutador());
        	avaliacoes.setIdusuario(avaliacoesData.getIdusuario());
        	avaliacoes.setComentarios(avaliacoesData.getComentarios());

            return avaliacoesRepository.save(avaliacoes);
        }
        return null;
    }


    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteAvaliacoes(@PathVariable Integer id) {
    	avaliacoesRepository.deleteById(id);
    }
}
