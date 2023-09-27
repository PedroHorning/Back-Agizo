package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Experiencia> getAllExperiencias() {
        return experienciaRepository.findAll();
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Experiencia createExperiencia(@RequestBody Experiencia experiencia) { 
    	Experiencia savedExperiencia = experienciaRepository.save(experiencia);
        
        return savedExperiencia;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Experiencia updateExperiencia(@PathVariable Integer id, @RequestBody Experiencia experienciaData) {
    	Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        if (experiencia != null) {
        	experiencia.setCargo(experienciaData.getCargo());
        	experiencia.setData_inicio(experienciaData.getData_inicio());
        	experiencia.setData_fim(experienciaData.getData_fim());
        	experiencia.setDescricao(experienciaData.getDescricao());

            return experienciaRepository.save(experiencia);
        }
        return null;
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteExperiencia(@PathVariable Integer id) {
    	experienciaRepository.deleteById(id);
    }
}
