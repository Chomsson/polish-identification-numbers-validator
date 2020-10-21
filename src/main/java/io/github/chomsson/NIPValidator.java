package io.github.chomsson;
/* created by PM
  at 28.09.2020 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Class for NIP validation
 */

public class NIPValidator extends BaseValidator {
    private final List<Validator> myList = Arrays.asList(
            new EmptyValidator(),
            new IllegalCharValidator(),
            new IncorrectSizeValidator(),
            new IncorrectCheckSumValidator()
    );

    /**
     * @param nip
     * @return result of validation:
     *      <br/>VALID - is valid,
     *      <br/>ILLEGAL_CHARACTER - at least one character isn't a number, dash or space,
     *      <br/>INCORRECT_SIZE - length of input is different from 10,
     *      <br/>INCORRECT_CHECKSUM - invalid checksum, one or more digits are wrong,
     *      <br/>EMPTY_VALUE - input is null or empty string.
     */
    public ValidationResultState validate(String nip) {

        return myList.stream()
                .map(e -> e.validate(nip))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(ValidationResultState.VALID);

    }
}

