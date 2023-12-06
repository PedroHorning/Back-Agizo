package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/formacao")
public class FormacaoController {

    @Autowired
    private FormacaoRepository formacaoRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Formacao> getAllFormacoes() {
        return formacaoRepository.findAll();
    }

    @CrossOrigin(origins= "*")
    @GetMapping("/{idusuario}")
    public List<Formacao> getFormacaoByIdUsuario(@PathVariable Integer idusuario) {
        return formacaoRepository.findByidusuario(idusuario);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/geral")
    public List<String> getUniqueFormacao() {
    	List<String> uniqueFormacao = formacaoRepository.findUniqueFormacao();
        Collections.sort(uniqueFormacao);
        return uniqueFormacao;
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Formacao createFormacao(@RequestBody Formacao formacao) { 
    	Formacao savedFormacao = formacaoRepository.save(formacao);
        
        return savedFormacao;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Formacao updateFormacao(@PathVariable Integer id, @RequestBody Formacao formacaoData) {
    	Formacao formacao = formacaoRepository.findById(id).orElse(null);
        if (formacao != null) {
        	formacao.setCurso(formacaoData.getCurso());
        	formacao.setDatainicio(formacaoData.getDatainicio());
        	formacao.setDatafim(formacaoData.getDatafim());
        	formacao.setLocal(formacaoData.getLocal());
        	formacao.setIdusuario(formacaoData.getIdusuario());

            return formacaoRepository.save(formacao);
        }
        return null;
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteFormacao(@PathVariable Integer id) {
    	formacaoRepository.deleteById(id);
    }
}
