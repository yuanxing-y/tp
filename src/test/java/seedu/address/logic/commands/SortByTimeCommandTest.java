package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TypicalOrder;

public class SortByTimeCommandTest {
    @Test
    public void equals() {
        SortByTimeCommand sortByTimeCommandDescending =
                new SortByTimeCommand(TypicalOrder.DESCENDING_ORDER);

        SortByTimeCommand sortByTimeCommandDescendingCopy =
                new SortByTimeCommand(TypicalOrder.DESCENDING_ORDER);

        SortByTimeCommand sortByTimeCommandAscending =
                new SortByTimeCommand(TypicalOrder.ASCENDING_ORDER);

        SortByTimeCommand sortByTimeCommandAscendingCopy =
                new SortByTimeCommand(TypicalOrder.ASCENDING_ORDER);

        // same object -> returns true
        assertTrue(sortByTimeCommandAscending.equals(sortByTimeCommandAscending));

        // same object -> returns true
        assertTrue(sortByTimeCommandDescending.equals(sortByTimeCommandDescending));

        // same values -> returns true
        assertTrue(sortByTimeCommandAscending.equals(sortByTimeCommandAscendingCopy));

        assertTrue(sortByTimeCommandDescending.equals(sortByTimeCommandDescendingCopy));

        // different types -> returns false
        assertFalse(sortByTimeCommandAscending.equals(1));

        // null -> returns false
        assertFalse(sortByTimeCommandDescending.equals(null));

        // different person -> returns false
        assertFalse(sortByTimeCommandAscending.equals(sortByTimeCommandDescending));
    }

}
