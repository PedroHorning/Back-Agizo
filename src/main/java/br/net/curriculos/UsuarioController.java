package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @CrossOrigin(origins= "*")
    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String password) {
        Usuario user = usuarioRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            // Adicione logging para verificar o usuário retornado
            System.out.println("Usuário encontrado: " + user.toString());
            return user;
        } else {
            // Adicione logging para verificar se o usuário não foi encontrado ou se a senha está incorreta
            System.out.println("Usuário não encontrado ou senha incorreta para o email: " + email);
            return null;
        }
    }
   

    @CrossOrigin(origins= "*")
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.save(usuario);
        
        return savedUsuario;
    }

    @CrossOrigin(origins= "*")
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioData) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setName(usuarioData.getName());
            usuario.setEmail(usuarioData.getEmail());
            usuario.setPassword(usuarioData.getPassword());
            usuario.setTipo(usuarioData.getTipo());

            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @CrossOrigin(origins= "*")
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}
