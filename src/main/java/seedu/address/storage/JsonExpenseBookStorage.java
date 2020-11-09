package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyExpenseBook;

/**
 * A class to access ExpenseBook data stored as a json file on the hard disk.
 */
public class JsonExpenseBookStorage implements ExpenseBookStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonExpenseBookStorage.class);

    private Path filePath;

    public JsonExpenseBookStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getExpenseBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyExpenseBook> readExpenseBook() throws DataConversionException {
        return readExpenseBook(filePath);
    }

    /**
     * Similar to {@link #readExpenseBook()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyExpenseBook> readExpenseBook(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableExpenseBook> jsonExpenseBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableExpenseBook.class);
        if (!jsonExpenseBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonExpenseBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveExpenseBook(ReadOnlyExpenseBook expenseBook) throws IOException {
        saveExpenseBook(expenseBook, filePath);
    }

    /**
     * Similar to {@link #saveExpenseBook(ReadOnlyExpenseBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveExpenseBook(ReadOnlyExpenseBook expenseBook, Path filePath) throws IOException {
        requireNonNull(expenseBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableExpenseBook(expenseBook), filePath);
    }

}
