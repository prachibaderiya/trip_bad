package com.prachiBaderiya.project.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class PositivePriceValidator implements
ConstraintValidator<PositivePrice, Double> {
@Override
public boolean isValid(Double value, ConstraintValidatorContext context) {
return value != null && value > 0;
}
}

