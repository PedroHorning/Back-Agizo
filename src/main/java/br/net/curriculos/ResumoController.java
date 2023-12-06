
package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resumo")
public class ResumoController {

    @Autowired
    private ResumoRepository resumoRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Resumo> getAllResumo() {
        return resumoRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{idusuario}")
    public List<Resumo> getResumoByIdUsuario(@PathVariable Integer idusuario) {
        return resumoRepository.findByidusuario(idusuario);
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Resumo createResumo(@RequestBody Resumo resumo) { 
    	Resumo savedResumo = resumoRepository.save(resumo);
        
        return savedResumo;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Resumo updateResumo(@PathVariable Integer id, @RequestBody Resumo resumoData) {
    	Resumo resumo = resumoRepository.findById(id).orElse(null);
        if (resumo != null) {
        	resumo.setDescricao(resumoData.getDescricao());
            resumo.setIdusuario(resumoData.getIdusuario());

            return resumoRepository.save(resumo);
        }
        return null;
    }


    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteResumo(@PathVariable Integer id) {
    	resumoRepository.deleteById(id);
    }
}
