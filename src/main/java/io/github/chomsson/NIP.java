package io.github.chomsson;
/* created by PM
  at 28.09.2020 */

public class NIP {
    private String nip;

    public NIP(String nip) {
        this.nip = nip;
    }

    public ValidationResult validate() {


        if (nip.replaceAll("\\D+","") == null || nip.replaceAll("\\D+","").isEmpty()) {
            return createResult(ValidationResultState.EMPTY_VALUE);
        } else if (!nip.matches("[0-9\\s-]*")) {
            return createResult(ValidationResultState.ILLEGAL_CHARACTER);
        } else if (nip.replaceAll("\\D+","").length() != 10) {
            return createResult(ValidationResultState.INCORRECT_SIZE);
        } else if (!checkSum(nip.replaceAll("\\D+",""))) {
            return createResult(ValidationResultState.INCORRECT_CHECKSUM);
        } else {
            return createResult(ValidationResultState.VALID);
        }
    }

    private ValidationResult createResult(ValidationResultState validationResultState) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setErrorDescription(validationResultState);

        return validationResult;
    }

    private boolean checkSum(String nip) {
        int[] wages = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        int sum = 0;

        for (int i = 0; i < wages.length; i++) {
            sum += wages[i] * Character.getNumericValue(nip.charAt(i));
        }

        return sum % 11 == Character.getNumericValue(nip.charAt(9));
    }

    public boolean isValid() {
        return validate().getErrorDescription().equals(ValidationResultState.VALID);
    }


}

