package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cabecalho")
public class CabecalhoController {

    @Autowired
    private CabecalhoRepository cabecalhoRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Cabecalho> getAllCabecalhos() {
        return cabecalhoRepository.findAll();
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Cabecalho createCabecalho(@RequestBody Cabecalho cabecalho) { 
        Cabecalho savedCabecalho = cabecalhoRepository.save(cabecalho);
        
        return savedCabecalho;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Cabecalho updateCabecalho(@PathVariable Integer id, @RequestBody Cabecalho cabecalhoData) {
        Cabecalho cabecalho = cabecalhoRepository.findById(id).orElse(null);
        if (cabecalho != null) {
        	cabecalho.setIdade(cabecalhoData.getIdade());
        	cabecalho.setName(cabecalhoData.getName());
        	cabecalho.setCidade(cabecalhoData.getCidade());

            return cabecalhoRepository.save(cabecalho);
        }
        return null;
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteCabecalho(@PathVariable Integer id) {
    	cabecalhoRepository.deleteById(id);
    }
}
