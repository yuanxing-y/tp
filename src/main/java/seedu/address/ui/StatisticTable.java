package seedu.address.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.StatisticSummary;

public class StatisticTable extends UiPart<Stage> {

    private static final String FXML = "StatisticTable.fxml";
    private static boolean hasStats = false;

    private TableView<StatisticSummary> tableView = new TableView<>();
    private final Logger logger = LogsCenter.getLogger(StatisticTable.class);

    private Logic logic;

    private TableColumn category = new TableColumn("Category");
    private TableColumn numberOfExpense = new TableColumn("Number of Expenses");
    private TableColumn percentage = new TableColumn("Percentage(%)");
    private TableColumn totalSpending = new TableColumn("Total Spending($)");

    private ObservableList<StatisticSummary> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private Button copyButton;
    @FXML
    private Label statisticTable;

    /**
     * Creates a new CurrencyExchangeTable.
     *
     * @param root Stage to use as the root of the StatisticsWindow.
     */
    public StatisticTable (Stage root) {
        super(FXML, root);
        statisticTable.setGraphicTextGap(20.0);
        statisticTable.setGraphic(tableView);
        statisticTable.setMinWidth(428);

        getRoot().addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.Q == event.getCode()) {
                getRoot().hide();
            }
        }
        );
    }

    /**
     * Constructs a pie chart window object.
     *
     * @param logic Takes in a logic object.
     */
    public StatisticTable(Logic logic) {

        this(new Stage());
        this.logic = logic;
        hasStats = true;
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        numberOfExpense.setCellValueFactory(new PropertyValueFactory<>("numberOfExpense"));
        percentage.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        totalSpending.setCellValueFactory(new PropertyValueFactory<>("totalSpending"));
        constructTable();
    }

    /**
     * Creates a new HelpWindow.
     */
    public StatisticTable() {
        this(new Stage());
    }

    /**
     * Constructs the exchange rate table.
     */
    public void constructTable() {
        if (hasStats) {
            ObservableList<StatisticSummary> list = FXCollections.observableArrayList();
            List<StatisticSummary> statisticSummaryList = logic.getExpenseBook().getStatisticTable();
            for (int i = 0; i < statisticSummaryList.size(); i = i + 1) {
                list.add(statisticSummaryList.get(i));
            }
            tableView.setItems(list);
            tableView.getColumns().addAll(category, numberOfExpense, percentage, totalSpending);
        }
    }

    /**
     * Shows the currency exchange rate table window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        constructTable();
        logger.fine("Showing brief summary of the spending!");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

}
