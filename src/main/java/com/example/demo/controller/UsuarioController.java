package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping
@AllArgsConstructor
public class UsuarioController {
	
	@Autowired
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder encoder;
	
	public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;	
	}
	
		@GetMapping("/api/usuario/listarTodos")
		public ResponseEntity <List<Usuario>> listarTodos(){
			return ResponseEntity.ok(usuarioRepository.findAll());
		};
		
		@PostMapping("/api/usuario/salvar")
		public ResponseEntity<Usuario> salvar(@RequestBody @Validated Usuario usuario){
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			return ResponseEntity.ok(usuarioRepository.save(usuario));
		}
		
		@CrossOrigin(origins = "*", allowedHeaders = "*")
		@PostMapping("/api/usuario/validarSenha")
	    public ResponseEntity<Boolean> validarSenha(@RequestParam String usuario,
	                                                @RequestParam String senha) {

	        Optional<Usuario> optUsuario = usuarioRepository.findByUsuario(usuario);
	        if (optUsuario.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	        }

	        Usuario usuario2 = optUsuario.get();
	        boolean valid = encoder.matches(senha, usuario2.getSenha());

	        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
	        return ResponseEntity.status(status).body(valid);

	    }
}
