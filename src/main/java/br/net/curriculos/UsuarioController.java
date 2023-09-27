package br.net.curriculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin(origins= "*")
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @CrossOrigin(origins= "*")
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/login/")
    public Usuario getUsuarioByEmail(@RequestParam String email, @RequestParam String password) {
        return usuarioRepository.findByEmail(email);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/cliente/")
    public List<Usuario> getUsuariosByProfile() {
        return usuarioRepository.findByProfile("cliente");
    }
    
    private String gerarSenhaAleatoria() {
        SecureRandom random = new SecureRandom();
        int senhaNumerica = random.nextInt(10000); 
        return String.format("%04d", senhaNumerica); 
    }

    private String gerarSenhaHash(String senha) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            byte[] senhaComSalt = concatBytes(senha.getBytes(), salt);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senhaComSalt);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha", e);
        }
    }

    private byte[] concatBytes(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    @CrossOrigin(origins= "*")
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        String senhaHash = gerarSenhaHash(usuario.getPassword());
        usuario.setPassword(senhaHash);
        
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
            usuario.setProfile(usuarioData.getProfile());

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
