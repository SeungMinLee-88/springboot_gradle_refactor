package studio.thinkground.common.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import studio.thinkground.common.annotation.ValidationAnnotation;

public class FieldValidator implements ConstraintValidator<ValidationAnnotation, String> {
    @Override
    public void initialize(ValidationAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.equals("hellovalid");
    }

    /*@Override
    public boolean isValid(String value, ConstraintValidator context) {
        return value != null && value.equals("hello");
    }*/
}
