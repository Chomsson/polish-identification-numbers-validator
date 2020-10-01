package io.github.chomsson;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class NIPTest {

    @Test
    public void test_isValid() {

        boolean result = new NIP("0000000000").isValid();
        assertTrue(result);
    }

    @Test
    public void test_validate() {
        NIP nip1 = new NIP("0000000000");

        ValidationResult result = nip1.validate();
        assertEquals(result.getErrorDescription().size(), 1);
        assertThat(result.getErrorDescription(), CoreMatchers.hasItem(ValidationResultState.VALID));
        assertTrue(nip1.isValid());
    }

    @Test
    public void test_incorrectChars() {
        ValidationResult result = new NIP("12345ghgh990").validate();
        assertFalse(result.isValid());
        assertThat(result.getErrorDescription(), CoreMatchers.hasItem(ValidationResultState.ILLEGAL_CHARACTER));
    }

    @Test
    public void test_size() {
        ValidationResult result = new NIP("1234567").validate();
        assertFalse(result.isValid());
        assertThat(result.getErrorDescription(), CoreMatchers.hasItem(ValidationResultState.INCORRECT_SIZE));

    }

    @Test
    public void test_checkSum() {
        ValidationResult result = new NIP("1234567890").validate();
        assertFalse(result.isValid());
        assertThat(result.getErrorDescription(), CoreMatchers.hasItem(ValidationResultState.INCORRECT_CHECKSUM));
    }
}