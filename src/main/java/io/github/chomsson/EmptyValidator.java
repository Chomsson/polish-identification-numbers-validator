package io.github.chomsson;
/* created by PM
  at 07.10.2020 */

import java.util.Optional;

public class EmptyValidator implements Validator {
    @Override
    public Optional<ValidationResultState> validate(String input) {
        if (input == null || input.replaceAll("\\D+", "").isEmpty()) {
            return Optional.of(ValidationResultState.EMPTY_VALUE);
        }
        return Optional.empty();
    }
}
