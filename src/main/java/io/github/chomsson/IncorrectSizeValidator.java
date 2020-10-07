package io.github.chomsson;
/* created by PM
  at 07.10.2020 */

import java.util.Optional;

public class IncorrectSizeValidator implements Validator {
    @Override
    public Optional<ValidationResultState> validate(String input) {
        if (input.replaceAll("\\D+", "").length() != 10) {
            return Optional.of(ValidationResultState.VALID);
        }
        return Optional.empty();
    }
}
