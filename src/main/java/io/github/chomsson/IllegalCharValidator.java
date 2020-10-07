package io.github.chomsson;
/* created by PM
  at 07.10.2020 */

import java.util.Optional;

public class IllegalCharValidator implements Validator {
    @Override
    public Optional<ValidationResultState> validate(String input) {
        if (!input.matches("[0-9\\s-]*")) {
            return Optional.of(ValidationResultState.ILLEGAL_CHARACTER);
        }
        return Optional.empty();
    }
}
