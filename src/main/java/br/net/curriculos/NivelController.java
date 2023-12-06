package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nivel")
public class NivelController {
	@Autowired
    private NivelRepository nivelRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Nivel> getAllNivel() {
        return nivelRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{id}")
    public List<Nivel> getNivelById(@PathVariable Integer id) {
        return nivelRepository.findByid(id);
    }
    
    @CrossOrigin(origins= "*")
    @PostMapping
    public Nivel createNivel(@RequestBody Nivel nivel) { 
    	Nivel savedNivel = nivelRepository.save(nivel);
        
        return savedNivel;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Nivel Nivel(@PathVariable Integer id, @RequestBody Nivel nivelData) {
    	Nivel nivel = nivelRepository.findById(id).orElse(null);
        if (nivel != null) {
        	nivel.setNivel(nivelData.getNivel());

            return nivelRepository.save(nivel);
        }
        return null;
    }


    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteNivel(@PathVariable Integer id) {
    	nivelRepository.deleteById(id);
    }
}
