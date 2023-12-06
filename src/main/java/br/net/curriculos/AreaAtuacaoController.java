package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/areaatuacao")
public class AreaAtuacaoController {
	@Autowired
    private AreaAtuacaoRepository areaatuacaoRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<AreaAtuacao> getAllAreaAtuacao() {
        return areaatuacaoRepository.findAll();
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/{id}")
    public List<AreaAtuacao> getAreaAtuacaoById(@PathVariable Integer id) {
        return areaatuacaoRepository.findByid(id);
    }
    
    @CrossOrigin(origins= "*")
    @PostMapping
    public AreaAtuacao createAreaAtuacao(@RequestBody AreaAtuacao areaatuacao) { 
    	AreaAtuacao savedAreaAtuacao = areaatuacaoRepository.save(areaatuacao);
        
        return savedAreaAtuacao;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public AreaAtuacao AreaAtuacao(@PathVariable Integer id, @RequestBody AreaAtuacao areaatuacaoData) {
    	AreaAtuacao areaatuacao = areaatuacaoRepository.findById(id).orElse(null);
        if (areaatuacao != null) {
        	areaatuacao.setDescricao(areaatuacaoData.getDescricao());

            return areaatuacaoRepository.save(areaatuacao);
        }
        return null;
    }


    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteAreaAtuacao(@PathVariable Integer id) {
    	areaatuacaoRepository.deleteById(id);
    }
}
