package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SortByAmountCommand;
import seedu.address.testutil.TypicalOrder;

public class SortByAmountCommandParserTest {
    private SortByAmountCommandParser parser = new SortByAmountCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        String userInput1 = "descending";

        assertParseSuccess(parser, userInput1, new SortByAmountCommand(TypicalOrder.DESCENDING_ORDER));

        String userInput2 = "ascending";

        assertParseSuccess(parser, userInput2, new SortByAmountCommand(TypicalOrder.ASCENDING_ORDER));
    }

}
