package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** Help information should be shown to the user. */
    private final boolean showHelpCommandWindow;

    /** The application should exit. */
    private final boolean exit;

    /** Statistic information should be shown to the user. */
    private final boolean showStatistics;

    private final boolean showStatisticTable;

    /** Supported currencies should be shown to the user. */
    private final boolean showCurrencies;

    /** Reference exchange rates should be shown to the user. */
    private final boolean showRates;


    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showStatistics = false;
        this.showStatisticTable = false;
        this.showHelpCommandWindow = false;
        this.showCurrencies = false;
        this.showRates = false;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean showStatistics) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showStatistics = showStatistics;
        this.showStatisticTable = false;
        this.showHelpCommandWindow = false;
        this.showCurrencies = false;
        this.showRates = false;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit,
                         boolean showStatistics, boolean showStatisticTable) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showStatistics = showStatistics;
        this.showStatisticTable = showStatisticTable;
        this.showHelpCommandWindow = showHelp;
        this.showCurrencies = false;
        this.showRates = false;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit,
                         boolean showStatistics, boolean showStatisticTable,
                         boolean showCurrencies, boolean showRates) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showStatistics = showStatistics;
        this.showStatisticTable = showStatisticTable;
        this.showHelpCommandWindow = showHelp;
        this.showCurrencies = showCurrencies;
        this.showRates = showRates;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false, false);
    }

    /**
     * Return the feedback to the user
     */
    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    /**
     * To check whether there is a need to show the help window.
     * Return true if the user requests for the help window and false otherwise.
     */
    public boolean isShowHelp() {
        return showHelp;
    }

    /**
     * To check whether there is a need to show the help window.
     * Return true if the user requests for the help window and false otherwise.
     */
    public boolean isShowHelpCommandWindow() {
        return showHelpCommandWindow;
    }

    /**
     * To check whether there is a need to show the statistic window.
     * Return true if the user requests for the statistic window and false otherwise.
     */
    public boolean isShowStatistics() {
        return showStatistics;
    }

    /**
     * To check whether there is a need to show the statistic table.
     * Return true if the user requests for the statistic table and false otherwise.
     */
    public boolean isShowStatisticTable() {
        return showStatisticTable;
    }

    public boolean isShowCurrencies() {
        return this.showCurrencies;
    }

    public boolean isShowRates() {
        return this.showRates;
    }
    /**
     * To check whether user want to exit the application.
     * Return true if the user wants to exit the application and false otherwise.
     */
    public boolean isExit() {
        return exit;
    }


    /**
     * Checks if two command results are equal.
     * @param other Another object.
     * @return Whether the 2 command result objects are equal or not. Return true if they are equal and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit);
    }

}
