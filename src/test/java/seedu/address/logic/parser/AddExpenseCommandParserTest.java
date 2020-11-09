package seedu.address.logic.parser;

//import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.AMOUNT_DESC_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.AMOUNT_DESC_MOVIE;
import static seedu.address.logic.commands.CommandTestUtil.CATEGORY_DESC_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.CATEGORY_DESC_MOVIE;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_MOVIE;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_MOVIE;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_AMOUNT_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_MOVIE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_MOVIE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_MOVIE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BOOKS;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_MOVIE;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddExpenseCommand;
//import seedu.address.model.expense.Amount;
//import seedu.address.model.expense.Category;
//import seedu.address.model.expense.CategoryContainsKeywordsPredicate;
//import seedu.address.model.expense.Date;
//import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;
//import seedu.address.model.expense.UniqueExpenseList;
import seedu.address.testutil.ExpenseBuilder;

public class AddExpenseCommandParserTest {
    private AddExpenseCommandParser parser = new AddExpenseCommandParser();


    @Test
    public void parse_allFieldsPresent_success() {
        ExpenseBuilder aliceAmountAndCategory = new ExpenseBuilder().withAmount(20.0).withCategory("study");
        Expense expectedPerson = aliceAmountAndCategory.withDate("1").withDescription("Bought textbook").build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + AMOUNT_DESC_BOOKS + CATEGORY_DESC_BOOKS + DATE_DESC_BOOKS
                + DESCRIPTION_DESC_BOOKS, new AddExpenseCommand(expectedPerson));
    }
}
