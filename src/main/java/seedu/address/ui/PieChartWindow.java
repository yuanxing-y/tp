package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.Statistics;


public class PieChartWindow extends UiPart<Stage> {

    public static final String MESSAGE = "Statistics is shown on the left";
    private static final PieChart PIECHART = new PieChart();
    private static final Logger logger = LogsCenter.getLogger(PieChartWindow.class);
    private static final String FXML = "PieChartWindow.fxml";

    private static boolean hasStats = false;

    private Logic logic;

    private ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private Button copyButton;

    @FXML
    private Label statistics;

    /**
     * Creates a new StatisticsWindow.
     *
     * @param root Stage to use as the root of the StatisticsWindow.
     */
    public PieChartWindow(Stage root) {
        super(FXML, root);
        statistics.setGraphicTextGap(20.0);
        statistics.setGraphic(PIECHART);
        //statistics.setGraphic(tableView);

        getRoot().addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.Q == event.getCode()) {
                getRoot().hide();
            }
        });
    }

    /**
     * Creates a new PieChartWindow.
     */
    public PieChartWindow() {
        this(new Stage());
    }

    /**
     * Constructs a pie chart window object.
     *
     * @param logic Takes in a logic object.
     */
    public PieChartWindow(Logic logic) {
        this(new Stage());
        this.logic = logic;
        hasStats = true;
    }

    public void setStats() {
        if (hasStats) {

            Statistics data = logic.getExpenseBook().getStatistics();

            list = data.getCategoryAmountPercenatgePieCharStatistics();

            PIECHART.setData(list);
            PIECHART.setLegendSide(Side.LEFT);
            PIECHART.setTitle("Statistics of Expense Book");
            PIECHART.setClockwise(false);
            PIECHART.setLabelsVisible(true);

        }

    }


    /**
     * Shows the help window.
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
        this.setStats();
        logger.fine("Showing statistics page about the application.");
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
