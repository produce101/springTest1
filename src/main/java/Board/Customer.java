package Board;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.awt.*;

public class Customer implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        System.out.println("되용??");
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("되냐고요??");
    }


}
