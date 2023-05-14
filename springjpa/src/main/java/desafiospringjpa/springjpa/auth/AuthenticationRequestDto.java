package desafiospringjpa.springjpa.auth;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequestDto {

    private String primeiroNome;

    private String password;

}
