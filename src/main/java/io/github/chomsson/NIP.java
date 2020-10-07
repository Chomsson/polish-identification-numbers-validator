package io.github.chomsson;
/* created by PM
  at 28.09.2020 */

public class NIP {
    private String nip;

    public NIP(String nip) {
        this.nip = nip;
    }

    public ValidationResultState validate() {


        return new EmptyValidator().validate(nip).
                or(() -> new IllegalCharValidator().validate(nip)).
                or(() -> new IncorrectSizeValidator().validate(nip)).
                or(() -> new IncorrectCheckSumValidator().validate(nip)).
                orElse(ValidationResultState.VALID);


    }


    public boolean isValid() {
        return validate().equals(ValidationResultState.VALID);
    }


}

