package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/habilidade")
public class HabilidadeController {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Habilidade> getAllHabilidades() {
        return habilidadeRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{idusuario}")
    public List<Habilidade> getHabilidadeByIdUsuario(@PathVariable Integer idusuario) {
        return habilidadeRepository.findByidusuario(idusuario);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/geral")
    public List<String> getUniqueHabilidades() {
    	List<String> uniqueHabilidades = habilidadeRepository.findUniqueHabilidade();
        Collections.sort(uniqueHabilidades);
        return uniqueHabilidades;
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Habilidade createHabilidade(@RequestBody Habilidade habilidade) { 
    	Habilidade savedHabilidade = habilidadeRepository.save(habilidade);
        
        return savedHabilidade;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Habilidade updateHabilidade(@PathVariable Integer id, @RequestBody Habilidade habilidadeData) {
    	Habilidade habilidade = habilidadeRepository.findById(id).orElse(null);
        if (habilidade != null) {
        	habilidade.setDescricao(habilidadeData.getDescricao());
        	habilidade.setNivel(habilidadeData.getNivel());

            return habilidadeRepository.save(habilidade);
        }
        return null;
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteHabilidade(@PathVariable Integer id) {
    	habilidadeRepository.deleteById(id);
    }
}
