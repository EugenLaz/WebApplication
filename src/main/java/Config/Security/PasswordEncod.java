package Config.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class PasswordEncod implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        System.out.println(charSequence);
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println(s);
        return s.equals(charSequence);
    }
}
