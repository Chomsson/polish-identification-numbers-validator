package io.github.chomsson;
/* created by PM
  at 28.09.2020 */

public class NIP {
    private String nip;

    public NIP(String nip) {
        this.nip = nip;
    }

    public ValidationResult validate() {



        if (nip == null || nip.isEmpty()) {
            ValidationResult validationResult = new ValidationResult();
            validationResult.getErrorDescription().add(ValidationResultState.INCORRECT_SIZE);
            return validationResult;
        } else if (!nip.matches("[0-9/s-]*")) {
            ValidationResult validationResult = new ValidationResult();
            validationResult.getErrorDescription().add(ValidationResultState.ILLEGAL_CHARACTER);
            return validationResult;
        } else if (nip.length() != 10) {
            ValidationResult validationResult = new ValidationResult();
            validationResult.getErrorDescription().add(ValidationResultState.INCORRECT_SIZE);
            return validationResult;
        } else if (!checkSum(nip)){
            ValidationResult validationResult = new ValidationResult();
            validationResult.getErrorDescription().add(ValidationResultState.INCORRECT_CHECKSUM);
            return validationResult;
        }
        else{
            ValidationResult validationResult = new ValidationResult();
            validationResult.getErrorDescription().add(ValidationResultState.VALID);
            return validationResult;
        }


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
        return validate().getErrorDescription().contains(ValidationResultState.VALID);
    }


}

