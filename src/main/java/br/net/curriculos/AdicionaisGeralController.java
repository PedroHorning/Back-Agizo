package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adicionaisgeral")
public class AdicionaisGeralController {
	@Autowired
    private AdicionaisGeralRepository adicionaisgeralRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<AdicionaisGeral> getAllAdicionaisGeral() {
        return adicionaisgeralRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{id}")
    public List<AdicionaisGeral> getAdicionaisGeralById(@PathVariable Integer id) {
        return adicionaisgeralRepository.findByid(id);
    }
    
    @CrossOrigin(origins= "*")
    @PostMapping
    public AdicionaisGeral createAdicionaisGeral(@RequestBody AdicionaisGeral adicionaisgeral) { 
    	AdicionaisGeral savedAdicionaisGeral = adicionaisgeralRepository.save(adicionaisgeral);
        
        return savedAdicionaisGeral;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public AdicionaisGeral AdicionaisGeral(@PathVariable Integer id, @RequestBody AdicionaisGeral adicionaisgeralData) {
    	AdicionaisGeral adicionaisgeral = adicionaisgeralRepository.findById(id).orElse(null);
        if (adicionaisgeral != null) {
        	adicionaisgeral.setDescricao(adicionaisgeralData.getDescricao());

            return adicionaisgeralRepository.save(adicionaisgeral);
        }
        return null;
    }


    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteAdicionaisGeral(@PathVariable Integer id) {
    	adicionaisgeralRepository.deleteById(id);
    }
}
