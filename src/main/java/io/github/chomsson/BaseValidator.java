package io.github.chomsson;
/* created by PM
  at 21.10.2020 */

public abstract class BaseValidator {
    public abstract ValidationResultState validate(String input);

    public boolean isValid(String input) {
        return validate(input).equals(ValidationResultState.VALID);
    }
}
