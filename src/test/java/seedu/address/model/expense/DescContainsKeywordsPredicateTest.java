package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ExpenseBuilder;

public class DescContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        DescContainsKeywordsPredicate firstPredicate =
                new DescContainsKeywordsPredicate(firstPredicateKeywordList);
        DescContainsKeywordsPredicate secondPredicate =
                new DescContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        DescContainsKeywordsPredicate firstPredicateCopy =
                new DescContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different expenses -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_descContainsKeywords_returnsTrue() {
        // One keyword
        DescContainsKeywordsPredicate predicate =
                new DescContainsKeywordsPredicate(Collections.singletonList("mcd"));
        assertTrue(predicate.test(new ExpenseBuilder().withDescription("mcd").build()));

        // Multiple keywords
        predicate = new DescContainsKeywordsPredicate(Arrays.asList("mcd", "kfc"));
        assertTrue(predicate.test(new ExpenseBuilder().withDescription("mcd kfc").build()));

        // Only one matching keyword
        predicate = new DescContainsKeywordsPredicate(Arrays.asList("mcd", "burgerking"));
        assertTrue(predicate.test(new ExpenseBuilder().withDescription("mcd").build()));

        // Mixed-case keywords
        predicate = new DescContainsKeywordsPredicate(Arrays.asList("McD", "kFc"));
        assertTrue(predicate.test(new ExpenseBuilder().withDescription("mcd kfc").build()));
    }

    @Test
    public void test_descDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        DescContainsKeywordsPredicate predicate =
                new DescContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new ExpenseBuilder().withDescription("mcd").build()));

        // Non-matching keyword
        predicate = new DescContainsKeywordsPredicate(Arrays.asList("mcd"));
        assertFalse(predicate.test(new ExpenseBuilder().withDescription("kfc").build()));

        // Keywords match category but does not match desc
        predicate = new DescContainsKeywordsPredicate(Arrays.asList("food"));
        assertFalse(predicate.test(new ExpenseBuilder().withCategory("food").withDescription("mcd").build()));
    }
}
