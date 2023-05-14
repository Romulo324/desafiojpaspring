package desafiospringjpa.springjpa.auth;
import desafiospringjpa.springjpa.user.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/registro")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.register(usuario));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(
            @RequestBody Usuario user
    ) {
        return ResponseEntity.ok(service.authenticate(user));
    }
}
