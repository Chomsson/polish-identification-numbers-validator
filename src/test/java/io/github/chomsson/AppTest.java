package io.github.chomsson;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest
{

    ValidationResultState valid = ValidationResultState.VALID;

    @Test
    public void isValid(){
        if (valid.equals(ValidationResultState.VALID))
            System.out.println("NIP prawidlowy");
        else
            System.out.println("NIP nieprawidlowy");
    }
}
