package seedu.address.ui;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private ExpenseListPanel expenseListPanel;
    private ResultDisplay resultDisplay;
    private HelpWindow helpWindow;
    private PieChartWindow pieChartWindow;
    private CurrencyExchangeTable currencyExchangeTable;
    private SupportedCurrencyTable supportedCurrencyTable;
    private StatisticTable statisticTable;
    private HelpCommandWindow helpCommandWindow;
    private BudgetPanel budgetPanel;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private StackPane expenseListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statusbarPlaceholder;

    @FXML
    private StackPane budgetPlaceholder;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        primaryStage.setMinWidth(600);

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());
        helpWindow = new HelpWindow();
        pieChartWindow = new PieChartWindow(logic);
        currencyExchangeTable = new CurrencyExchangeTable();
        supportedCurrencyTable = new SupportedCurrencyTable();
        statisticTable = new StatisticTable(logic);
        helpCommandWindow = new HelpCommandWindow();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


    /**
     * Sets the accelerator of a MenuItem.
     * @param keyCombination the KeyCombination value of the accelerator
     */
    private void setAccelerator(MenuItem menuItem, KeyCombination keyCombination) {
        menuItem.setAccelerator(keyCombination);

        /*
         * TODO: the code below can be removed once the bug reported here
         * https://bugs.openjdk.java.net/browse/JDK-8131666
         * is fixed in later version of SDK.
         *
         * According to the bug report, TextInputControl (TextField, TextArea) will
         * consume function-key events. Because CommandBox contains a TextField, and
         * ResultDisplay contains a TextArea, thus some accelerators (e.g F1) will
         * not work when the focus is in them because the key event is consumed by
         * the TextInputControl(s).
         *
         * For now, we add following event filter to capture such key events and open
         * help window purposely so to support accelerators even when focus is
         * in CommandBox or ResultDisplay.
         */
        getRoot().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getTarget() instanceof TextInputControl && keyCombination.match(event)) {
                menuItem.getOnAction().handle(new ActionEvent());
                event.consume();
            }
        });
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        expenseListPanel = new ExpenseListPanel(logic.getFilteredExpenseList());

        expenseListPanelPlaceholder
                .getChildren()
                .add(
                        expenseListPanel
                                .getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        StatusBarFooter statusBarFooter = new StatusBarFooter(logic.getExpenseBookFilePath());
        statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());

        budgetPanel = new BudgetPanel(logic);
        budgetPlaceholder.getChildren().add(budgetPanel.getRoot());
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelpCommandWindow() {
        if (!helpCommandWindow.isShowing()) {
            helpCommandWindow = new HelpCommandWindow();
            helpCommandWindow.show();
        } else {
            helpCommandWindow = new HelpCommandWindow();
            helpCommandWindow.focus();
        }
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void showCurrencyExchangeRateTable() {
        if (!currencyExchangeTable.isShowing()) {
            currencyExchangeTable = new CurrencyExchangeTable();
            currencyExchangeTable.show();
        } else {
            currencyExchangeTable = new CurrencyExchangeTable();
            currencyExchangeTable.focus();
        }
    }

    /**
     * Opens the Supported Currency Table or focuses on it if it's already opened.
     */
    @FXML
    public void showSupportedCurrencyTable() {
        if (!supportedCurrencyTable.isShowing()) {
            supportedCurrencyTable = new SupportedCurrencyTable();
            supportedCurrencyTable.show();
        } else {
            supportedCurrencyTable = new SupportedCurrencyTable();
            supportedCurrencyTable.focus();
        }
    }

    /**
     * Opens the Pie chart window or focuses on it if it's already opened.
     */
    @FXML
    public void handleStatistics() {
        if (!pieChartWindow.isShowing()) {
            pieChartWindow.show();

        } else {
            pieChartWindow.focus();
        }
    }

    /**
     * Opens the Statistic Table or focuses on it if it's already opened.
     */
    @FXML
    public void handleStatisticTable() {
        if (!statisticTable.isShowing()) {
            statisticTable = new StatisticTable(logic);
            statisticTable.show();

        } else {
            statisticTable = new StatisticTable(logic);
            statisticTable.focus();
        }
    }

    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        logic.setGuiSettings(guiSettings);
        helpWindow.hide();
        primaryStage.hide();
        pieChartWindow.hide();
        statisticTable.hide();
        currencyExchangeTable.hide();
        supportedCurrencyTable.hide();
        helpCommandWindow.hide();
    }

    public ExpenseListPanel getExpenseListPanel() {
        return expenseListPanel;
    }

    public BudgetPanel getBudgetPanel() {
        return budgetPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.address.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());
            budgetPanel.update();
            pieChartWindow.setStats();

            if (commandResult.isShowHelp()) {
                handleHelpCommandWindow();
                handleHelp();
            }

            if (commandResult.isShowStatistics()) {
                handleStatistics();
            }

            if (commandResult.isShowStatisticTable()) {
                System.out.println("show");
                handleStatisticTable();
            }

            if (commandResult.isShowCurrencies()) {
                showSupportedCurrencyTable();
            }

            if (commandResult.isShowRates()) {
                showCurrencyExchangeRateTable();
            }

            if (commandResult.isExit()) {
                handleExit();
            }

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}
