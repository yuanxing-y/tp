package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class DescriptionTest {

    @Test
    public void constructor_invalidDescription_throwsIllegalArgumentException() {
        String invalidDescription = " ";
        assertThrows(IllegalArgumentException.class, () -> new Description(invalidDescription));
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Description(null));
    }

    @Test
    public void isValidDescription() {
        // null name
        assertThrows(NullPointerException.class, () -> Description.isValidDescription(null));

        // invalid name
        assertFalse(Description.isValidDescription(" ")); // space only
        assertFalse(Description.isValidDescription("      ")); // spaces only
        assertFalse(Description.isValidDescription(" hhh")); // begin with blank space
        assertFalse(Description.isValidDescription("      hhh")); // begin with blank spaces

        // valid description
        assertTrue(Description.isValidDescription("")); // empty string
        assertTrue(Description.isValidDescription("Some description."));
        assertTrue(Description.isValidDescription("bought jacket at Zara"));
        assertTrue(Description.isValidDescription("Bought logitech keyboard"));
        assertTrue(Description.isValidDescription("shopped at capital city"));
    }

}
