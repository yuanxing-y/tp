package seedu.address.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

public class HelpCommandWindow extends UiPart<Stage> {
    private static final String FXML = "HelpCommandWindow.fxml";

    private TableView<CommandList> tableView = new TableView<>();
    private final Logger logger = LogsCenter.getLogger(HelpCommandWindow.class);

    private TableColumn command = new TableColumn("command");
    private TableColumn commandUsage = new TableColumn("usage");
    private TableColumn commandFormat = new TableColumn("format");
    private TableColumn commandExample = new TableColumn("example");

    private ObservableList<CommandList> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private Label helpCommandWindow;

    /**
     * Creates a new SupportedCurrencyTable.
     *
     * @param root Stage to use as the root of the StatisticsWindow.
     */
    public HelpCommandWindow(Stage root) {
        super(FXML, root);
        helpCommandWindow.setGraphic(tableView);
        helpCommandWindow.setMinWidth(1205);
        helpCommandWindow.setMinHeight(530);

        getRoot().addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.Q == event.getCode()) {
                getRoot().hide();
            }
        });

    }

    /**
     * Creates a new SupportedCurrencyTable.
     */
    public HelpCommandWindow() {
        this(new Stage());
    }

    /**
     * Constructs the supported currency table.
     */
    public void constructTable() {
        command.setCellValueFactory(new PropertyValueFactory<>("command"));
        commandUsage.setCellValueFactory(new PropertyValueFactory<>("usage"));
        commandFormat.setCellValueFactory(new PropertyValueFactory<>("format"));
        commandExample.setCellValueFactory(new PropertyValueFactory<>("example"));
        List<CommandList> listOfCommand = CommandList.getComandList();
        for (int i = 0; i < listOfCommand.size(); i = i + 1) {
            list.add(listOfCommand.get(i));
        }
        tableView.setItems(list);
        tableView.getColumns().addAll(command, commandUsage, commandFormat, commandExample);
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
        logger.fine("Showing command currency exchange rates!");
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
