package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SortByTimeCommand;
import seedu.address.testutil.TypicalOrder;

public class SortByTimeCommandParserTest {
    private SortByTimeCommandParser parser = new SortByTimeCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        String userInput1 = "descending";

        assertParseSuccess(parser, userInput1, new SortByTimeCommand(TypicalOrder.DESCENDING_ORDER));

        String userInput2 = "ascending";

        assertParseSuccess(parser, userInput2, new SortByTimeCommand(TypicalOrder.ASCENDING_ORDER));
    }

}
