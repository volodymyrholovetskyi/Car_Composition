package com.holovetskyi.carcomposition.validate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface Validator<T> {

    Log LOG = LogFactory.getLog(Validator.class.getName());

    Map<String, String> validate(T t);

    static <T> boolean validate(Validator<T> validator, T t) {
        var errors = validator.validate(t);
        LOG.warn(errors
                .entrySet()
                .stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining("\n")));
        return errors.isEmpty();
    }

    static boolean hasCapitalLetter(String expression, String regex) {
        return expression.matches(regex);
    }

    static boolean isPositiveDecimal(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }

    static boolean isPositiveLong(long value) {
        return value > 0;
    }

    static boolean isPositiveDouble(double value) {
        return value > 0;
    }

    static boolean isPositiveInteger(double value) {
        return value > 0;
    }

    static boolean hasEveryItemCapitalLetter(List<String> items, String regex) {
        return items.stream().allMatch(item -> item.matches(regex));
    }
}
