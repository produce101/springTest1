package auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller("passwordEncoder")
public class CustomNoOpPasswordEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence rawPassword) {

        System.out.println("비포 인코더 :" + rawPassword);

        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.out.println("matches: " + rawPassword + ":" + encodedPassword);
        return rawPassword.toString().equals(encodedPassword);
    }
}
