package studio.thinkground.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import studio.thinkground.common.valid.FieldValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = FieldValidator.class)
public @interface ValidationAnnotation {
  String message() default "Invalid Value. It should be 'hellovalid'";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
