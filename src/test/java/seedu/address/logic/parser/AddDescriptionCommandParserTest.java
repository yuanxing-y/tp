package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_EXPENSE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddDescriptionCommand;
import seedu.address.model.expense.Description;

class AddDescriptionCommandParserTest {
    private AddDescriptionCommandParser parser = new AddDescriptionCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        assertParseSuccess(parser, "1" + " d/dummy description", new AddDescriptionCommand(INDEX_FIRST_EXPENSE,
                new Description("dummy description")));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        assertParseFailure(parser, "d/dummy description", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, AddDescriptionCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "a" + "d/dummy description", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, AddDescriptionCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_missingField_failure() {
        assertParseFailure(parser, "1", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, AddDescriptionCommand.MESSAGE_ADD_DESCRIPTION_PREDIX_MISSING));
    }

}
