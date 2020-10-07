package io.github.chomsson;
/* created by PM
  at 07.10.2020 */

import java.util.Optional;

public class IncorrectCheckSumValidator implements Validator {
    @Override
    public Optional<ValidationResultState> validate(String input) {

        if (!checkSum(input.replaceAll("\\D+", ""))) {
            return Optional.of(ValidationResultState.INCORRECT_CHECKSUM);
        }
        return Optional.empty();
    }
    public boolean checkSum(String nip) {
        int[] wages = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        int sum = 0;

        for (int i = 0; i < wages.length; i++) {
            sum += wages[i] * Character.getNumericValue(nip.charAt(i));
        }

        return sum % 11 == Character.getNumericValue(nip.charAt(9));
    }
}
