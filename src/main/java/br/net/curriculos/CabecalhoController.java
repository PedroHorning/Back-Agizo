
package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;
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
    @GetMapping("/{idusuario}")
    public List<Cabecalho> getCabecalhosByIdUsuario(@PathVariable Integer idusuario) {
        return cabecalhoRepository.findByidusuario(idusuario);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/cidades")
    public List<String> getUniqueCities() {
    	List<String> uniqueCities = cabecalhoRepository.findUniqueCities();
        Collections.sort(uniqueCities);
        return uniqueCities;
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/estados")
    public List<String> getUniqueEstado() {
    	List<String> uniqueEstados = cabecalhoRepository.findUniqueEstados();
        Collections.sort(uniqueEstados);
        return uniqueEstados;
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
            cabecalho.setName(cabecalhoData.getName());
            cabecalho.setTelefone(cabecalhoData.getTelefone());
            cabecalho.setEmail(cabecalhoData.getEmail());
            cabecalho.setCidade(cabecalhoData.getCidade());
            cabecalho.setEstado(cabecalhoData.getEstado());
            cabecalho.setCargo(cabecalhoData.getCargo());
            cabecalho.setIdusuario(cabecalhoData.getIdusuario());

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
