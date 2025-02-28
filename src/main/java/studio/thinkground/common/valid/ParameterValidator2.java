package studio.thinkground.common.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import studio.thinkground.common.annotation.ValidationAnnotation2;

public class ParameterValidator2 implements ConstraintValidator<ValidationAnnotation2, String> {
    @Override
    public void initialize(ValidationAnnotation2 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return value!= null && value.equals("validtest");
    }
}
