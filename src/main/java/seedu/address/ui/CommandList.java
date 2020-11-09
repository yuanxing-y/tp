package seedu.address.ui;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    public static final String ADD_EXPENSE = "ADD EXPENSE COMMAND";
    public static final String ADD_EXPENSE_USAGE = "ADD expense, date and time filed are optional";
    public static final String ADD_EXPENSE_FORMAT = "add a/AMOUNT c/CATEGORY [t/DATE] [d/DESCRIPTION]";
    public static final String ADD_EXPENSE_EXAMPLE = "add a/50 c/ENTERTAINMENT t/1 d/movie";
    public static final String LIST_EXPENSE = "LIST EXPENSE COMMAND";
    public static final String LIST_EXPENSE_USAGE = "LIST all expenses";
    public static final String LIST_EXPENSE_FORMAT = "list";
    public static final String LIST_EXPENSE_EXAMPLE = "list";
    public static final String DELETE = "DELETE";
    public static final String DELETE_USAGE = "delete a specified expense";
    public static final String DELETE_FORMAT = "delete INDEX";
    public static final String DELETE_EXAMPLE = "delete 2";
    public static final String VIEW = "VIEW";
    public static final String VIEW_USAGE = "view a specified expense";
    public static final String VIEW_FORMAT = "view INDEX";
    public static final String VIEW_EXAMPLE = "view 2";
    public static final String VIEW_CATEGORY = "VIEW CATEGORIES";
    public static final String VIEW_CATEGORY_USAGE = "view all the categories";
    public static final String VIEW_CATEGORY_FORMAT = "view-c";
    public static final String VIEW_CATEGORY_EXAMPLE = "view-c";
    public static final String ADD_DESCRIPTION = "ADD DESCRIPTION";
    public static final String ADD_DESCRIPTION_USAGE = "add a description to an expense";
    public static final String ADD_DESCRIPTION_FORMAT = "add-d INDEX D/DESCRIPTION";
    public static final String ADD_DESCRIPTION_EXAMPLE = "add-d 3 d/movies";
    public static final String DELETE_DESCRIPTION = "DELETE DESCRIPTION";
    public static final String DELETE_DESCRIPTION_USAGE = "delete a description of an expense";
    public static final String DELETE_DESCRIPTION_FORMAT = "delete-d INDEX";
    public static final String DELETE_DESCRIPTION_EXAMPLE = "delete-d 6";
    public static final String SET_BUDGET = "SET BUDGET";
    public static final String SET_BUDGET_USAGE = "set the budget";
    public static final String SET_BUDGET_FORMAT = "set-b AMOUNT";
    public static final String SET_BUDGET_EXAMPLE = "set-b 500.0";
    public static final String EXIT = "EXIT";
    public static final String EXIT_USAGE = "exit from the application";
    public static final String EXIT_FORMAT = "exit";
    public static final String EXIT_EXAMPLE = "exit";
    public static final String SHOW_STATISTIC = "SHOW STATISTIC";
    public static final String SHOW_STATISTIC_USAGE = "show an overview of your expenses";
    public static final String SHOW_STATISTIC_FORMAT = "show-stats";
    public static final String SHOW_STATISTIC_EXAMPLE = "show-stats";
    public static final String SORT_BY_AMOUNT = "SORT BY AMOUNT";
    public static final String SORT_BY_TIME = "SORT BY TIME";
    public static final String SORT_BY_AMOUNT_USAGE = "sort expenses by amount in ascending/descending order";
    public static final String SORT_BY_TIME_USAGE = "sort expenses by time in ascending/descending order";
    public static final String SORT_BY_AMOUNT_FORMAT = "sort-a ORDER";
    public static final String SORT_BY_TIME_FORMAT = "sort-t ORDER";
    public static final String SORT_BY_AMOUNT_EXAMPLE = "sort-a ascending";
    public static final String SORT_BY_TIME_EXAMPLE = "sort-t descending";
    public static final String FILTER_BY_DESCRIPTION = "FILTER BY DESCRIPTION";
    public static final String FILTER_BY_DESCRIPTION_USAGE = "filter the expenses by keywords in description";
    public static final String FILTER_BY_DESCRIPTION_FORMAT = "filter-d KEYWORD";
    public static final String FILTER_BY_DESCRIPTION_EXAMPLE = "filter-d movie";
    public static final String FILTER_BY_CATEGORY = "FILTER BY CATEGORY";
    public static final String FILTER_BY_CATEGORY_USAGE = "Show all the expenses "
            + "whose category match the specified category";
    public static final String FILTER_BY_CATEGORY_FORMAT = "filter-c CATEGORY";
    public static final String FILTER_BY_CATEGORY_EXAMPLE = "filter-c entertainment";
    public static final String FILTER_BY_DATE = "FILTER BY DATE";
    public static final String FILTER_BY_DATE_USAGE = "filter the expenses by date";
    public static final String FILTER_BY_DATE_FORMAT = "filter-t YYYY-MM-DD";
    public static final String FILTER_BY_DATE_EXAMPLE = "filter-t 2020-11-02";
    public static final String HELP = "HELP";
    public static final String HELP_USAGE = "look for help when using the app";
    public static final String HELP_FORMAT = "help";
    public static final String HELP_EXAMPLE = "help";
    public static final String CLEAR = "CLEAR";
    public static final String CLEAR_USAGE = "Clear all the data in the program";
    public static final String CLEAR_FORMAT = "clear";
    public static final String CLEAR_EXAMPLE = "clear";
    public static final String EDIT = "EDIT";
    public static final String EDIT_USAGE = "Edits the expense at the specified INDEX";
    public static final String EDIT_FORMAT = "edit INDEX [a/AMOUNT] [c/CATEGORY] [t/DATE] [d/DESCRIPTION] ";
    public static final String EDIT_EXAMPLE = "edit 1 a/12";
    public static final String EXCHANGE_CURRENCY = "EXCHANGE";
    public static final String EXCHANGE_CURRENCY_USAGE = "Convert current currency to currency of input currency code";
    public static final String EXCHANGE_CURRENCY_FORMAT = "exchange cc/CURRENCY_CODE";
    public static final String EXCHANGE_CURRENCY_EXAMPLE = "exchange cc/CNY";
    public static final String SHOW_CURRENCY_CODE = "SHOW CURRENCY CODE";
    public static final String SHOW_CURRENCY_CODE_USAGE = "Show a full list of supported currencies and their codes";
    public static final String SHOW_CURRENCY_CODE_FORMAT = "show-codes";
    public static final String SHOW_CURRENCY_CODE_EXAMPLE = "show-codes";
    private final String command;
    private final String usage;
    private final String format;
    private final String example;
    protected CommandList(String command, String usage, String format, String example) {
        this.command = command;
        this.usage = usage;
        this.format = format;
        this.example = example;
    }
    public String getCommand() {
        return this.command;
    }
    public String getUsage() {
        return this.usage;
    }
    public String getFormat() {
        return this.format;
    }
    public String getExample() {
        return this.example;
    }
    public static List<CommandList> getComandList() {
        List<CommandList> list = new ArrayList<>();
        CommandList addCommand = new CommandList(ADD_EXPENSE, ADD_EXPENSE_USAGE,
                ADD_EXPENSE_FORMAT, ADD_EXPENSE_EXAMPLE);
        CommandList listCommand = new CommandList(LIST_EXPENSE, LIST_EXPENSE_USAGE,
                LIST_EXPENSE_FORMAT, LIST_EXPENSE_EXAMPLE);
        CommandList deleteCommand = new CommandList(DELETE, DELETE_USAGE,
                DELETE_FORMAT, DELETE_EXAMPLE);
        CommandList viewCommand = new CommandList(VIEW, VIEW_USAGE,
                VIEW_FORMAT, VIEW_EXAMPLE);
        CommandList viewCategoryCommand = new CommandList(VIEW_CATEGORY, VIEW_CATEGORY_USAGE,
                VIEW_CATEGORY_FORMAT, VIEW_CATEGORY_EXAMPLE);
        CommandList addDesCommand = new CommandList(ADD_DESCRIPTION, ADD_DESCRIPTION_USAGE,
                ADD_DESCRIPTION_FORMAT, ADD_DESCRIPTION_EXAMPLE);
        CommandList deleteDesCommand = new CommandList(DELETE_DESCRIPTION, DELETE_DESCRIPTION_USAGE,
                DELETE_DESCRIPTION_FORMAT, DELETE_DESCRIPTION_EXAMPLE);
        CommandList setBudgeCommand = new CommandList(SET_BUDGET, SET_BUDGET_USAGE,
                SET_BUDGET_FORMAT, SET_BUDGET_EXAMPLE);
        CommandList exitCommand = new CommandList(EXIT, EXIT_USAGE,
                EXIT_FORMAT, EXIT_EXAMPLE);
        CommandList showStatisticCommand = new CommandList(SHOW_STATISTIC, SHOW_STATISTIC_USAGE,
                SHOW_STATISTIC_FORMAT, SHOW_STATISTIC_EXAMPLE);
        CommandList sortByAmountCommand = new CommandList(SORT_BY_AMOUNT, SORT_BY_AMOUNT_USAGE,
                SORT_BY_AMOUNT_FORMAT, SORT_BY_AMOUNT_EXAMPLE);
        CommandList sortByTimeCommand = new CommandList(SORT_BY_TIME, SORT_BY_TIME_USAGE,
                SORT_BY_TIME_FORMAT, SORT_BY_TIME_EXAMPLE);
        CommandList filterByTimeCommand = new CommandList(FILTER_BY_DATE, FILTER_BY_DATE_USAGE,
                FILTER_BY_DATE_FORMAT, FILTER_BY_DATE_EXAMPLE);
        CommandList filterByDescriptionCommand = new CommandList(FILTER_BY_DESCRIPTION, FILTER_BY_DESCRIPTION_USAGE,
                FILTER_BY_DESCRIPTION_FORMAT, FILTER_BY_DESCRIPTION_EXAMPLE);
        CommandList helpCommand = new CommandList(HELP, HELP_USAGE,
                HELP_FORMAT, HELP_EXAMPLE);
        CommandList filterByCategoryCommand = new CommandList(FILTER_BY_CATEGORY, FILTER_BY_CATEGORY_USAGE,
                FILTER_BY_CATEGORY_FORMAT, FILTER_BY_CATEGORY_EXAMPLE);
        CommandList clearCommand = new CommandList(CLEAR, CLEAR_USAGE,
                CLEAR_FORMAT, CLEAR_EXAMPLE);
        CommandList editCommand = new CommandList(EDIT, EDIT_USAGE,
                EDIT_FORMAT, EDIT_EXAMPLE);
        CommandList exchangeCurrencyCommand = new CommandList(EXCHANGE_CURRENCY, EXCHANGE_CURRENCY_USAGE,
                EXCHANGE_CURRENCY_FORMAT, EXCHANGE_CURRENCY_EXAMPLE);
        CommandList showCurrencyCodeCommand = new CommandList(SHOW_CURRENCY_CODE, SHOW_CURRENCY_CODE_USAGE,
                SHOW_CURRENCY_CODE_FORMAT, SHOW_CURRENCY_CODE_EXAMPLE);
        list.add(addDesCommand);
        list.add(addCommand);
        list.add(clearCommand);
        list.add(deleteCommand);
        list.add(deleteDesCommand);
        list.add(editCommand);
        list.add(exchangeCurrencyCommand);
        list.add(exitCommand);
        list.add(filterByCategoryCommand);
        list.add(filterByTimeCommand);
        list.add(filterByDescriptionCommand);
        list.add(helpCommand);
        list.add(listCommand);
        list.add(setBudgeCommand);
        list.add(showCurrencyCodeCommand);
        list.add(showStatisticCommand);
        list.add(sortByAmountCommand);
        list.add(sortByTimeCommand);
        list.add(viewCommand);
        list.add(viewCategoryCommand);
        return list;
    }
}
