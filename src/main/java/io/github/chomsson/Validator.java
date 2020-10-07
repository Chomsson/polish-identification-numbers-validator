package io.github.chomsson;

import java.util.Optional;

public interface Validator {
    public Optional<ValidationResultState> validate(String input);
}
