package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {

    private final CurriculoRepository curriculoRepository;
    private final CabecalhoRepository cabecalhoRepository;
    private final ExperienciaRepository experienciaRepository;
    private final FormacaoRepository formacaoRepository;
    private final HabilidadeRepository habilidadeRepository;

    @Autowired
    public CurriculoController(CurriculoRepository curriculoRepository, CabecalhoRepository cabecalhoRepository, ExperienciaRepository experienciaRepository, FormacaoRepository formacaoRepository, HabilidadeRepository habilidadeRepository) {
        this.curriculoRepository = curriculoRepository;
        this.cabecalhoRepository = cabecalhoRepository;
        this.experienciaRepository = experienciaRepository;
        this.formacaoRepository = formacaoRepository;
        this.habilidadeRepository = habilidadeRepository;
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Curriculo> listarCurriculos() {
        return curriculoRepository.findAll();
    }
      
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Optional<Curriculo> listarPedidoPorId(@PathVariable("id") Integer id) {
        return curriculoRepository.findById(id);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public Curriculo adicionarCurriculo(@RequestBody Curriculo curriculo) { 	
    	Curriculo novoCurriculo = curriculoRepository.save(curriculo);
        
        Cabecalho cabecalho = new Cabecalho();
        cabecalho.setName(cabecalho.getName());
        cabecalho.setIdade(cabecalho.getIdade());
        cabecalho.setCidade(cabecalho.getCidade());

        cabecalhoRepository.save(cabecalho);
        
        Experiencia experiencia = new Experiencia();
        experiencia.setCargo(experiencia.getCargo());
        experiencia.setData_inicio(experiencia.getData_inicio());
        experiencia.setData_fim(experiencia.getData_fim());
        experiencia.setDescricao(experiencia.getDescricao());

        experienciaRepository.save(experiencia);
        
        Formacao formacao = new Formacao();
        formacao.setCurso(formacao.getCurso());
        formacao.setData_inicio(formacao.getData_inicio());
        formacao.setData_fim(formacao.getData_fim());
        formacao.setDescricao(formacao.getDescricao());
        formacao.setLocal(formacao.getLocal());

        formacaoRepository.save(formacao);
        
        Habilidade habilidade = new Habilidade();
        habilidade.setNivel(habilidade.getNivel());
        habilidade.setDescricao(habilidade.getDescricao());

        habilidadeRepository.save(habilidade);

        return novoCurriculo;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Curriculo atualizarCurriculo(@PathVariable Integer id, @RequestBody Curriculo curriculoAtualizado) {
    	Curriculo curriculo = curriculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculo não encontrado com o ID: " + id));

        return curriculoRepository.save(curriculo);
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void excluirCurriculo(@PathVariable Integer id) {
    	Curriculo curriculo = curriculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculo não encontrado com o ID: " + id));

    	curriculoRepository.delete(curriculo);
    }
    
    
}
