package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_EXPENSE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddDescriptionCommand;
import seedu.address.logic.commands.CurrenciesCommand;
import seedu.address.logic.commands.DeleteExpenseCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.RatesCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Description;

public class ExpenseBookParserTest {

    private final ExpenseBookParser parser = new ExpenseBookParser();

    @Test
    public void parseCommand_description() throws Exception {
        final Description description = new Description("Some description.");
        AddDescriptionCommand command = (AddDescriptionCommand) parser.parseCommand(
                AddDescriptionCommand.COMMAND_WORD + " "
                        + INDEX_FIRST_EXPENSE.getOneBased() + " " + PREFIX_DESCRIPTION + description.value);
        assertEquals(new AddDescriptionCommand(INDEX_FIRST_EXPENSE, description), command);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        DeleteExpenseCommand command = (DeleteExpenseCommand) parser.parseCommand(
                DeleteExpenseCommand.COMMAND_WORD + " " + INDEX_FIRST_EXPENSE.getOneBased());
        assertEquals(new DeleteExpenseCommand(INDEX_FIRST_EXPENSE), command);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_rates() throws Exception {
        assertTrue(parser.parseCommand(RatesCommand.COMMAND_WORD) instanceof RatesCommand);
        assertTrue(parser.parseCommand(RatesCommand.COMMAND_WORD + " 3") instanceof RatesCommand);
    }

    @Test
    public void parseCommand_codes() throws Exception {
        assertTrue(parser.parseCommand(CurrenciesCommand.COMMAND_WORD) instanceof CurrenciesCommand);
        assertTrue(parser.parseCommand(CurrenciesCommand.COMMAND_WORD + " 3") instanceof CurrenciesCommand);
    }

    @Test
    public void parseCommand_view() throws Exception {
        assertTrue(parser.parseCommand(ViewCommand.COMMAND_WORD + " 3") instanceof ViewCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                HelpCommand.MESSAGE_USAGE), () -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}
