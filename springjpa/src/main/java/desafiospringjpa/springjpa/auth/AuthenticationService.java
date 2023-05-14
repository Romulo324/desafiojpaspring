package desafiospringjpa.springjpa.auth;

import desafiospringjpa.springjpa.config.JwtService;
import desafiospringjpa.springjpa.repositories.UserRepository;
import desafiospringjpa.springjpa.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private  AuthenticationManager authenticationManager;

    public AuthenticationResponseDto register(Usuario usuario) {
        var user = Usuario.builder()
                .nomeDoUsuario(usuario.getNomeDoUsuario())
                .senhaDoUsuario(passwordEncoder.encode(usuario.getPassword()))
                .build();
        repository.save(usuario);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponseDto authenticate(Usuario usuario) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuario.getNomeDoUsuario(),
                        usuario.getPassword()
                )
        );
        var user = repository.findByNomeDoUsuario(usuario.getNomeDoUsuario())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }
}
