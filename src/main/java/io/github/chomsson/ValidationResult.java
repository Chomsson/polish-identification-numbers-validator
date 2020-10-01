package io.github.chomsson;
/* created by PM
  at 28.09.2020 */

import java.util.HashSet;
import java.util.Set;

public class ValidationResult {

    private boolean valid;
    private Set<ValidationResultState> errorDescription = new HashSet<>() {
    };

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Set<ValidationResultState> getErrorDescription() {
        return errorDescription;
    }
}


