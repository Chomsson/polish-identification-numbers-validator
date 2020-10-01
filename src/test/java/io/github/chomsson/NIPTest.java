package io.github.chomsson;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class NIPTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "529-511-65-27", "759 002 56 99",
            "798 145-53 17", "--1545745884",
            "  1245387972 ", " 9719701238",
            "9786053689 ", "1250786025-",
            "-7971250447-", "3372332579"
    })
    public void test_validate(String input) {
        NIP nip = new NIP(input);
        ValidationResult result = nip.validate();
        assertThat(result.getErrorDescription(), is(equalTo(ValidationResultState.VALID)));
        assertTrue(nip.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "52951sa527", "75d0025699", 
            "79gfd55317", "1545jh5884", 
            "12asd87972", "sss9701238", 
            "978tyjk689", "1250[o]025", 
            "797;;'0447", "337a's2579"
    })
    public void test_incorrectChars(String input) {
        NIP nip = new NIP(input);
        ValidationResult result = nip.validate();
        assertThat(result.getErrorDescription(), is(equalTo(ValidationResultState.ILLEGAL_CHARACTER)));
        assertFalse(nip.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "52951527", "7590099",
            "798145317", "45884",
            "127972", "9738",
            "9783689", "12786025",
            "797125447", "332579"})
    public void test_size(String input) {
        NIP nip = new NIP(input);
        ValidationResult result = nip.validate();
        assertThat(result.getErrorDescription(), is(equalTo(ValidationResultState.INCORRECT_SIZE)));
        assertFalse(nip.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "5295116526", "7590025697",
            "7981455314", "1545745883",
            "1245387971", "9719701236",
            "9786053687", "1250786027",
            "7971250446", "3372332576"})
    public void test_checkSum(String input) {
        NIP nip = new NIP(input);
        ValidationResult result = nip.validate();
        assertThat(result.getErrorDescription(), is(equalTo(ValidationResultState.INCORRECT_CHECKSUM)));
        assertFalse(nip.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "----"})
    void test_null(String input) {
        NIP nip = new NIP(input);
        ValidationResult result = nip.validate();
        assertThat(result.getErrorDescription(), is(equalTo(ValidationResultState.EMPTY_VALUE)));
        assertFalse(nip.isValid());
    }
}