package Services.impl;

import Services.PasswordEncodingService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPasswordEncodingServiceImpl implements PasswordEncodingService {

    private static int workload = 11;

    @Override
    public String encode(CharSequence charSequence) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(charSequence.toString(), salt);

        return (hashed_password);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        boolean password_verified;

        if (null == s || !s.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(charSequence.toString(), s);

        return (password_verified);
    }
}
