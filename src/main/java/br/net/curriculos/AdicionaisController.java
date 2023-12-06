
package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adicionais")
public class AdicionaisController {

    @Autowired
    private AdicionaisRepository adicionalRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Adicionais> getAllAdicionais() {
        return adicionalRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{idusuario}")
    public List<Adicionais> getAdicionaisByIdUsuario(@PathVariable Integer idusuario) {
        return adicionalRepository.findByidusuario(idusuario);
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Adicionais createAdicionais(@RequestBody Adicionais adicionais) { 
    	Adicionais savedAdicionais = adicionalRepository.save(adicionais);
        
        return savedAdicionais;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Adicionais Adicionais(@PathVariable Integer id, @RequestBody Adicionais adicionaisData) {
    	Adicionais adicionais = adicionalRepository.findById(id).orElse(null);
        if (adicionais != null) {
        	adicionais.setTitulo(adicionaisData.getTitulo());
        	adicionais.setDescricao(adicionaisData.getDescricao());
            adicionais.setData(adicionaisData.getData());
            adicionais.setIdusuario(adicionaisData.getIdusuario());

            return adicionalRepository.save(adicionais);
        }
        return null;
    }


    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteAdicionais(@PathVariable Integer id) {
    	adicionalRepository.deleteById(id);
    }
}
