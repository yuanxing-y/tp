package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TypicalOrder;

public class OrderTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Order(null));
    }
    @Test
    public void equals() {
        assertTrue(TypicalOrder.ASCENDING_ORDER.equals(TypicalOrder.ASCENDING_ORDER));
        assertTrue(TypicalOrder.ASCENDING_ORDER.equals(new Order("ascending")));
        assertTrue(TypicalOrder.DESCENDING_ORDER.equals(TypicalOrder.DESCENDING_ORDER));
        assertTrue(TypicalOrder.DESCENDING_ORDER.equals(new Order("descending")));

        assertFalse(TypicalOrder.DESCENDING_ORDER.equals(TypicalOrder.ASCENDING_ORDER));
        assertFalse(TypicalOrder.DESCENDING_ORDER.equals(new Order("ascending")));
        assertFalse(TypicalOrder.ASCENDING_ORDER.equals(new Order("descending")));
    }
}
