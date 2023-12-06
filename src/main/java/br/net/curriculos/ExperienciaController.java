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
    @GetMapping("/{idusuario}")
    public List<Experiencia> getExperienciaByIdUsuario(@PathVariable Integer idusuario) {
        return experienciaRepository.findByidusuario(idusuario);
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Experiencia createExperiencia(@RequestBody Experiencia experiencia) {
    	System.out.println("Data inicial" + experiencia.getDataInicio());
    	Experiencia savedExperiencia = experienciaRepository.save(experiencia);
        
        return savedExperiencia;
    }

    @PutMapping("/{id}")
    public Experiencia updateExperiencia(@PathVariable Integer id, @RequestBody Experiencia experienciaData) {
        Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        if (experiencia != null) {
            experiencia.setCargo(experienciaData.getCargo());
            experiencia.setDataInicio(experienciaData.getDataInicio());
            experiencia.setDataFim(experienciaData.getDataFim());
            experiencia.setDescricao(experienciaData.getDescricao());
            experiencia.setLocal(experienciaData.getLocal());
            experiencia.setIdusuario(experienciaData.getIdusuario());

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
