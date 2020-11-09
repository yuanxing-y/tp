package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TypicalOrder;

public class SortByAmountCommandTest {
    @Test
    public void equals() {
        SortByAmountCommand sortByAmountCommandDescending =
                new SortByAmountCommand(TypicalOrder.DESCENDING_ORDER);

        SortByAmountCommand sortByAmountCommandDescendingCopy =
                new SortByAmountCommand(TypicalOrder.DESCENDING_ORDER);

        SortByAmountCommand sortByAmountCommandAscending =
                new SortByAmountCommand(TypicalOrder.ASCENDING_ORDER);

        SortByAmountCommand sortByAmountCommandAscendingCopy =
                new SortByAmountCommand(TypicalOrder.ASCENDING_ORDER);

        // same object -> returns true
        assertTrue(sortByAmountCommandAscending.equals(sortByAmountCommandAscending));

        // same object -> returns true
        assertTrue(sortByAmountCommandDescending.equals(sortByAmountCommandDescending));

        // same values -> returns true
        assertTrue(sortByAmountCommandAscending.equals(sortByAmountCommandAscendingCopy));

        assertTrue(sortByAmountCommandDescending.equals(sortByAmountCommandDescendingCopy));

        // different types -> returns false
        assertFalse(sortByAmountCommandAscending.equals(1));

        // null -> returns false
        assertFalse(sortByAmountCommandDescending.equals(null));

        // different person -> returns false
        assertFalse(sortByAmountCommandAscending.equals(sortByAmountCommandDescending));
    }

}
