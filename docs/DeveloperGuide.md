---
layout: page
title: Developer Guide
---
* Table of Contents
    * [1. Overview](#1-overview)
        * [1.1 Introduction](#11-introduction)
        * [1.2 Setting Up, Getting Started](#12-setting-up-getting-started)
    * [2. Design](#2-design)
        * [2.1 Architecture](#21-architecture)
        * [2.2 UI Component](#22-ui-component)
        * [2.3 Logic component](#23-logic-component)
        * [2.4 Model component](#24-model-component)
        * [2.5 Storage component](#25-storage-component)
        * [2.6 Storage component](#26-common-classes)
    * [3. Implementation](#3-implementation)
        * [3.1 Expense management feature](#31-expense-management-feature)
            * [3.1.1 Add expense feature](#311-add-expense-feature)
            * [3.1.2 View expense feature](#312-view-expense-feature)
            * [3.1.3 Edit expense feature](#313-edit-expense-feature)
            * [3.1.4 Delete expense feature](#314-delete-expense-feature)
            * [3.1.5 Add description to expense feature](#315-add-description-to-expense)
            * [3.1.6 List all expenses](#316-list-feature)
        * [3.2 Exchange feature](#32-exchange-features)
        * [3.3 Budget feature](#33-budget-features)
        * [3.4 Expense list filter functionalities](#34-expense-list-filter-functionalities)
        * [3.5 Expense list sorting functionalities](#35-expense-list-sorting-functionalities)
    * [4. Documentation, logging, testing, configuration, dev-ops](#4-documentation-logging-testing-configuration-dev-ops)
    * [5. Appendix A: Requirements](#5-appendix-a-requirements)
        * [5.1 Product scope](#51-product-scope)
        * [5.2 User stories](#52-user-stories)
        * [5.3 Use cases](#53-use-cases)
        * [5.4 Non-Functional Requirementss](#54-non-functional-requirements)
        * [5.5 Glossary](#55-glossary)
    * [6. Appendix B: Instructions for manual testing](#6-appendix-b-instructions-for-manual-testing)
        * [6.1 Launch and shutdown](#61-launch-and-shutdown)
        * [6.2 Add an expense](#62-add-an-expense)
        * [6.3 Add a description to current expenses](#63-add-a-description-to-current-expenses)
        * [6.4 Delete a description to current expenses](#64-delete-a-description-to-current-expenses)
        * [6.5 Clear all expenses](#65-clear-all-expenses)
        * [6.6 Edit an expense](#66-edit-an-expense)
        * [6.7 Covert currency of current expenses to new currency](#67-covert-currency-of-current-expenses-to-new-currency)
        * [6.8 Delete an expense](#68-delete-an-expense)
        * [6.9 Exit from the application](#69-exit-from-the-application)
        * [6.10 Filter by Category](#610-filter-by-category)
        * [6.11 Filter by Date](#611-filter-by-date)
        * [6.12 Filter by Description](#612-filter-by-description)
        * [6.13 Help Command](#613-help-command)
        * [6.14 Listing all expenses](#614-listing-all-expenses)
        * [6.15 Set budget for the expense book](#615-set-budget-for-the-expense-book)
        * [6.16 Show Currency Code](#616-show-currency-code)
        * [6.17 Show Statistic](#617-show-statistic)
        * [6.18 Sort by amount](#618-sort-by-amount)
        * [6.19 Sort by time](#619-sort-by-time)
        * [6.20 View a specific expenses](#620-view-a-specific-expenses)
        * [6.21 View all the categories](#621-view-all-the-categories)
    * [7. Appendix C: Model Component](#7-appendix-c-model-component)
    

--------------------------------------------------------------------------------------------------------------------

## 1. **Overview**
Welcome to UniSave Developer Guide. This documentation provides you an insight on how UniSave is designed and implemented.

## 1.1 Introduction
UniSave is a **desktop app for managing expenses, optimized for use via a Command Line Interface** (CLI).

It is an application that helps university students manage their finance by tracking your spending, 
setting budget for each month, as well as viewing their expenses in various categories. 
Moreover, UniSave allows tracking expenses in different currencies.

UniSave targets university students who tend to incur a large amount of spending.
It is catered especially for students who are more familiar with desktop applications and type fast.
UniSave is available for the Linux, Windows and Mac OS operating systems.
 
## 1.2 Setting Up, Getting Started
Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## 2. **Design**

### 2.1 Architecture

<img src="images/ArchitectureDiagram.png" width="450" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`]() and [`MainApp`](https://github.com/AY2021S1-CS2103T-W10-1/tp/blob/master/src/main/java/seedu/address/Main.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.
  This rule is applied to all the four components except `Model` in which we use `ExpenseModelManager` as the name of its concrete class.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

The sections below give more details of each component.

### 2.2 UI component

![Structure of the UI Component](images/UiClassDiagram.png)

**API** :
[`Ui.java`](https://github.com/AY2021S1-CS2103T-W10-1/tp/blob/master/src/main/java/seedu/address/ui/Ui.java)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `ExpenseListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class.

The `UI` component uses JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### 2.3 Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/AY2021S1-CS2103T-W10-1/tp/blob/master/src/main/java/seedu/address/logic/Logic.java)

1. `Logic` uses the `ExpenseBookParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a expense).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

### 2.4 Model component

![Structure of the Model Component](images/ModelClassDiagram.png)

**API** : [`Model.java`](https://github.com/AY2021S1-CS2103T-W10-1/tp/blob/master/src/main/java/seedu/address/model/Model.java)

The `Model`,

* stores a `UserPref` object that represents the user’s preferences.
* stores the expense book data.
* exposes an unmodifiable `ObservableList<Expense>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.


### 2.5 Storage component

![Structure of the Storage Component](images/StorageClassDiagram.png)

**API** : [`Storage.java`](https://github.com/AY2021S1-CS2103T-W10-1/tp/blob/master/src/main/java/seedu/address/storage/Storage.java)

The `Storage` component,
* can save `UserPref` objects in json format and read it back.
* can save the expense book data in json format and read it back.

### 2.6 Common classes

Classes used by multiple components are in the `seedu.address.commons` package.

--------------------------------------------------------------------------------------------------------------------

## 3. **Implementation**

This section describes some noteworthy details on how certain features are implemented.


### 3.1 Expense Management Feature

As an expense management application, the most important features are to be able to add, edit, view and delete your
expenses.

This section will cover the details of the current implementation and design considerations of
the description management feature.

#### Current Implementation

The expense management feature supports six main operations:

* `add` - record an expense, with an amount, a date, a category and a description as fields.
* `view` - view the details of an existing expense.
* `edit` - edit the details of an existing expense.
* `delete` - delete an existing expense from the expense list.
* `add-d` - add a description to an existing expense.
* `list` - list the descriptions in the expense book.


#### Expense model

The add expense, view expense, edit expense, delete expense, as well as add description features and delete description
feature are mainly supported by the `Expense` class.

Given below is the class diagram of the `Expense` class.

Fig. Class Diagram for Expense.
![ExpenseClassDiagram](images/ExpenseClassDiagram.png)


### 3.1.1 Add expense feature

Given below is an example usage scenario and how the mechanism for adding expenses behaves at each step.

The following activity diagram summarizes what happens when a user executes the `AddExpenseCommand`:

Fig. Activity Diagram for the Execution of `AddExpenseCommand`
![AddExpenseActivityDiagram](images/AddExpenseActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI, or a sample expense list if the file storing the
expense data is not found.

Step 3. The user executes `add a/AMOUNT c/CATEGORY [t/DATE] [d/DESCRIPTION]` to add an expense.
For example, the user can use `add a/100 c/food t/2020-11-08 d/had dinner with friends` to add the expense incurred on
"2020-11-08", with an amount of "100", a category "food", and a description "had dinner with friends" to the UniSave expense list.
The `AddExpenseCommand` calls `Expense` to create a new Expense object and add it to the `ExpenseList` stored in `ExpenseBook`.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `add a/100 c/food`:

High Level Sequence Diagram for the Execution of `add a/100 c/food`
![AddDescriptionActivityDiagram](images/AddExpenseSequenceDiagram.png)

#### Design Considerations

##### Aspect: How to manage optional fields.

* Alternative 1 (current choice): Check if the prefix of the specific optional field is provided by the user. If not, add
the prefix and the default value when creating the expense object.
** Pros: Expense always contains the optional objects. No possibility of 0 date object or description object in expense.
** Cons: When setting these fields to default value, it is crucial to use the right default values.
* Alternative 2: Use an `Optional` for optional fields.
** Pros: More intuitive.
** Cons: Harder to manage and prone to error.

### 3.1.2 View expense feature

The view expense feature is facilitated by the `ExpenseBook` class.

Given below is the class diagram of the `ExpenseBook` class.

Fig. Class Diagram for ExpenseBook.
![ExpenseClassDiagram](images/ExpenseClassDiagram.png)

Given below is an example usage scenario and how the mechanism of viewing an expense behaves at each step.

The following activity diagram summarizes what happens when a user executes the `ViewCommand`:

Fig. Activity Diagram for the Execution of `ViewCommand`

![ViewActivityDiagram](images/ViewActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI.

Step 3. The user executes `view 1` to view the details of the expense with index 1(the first expense) 
in the displayed expense list.
The `ViewCommand` searches for the first expense in the `ExpenseList` stored in `UniSave`
and creates a CommandResult which contains the details of the first expense found in the list.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `view 1`:

High Level Sequence Diagram for the Execution of `view 1`
![ViewCommandSequenceDiagram](images/ViewSequenceDiagram.png)

#### Design Considerations

##### Aspect: Expense book already displays information of expenses.

* Alternative 1: Directly see the expense from the UI.
** Pros: No need to type in any command.
** Cons: May take some time to scroll down the list to look for the correct index, especially when the 
         expense list is sorted by date/amount.
         
         
#### View all existing expense categories 

The view existing expense categories feature is facilitated by the ExpenseBook class.

Given below is the class diagram of the `ExpenseBook` class.

Fig. Class Diagram for Expense.
![ExpenseClassDiagram](images/ExpenseClassDiagram.png)

Given below is an example usage scenario and how the mechanism of viewing an expense behaves at each step.

The following activity diagram summarizes what happens when a user executes the `ViewCategoryCommand`:

Fig. Activity Diagram for the Execution of `ViewCategory`
![ViewCategoryCommandActivityDiagram](images/ViewCategoryCommandActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI.

Step 3. The user executes `ViewCategory` to view all the existing expense category labels 
        in the ExpenseBook in Unisave.
The `ViewCategoryCommand` searches for the first expense in the `ExpenseList` stored in `UniSave`
and creates a CommandResult which contains the details of the first expense found in the list.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `viewCategory`:

High Level Sequence Diagram for the Execution of `viewCategory`
![ViewCategorySequenceDiagram](images/ViewCategorySequenceDiagram.png)

#### Design Considerations

##### Aspect: Existing categoris can be found from the expense list.

* Alternative 1: Directly search for existing expense categories from the UI.
** Pros: No need to type in any command.
** Cons: Takes a lot of time to do so.

### 3.1.3 Edit expense feature

Given below is an example usage scenario and how the mechanism for editing expenses behaves at each step.

The following activity diagram summarizes what happens when a user executes the `EditExpenseCommand`:

Fig. Activity Diagram for the Execution of `EditExpenseCommand`
![AddDescriptionActivityDiagram](images/EditExpenseActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI.

Step 3. The user executes `edit INDEX [a/AMOUNT] [c/CATEGORY] [t/DATE] [d/DESCRIPTION]` to edit existing expense. 
`edit 1 a/12` edit the amount field of the 1st expense in the currently displayed expense list from 10 to 12.
The `EditExpenseCommand` calls `Expense` to create a new expense object with the provided fields replaced by the new
values.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `edit 1 a/12`:

High Level Sequence Diagram for the Execution of `edit 1 a/12`
![AddDescriptionActivityDiagram](images/EditExpenseSequenceDiagram.png)

#### Design Considerations


##### Aspect: How to allow editing different number of fields each time.

* Alternative 1 (current choice): For every prefix, check if the prefix and a value is provided.
If no prefix is provided, return an error as no change in any fields means this is not a valid edit.

** Pros: Less prone to error. If a certain prefix is not provided, simply use the field object in the current expense
without changing it.
** Cons: Performance is slower, especially when the number of prefixed is large. Iterating through all and checking
through all of them might reduce the speed of processing the edit command.
* Alternative 2: Check the number of prefix provided.
** Pros: Fast to check the number. 
** Cons: Require extra data structure to keep track of the prefixes. 


### 3.1.4 Delete Expense feature

#### Implementation

The delete mechanism extends `ExpenseBook` and stored internally as an `ExpenseBookStateList` and `currentStatePointer`.

Given below is an example usage scenario and how the delete mechanism behaves at each step.

Step 1. The user launches the application for the first time. The ExpenseBook will be initialized with the initial expense book state, and the `currentStatePointer` pointing to that single expense book state.

![UndoRedoState0](images/deleteState0.png)

Step 2. The user executes `delete 5` command to delete the 5th expenses in the expense book. The `delete` command calls `Model#saveExpenseBook()`, causing the modified state of the expense book after the `delete 5` command executes to be saved in the `expenseBookStateList`, and the `currentStatePointer` is shifted to the newly inserted expense book state.

![UndoRedoState1](images/deleteState1.png)

Step 3. The user executes `add a/100 c/Entertainment t/1 d/Movie` to add a new expense. The `add` command also calls `Model#saveAddressBook()`, causing another modified expense book state to be saved into the `expenseBookStateList`.

![UndoRedoState2](images/deleteState2.png)

**Note:** If a command fails its execution, it will not call `Model#saveExpenseBook()`, so the expense book state will not be saved into the `expenseBookStateList`.


Step 4. The user now decides that adding the expense was a mistake, and decides to delete that expense by executing the `delete` command. The `delete` command will call `Model#deleteExpenseBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous expense book state, and restores the expense book to that state.

![UndoRedoState3](images/deleteState3.png)

**Note:** If the `currentStatePointer` is at index 0, pointing to the initial ExpenseBook state, then there are no previous ExpenseBook states to restore. The `delete` command uses `Model#canDeleteExpenseBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.


The following sequence diagram shows how the delete operation works:

![UndoSequenceDiagram](images/deleteExpenseSequenceDiagram.png)


### 3.1.5 Add description to expense


The add description features and delete description feature are mainly supported by the `Expense` class.

Given below is an example usage scenario and how the mechanism for adding description to expenses behaves at each step.

The following activity diagram summarizes what happens when a user executes the `AddDescriptionCommand`:

Fig. Activity Diagram for the Execution of `AddDescriptionCommand`
![AddDescriptionActivityDiagram](images/AddDescriptionActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI.

Step 3. The user executes `add-d 2 d/Spent on books` to add the description "Spent on books" to the expense with index 2 in the displayed expense list.
The `AddDescriptionCommand` calls `Description` to create a new description object and a new Expense object containing 
this newly created description object, and replace the previous expense object with this updated expense in the 
`ExpenseList` stored in `UniSave`.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `add-d 2 d/Spent on books`.

High Level Sequence Diagram for the Execution of `add-d 2 d/Spent on books`:
![AddDescriptionActivityDiagram](images/AddDescriptionSequenceDiagram.png)

#### Design Considerations

##### Aspect: How to manage empty description, as description is optional.

* Alternative 1 (current choice): Use empty string to create description, if description is empty.
** Pros: Expense always contains a description object. No possibility of 0 description object in expense.
** Cons: When deleting the description, the description object is not deleted and "Description:" field is still shown on UI.
* Alternative 2: Use an `Optional` for descriptions.
** Pros: More intuitive.
** Cons: Harder to manage and prone to error.

### 3.1.6 List feature

#### Implementation

The list feature belongs to `ListExpenseCommand` extends `Command`. This list feature will not modify the expense list of UniSave.
`ListExpenseCommand` is created at `ExpenseBookParser` which is called by `LogicManager` to parse input string into `Command`.
`LogicManager` takes in input string from `CommandBox` which belongs to one of the GUI component.

Given below is an example usage scenario of how the list feature behaves at each step.

Step 1. User initializes the app. `ExpenseModelManager` extends `Model`, has a FilteredList of expenses. <br/>
Step 2. After user inputs list command, the steps can be shown from this sequence diagram.

![ListSequenceDiagram](images/ListSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: 
**Note:**  `FilteredList` is a JavaFX class that wraps an `ObservableList` and filters it's content using the provided Predicate. 
</div>

Step 3: As we can see from the sequence diagram, a result is also returned to `UI` and shown to the app's result box.

The following activity diagram summarizes what happens when a user executes list command:

![ListActivityDiagram](images/ListActivityDiagram.png)

### 3.2 Exchange features

The Exchange feature allows converting the currency of the whole ExpenseBook. Each individual expense along with the budget in the ExpenseBook will be exchanged into the input currency at exchange rate from the current currency.

Given below is a class diagram for `ExpenseBook` class.

Fig. Class Diagram for ExpenseBook.
![ExpenseBookClassDiagram](images/ExpensebookClassDiagram.png)

When executing `exchange` command, the `Currency` field will be changed if the input currency code is valid.

Given below is an example usage scenario and how the mechanism of exchange behaves at each step.

The following activity diagram summarizes what happens when a user executes the `exchange cc/cny`:

Fig. Activity Diagram for the Execution of `ExchangeCommand`
![ExchangeActivityDiagram](images/ExchangeActivityDiagram.png)

Step 1. The user launches the application.

Step 2. UniSave displays a list of existing expenses in the UI.

Step 3. The user executes `exchange cc/cny` to exchange the currency of the ExpenseBook from `SGD` (Default Currency) to `CNY`.

Step 4. The `ExchangeCommand` build a new `CurrencyConverter` to calculate the exchange rate from `SGD` to `CNY`. 
The `ExchangeCommand` exchanges the `Budget` and `ExpenseList` of `ExpenseBook` at the calculated exchange rate, and changes the `Currency` of the ExpenseBook to `CNY`.

The sequence diagram below shows the high-level abstraction of how UniSave processes user request to execute `exchange cc/cny`:

High Level Sequence Diagram for the Execution of `exchange cc/cny`
![ExchangeSequenceDiagram](images/ExchangeSequenceDiagram.png)

#### Design Considerations

##### Aspect: How to handle Exchange Rates
* Alternative 1: Let the user to type in real-time exchange rate.
** Pros: Correct input of the exchange rate can make the conversion more accurate.
** Cons: More prone to error, cannot check for incorrect exchange rates.

* Alternative 2: Let the user to download additional text file, and read the exchange rates from the text file.
** Pros: More flexibility when updating the exchange rates.
** Cons: 
(1) Users can modify the text file, more prone to error when parsing from the text file.
(2) More files to download other than `UniSave.jar`, less user-friendly.


### 3.3 Budget features

The set budget feature allows the user to set a budget for ExpenseBook.

Given below is an example usage scenario and how the mechanism of setting a budget behaves at each step.

The following activity diagram summarizes what happens when a user executes the `set-b BUDGET`:

Fig. Activity Diagram for the Execution of `SetBudgetCommand`
![SetBudgetActivityDiagram](images/SetBudgetActivityDiagram.png)

Step 1. The user launches the application.

Step 2. UniSave displays a list of existing expenses in the UI.

Step 3. The user executes `set-b 1000` to set a new budget for the ExpenseBook.
The `SetBudgetCommand` set the budget of ExpenseBook to be `1000` under current currency.

The sequence diagram below shows the high-level abstraction of how UniSave processes user request
to execute `set-b 1000`:

High Level Sequence Diagram for the Execution of `set-b 1000`
![SetBudgetSequenceDiagram](images/SetBudgetSequenceDiagram.png)

#### Design Considerations

##### Aspect: How do user check the updated budget.

* Alternative 1: Use ShowBudget Command `show-b`
** Pros: Simplier Implementation.
** Cons: Users cannot see their remaining budget all the time.

## 3.4 Expense List Filter Functionalities

#### Implementation - Filter Expense By Category

The filter expense by category feature belongs to `ListExpenseByCategoryCommand` extends `Command`. This feature will not modify the expense list of UniSave.
`ListExpenseByCategoryCommand` is created at `ExpenseBookParser` by `ListExpenseByCategoryCommandParser`.
Then, `LogicManager` execute this command.

Given below is an example usage scenario of how the filter expense by category feature behaves at each step.

Step 1. User initializes the app. `ExpenseModelManager` extends `Model`, has a FilteredList of expenses. <br/>
Step 2. After user inputs `filter-c food` command, the steps can be shown from this sequence diagram.

![FilterCategorySequenceDiagram](images/FilterCategorySequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: 
**Note:**  `FilteredList` is a JavaFX class that wraps an `ObservableList` and filters it's content using the provided Predicate. 
</div>

Step 3: As we can see from the sequence diagram, a result is also returned to `UI` and shown to the app's result box.

The following activity diagram summarizes what happens when a user executes filter expense by category command:

![FilterCategoryActivityDiagram](images/FilterCategoryActivityDiagram.png)

#### Implementation - Filter Expense By Date

The filter expense by date feature belongs to `ListExpenseByDateCommand` extends `Command`. This feature will not modify the expense list of UniSave.
`ListExpenseByDateCommand` is created at `ExpenseBookParser` by `ListExpenseByDateCommandParser`.
Then, `LogicManager` execute this command.

Given below is an example usage scenario of how the filter expense by date feature behaves at each step.

Step 1. User initializes the app. `ExpenseModelManager` extends `Model`, has a FilteredList of expenses. <br/>
Step 2. After user inputs `filter-t 2020-12-12` command, the steps can be shown from this sequence diagram.

![FilterDateSequenceDiagram](images/FilterDateSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: 
**Note:**  `FilteredList` is a JavaFX class that wraps an `ObservableList` and filters it's content using the provided Predicate. 
</div>

Step 3: As we can see from the sequence diagram, a result is also returned to `UI` and shown to the app's result box.

The following activity diagram summarizes what happens when a user executes filter expense by date command:

![FilterDateActivityDiagram](images/FilterDateActivityDiagram.png)

#### Implementation - Filter Expense By Description

The filter expense by description feature belongs to `ListExpenseByDescCommand` extends `Command`. This feature will not modify the expense list of UniSave.
`ListExpenseByDescCommand` is created at `ExpenseBookParser` by `ListExpenseByDescCommandParser`.
Then, `LogicManager` execute this command.

Given below is an example usage scenario of how the filter expense by description feature behaves at each step.

Step 1. User initializes the app. `ExpenseModelManager` extends `Model`, has a FilteredList of expenses. <br/>
Step 2. After user inputs `filter-d kfc` command, the steps can be shown from this sequence diagram.

![FilterDescSequenceDiagram](images/FilterDescSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: 
**Note:**  `FilteredList` is a JavaFX class that wraps an `ObservableList` and filters it's content using the provided Predicate. 
</div>

Step 3: As we can see from the sequence diagram, a result is also returned to `UI` and shown to the app's result box.

The following activity diagram summarizes what happens when a user executes filter expense by date command:

![FilterDescActivityDiagram](images/FilterDescActivityDiagram.png)

## 3.5 Expense list sorting functionalities
 
#### Implementation - Sort expense list by amount in ascending/descending order

The sort by amount feature is facilitated by the `ExpenseBook` class.

Given below is an example usage scenario of sort by amount in  
descending order and how the mechanism of sorting expenses by behaves at each step.

The following activity diagram summarizes what happens when a user executes the `SortByAmountCommand`:

Fig. Activity Diagram for the Execution of `SortByAmountCommand`

![AddDescriptionActivityDiagram](images/SortByAmountCommandActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI.

Step 3. The user executes `sort-a descending` to sort the displayed expenses  
in descending order of amount.

The `SortByAmountCommand` sorts the `ExpenseList` stored in `UniSave`  in the specified descending order of amount
and the displayed expense will accordingly update to the sorted version of the expense list.
It also creates a CommandResult to notify the user of the successful implementation.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `sort-a descending`:

High Level Sequence Diagram for the Execution of `sort-a descending`

![AddDescriptionActivityDiagram](images/SortByAmountSequenceDiagram.png)

#### Implementation - Sort expense list by time in ascending/descending order

The sort by amount feature is facilitated by the `ExpenseBook` class.

Given below is an example usage scenario of sort by amount in descending order  
and how the mechanism of sorting expenses by behaves at each step.

The following activity diagram summarizes what happens when a user executes the `SortByTimeCommand`:

Fig. Activity Diagram for the Execution of `SortByTimeCommand`

![AddDescriptionActivityDiagram](images/SortByTimeCommandActivityDiagram.png)

Step 1. The user launches the application.

Step 2. Unisave displays a list of existing expenses in the UI.

Step 3. The user executes `sort-t ascending` to sort the displayed expenses  
in descending order of amount.

The `SortByTimeCommand` sorts the `ExpenseList` stored in `UniSave`  in the specified descending order of time
and the displayed expense will accordingly update to the sorted version of the expense list.

It also creates a CommandResult to notify the user of the successful implementation.

The sequence diagram below shows the high-level abstraction of how Unisave processes user request
to execute `sort-t ascending`:

High Level Sequence Diagram for the Execution of `sort-t ascending`

![AddDescriptionActivityDiagram](images/SortByTimeSequenceDiagram.png)

--------------------------------------------------------------------------------------------------------------------

## **4. Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **5. Appendix A: Requirements**

### 5.1 Product scope

**Target user profile**:

* university international students who want to plan their finance
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps
* spend various currency

**Value proposition**:

1. Problem: spending in different currency not tracked by many existing apps -> track spending in different currency
2. Problem: student exceeds budget, spending without control -> help you manage expense reasonably, save some money at the end of the month
3. Problem: student want to plan their finance, but writing them down is too troublesome -> this app is very convenient to use as users can record their finance any time they want
4. Problem: Student spend at various fields, too messy to record -> the labels functions allow students to organize their spending
5. Problem: Existing apps are complicated, not easy to use -> this app is simple to use and very user-friendly.

### 5.2 User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                                 | I want to …​                     | So that I can…​                                                                      |
| -------- | ------------------------------------------ | ----------------------------------- | --------------------------------------------------------------------------------------- |
| `* * *`  | user                                       | Add an expense with category        | keep track of my accounts                                                               |
| `* * *`  | user                                       | View an expense                     | easily see the details such as dates, amount and descriptions of a specific expense     |
| `* * *`  | user                                       | Delete an expense                   | delete the expense when I added wrongly                                                 |
| `* * *`  | user                                       | List all expenses                   | view all expenses                                                                       |
| `* * *`  | user                                       | Edit certain expenses               | make amendment if i enter wrong information                                             | 
| `* * *`  | user                                       | see a brief summary of my expenses  | make better spending decision as i know which area takes uo the most                    |
| `* * *`  | user                                       | see the list of command available   | quickly use the features and commands if i forget some of them                          |
| `* * *`  | user                                       | Set budget                          | plan my expenses                                                                        |
| `* * *`  | user                                       | View budget                         | view how much i can spend before exceeding the monthly limit                            |
| `* * *`  | user                                       | Sort expenses by amount             | view existing expenses in descending/ascending order of amount                          |
| `* * *`  | user                                       | Sort expenses by time               | view existing expenses in descending/ascending order of amount                          |
| `* *`    | user                                       | List all categories                 | view all categories                                                                     |
| `* *`    | user                                       | List all expenses in one category   | view all expenses spent under one category                                              |
| `* *`    | user                                       | List all expenses in one date       | view all expenses spent on a day                                                        |
| `* *`    | user                                       | List all expenses in one description| view all expenses spent under same description                                          |
| `* *`    | user                                       | Convert to another currency         | view my expenses when i spend another currency such as going overseas                   |
| `* *`    | user                                       | Show country's currency codes       | know the country's currency codes before converting                                     |
| `* *`    | user                                       | Show country's exchange rates       | know the country's exchange rates before converting                                     |
| `* `     | user                                       | Clear all data                      |                                                                                         |

*{More to be added}*

### 5.3 Use cases

(For all use cases below, the **System** is the `ExpenseBook` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Add expense to current expense book **

**MSS**

1.  User chooses to add an expense into the expense book.
2.  UniSave adds the expense to the expense book.
    Use case ends.

**Extensions**

* 1a. The expense is invalid.

    * 1a1. UniSave shows an error message.
    * 1a2. User enters new expense. Steps 1a1-1a2 are repeated until the data entered is valid.

    Use case resume at Step 2

**Use case: Edit an expense in current expense book **

**MSS**

1.  User chooses to edit an expense in the expense book.
2.  UniSave edit the specified expense to the expense book.
    Use case ends.

**Extensions**

* 1a. The edited expense is invalid or the requested expense is invalid.

    * 1a1. UniSave shows an error message.
    * 1a2. User enters new information to be edited. Steps 1a1-1a2 are repeated until the data entered is valid.

    Use case resume at Step 2

**Use case: View help**

**MSS**

1.  User wants to view all valid commands they can use.
2.  UniSave shows a table with all commands as well as a link to UniSave's user guide.
    Use case ends.
    
**Use case: Show Statistic**

**MSS**

1.  User wants to see a brief summary of his expenses
2.  UniSave shows a table with brief expense summary as well as a pie chart for the expenses.
    Use case ends.

**Use case: View expense**

**MSS**

1.  User requests to list all the expenses
2.  UniSave shows a list of existing expenses

    Use case ends.

**Use case: Delete a current expense**

**MSS**

1.  User requests to list expenses
2.  UniSave shows a list of existing expenses
3.  User requests to delete a specific expenses in the list
4.  UniSave deletes the requested expense chosen by the user.

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. UniSave shows an error message.

      Use case resumes at step 2.

**Use case: Add a description to an expense**

**MSS**

1.  User requests to list expenses
2.  UniSave shows a list of expenses
3.  User requests to add a description to a specific expense in the list
4.  UniSave adds the description input by user to the specific expense

**Use case: Delete the current description of an expense**

**MSS**

1.  User requests to list expenses
2.  UniSave shows a list of expenses
3.  User requests to delete the description of a specific expense in the list
4.  UniSave deletes the description of expense chosen by the user.

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. UniSave shows an error message.

      Use case resumes at step 2.

**Extensions**

* 2a. The input category is invalid or does not exist.

    * 2a1. UniSave shows an error message.

      Use case resumes at step 2.

**Use case: List all expenses**

**MSS**

1.  User requests to list all the expenses
2.  UniSave shows a list of all expenses

    Use case ends.

**Use case: View category labels**

**MSS**

1.  User requests to list available category labels
2.  UniSave shows a list of existing category labels

    Use case ends.

**Use case: Filter all expenses in a specific category**

**MSS**
1.  User requests to filter all the expenses in a specific category
2.  UniSave shows a list of expenses in that category
    
    Use case ends.

**Use case: Filter all expenses in a specific date**

**MSS**
1.  User requests to filter all the expenses in a specific date
2.  UniSave shows a list of expenses saved on that day.
    
    Use case ends.
    
**Extensions**

* 1a. UniSave detects an error in the entered date.
    * 1a1. UniSave shows an error message with the correct usage of filter expenses by date command.
    * Use case ends.

**Use case: Filter all expenses in a specific description**

**MSS**
1.  User requests to filter all the expenses in a specific description
2.  UniSave shows a list of expenses in that category
    
    Use case ends.

**Use case: Set Budget**

**MSS**

1.  User requests to set a new budget.
2.  UniSave updates and displays the new budget and remaining budget in budget panel.

    Use case ends.

**Extensions**

* 1a. UniSave detects an error in the entered value.
    * 1a1. UniSave shows an error message with the correct usage of setting budget.
    * Use case ends.

**Use case: Exchange Currency**

**MSS**

1.  User requests to exchange the currency of ExpenseBook.
2.  UniSave do the conversion from current currency to input currency.
3.  UniSave updates and displays the budget and all the expenses in the new currency.

    Use case ends.

**Extensions**

* 1a. UniSave detects an error in the entered currency code.
    * 1a1. UniSave shows an error message with the correct usage of exchange.
    * 1a2. User request to check for the currency codes according to the error message.
    * 1a3. UniSave shows a table of Currency Codes.
    * 1a4. User requests to exchange the currency of ExpenseBook with a valid currency code.
    * Use case ends.


**Use case: Sort expenses by time**

**MSS**

1.  User requests to sort existing expenses on ascending/descending order.
2.  UniSave sorts the expense list in specified order by time.
3.  UniSave displays the new sorted expense list.

    Use case ends.

**Extensions**

* 1a. The user enters an invalid order.
    * 1a1. UniSave detects the error and displays an error message to the user.
    * 1a2. UniSave requests for the correct order.
    * 1a3. User re-enters the command. Step 1a1 and 1a2 are repeated until the user enters a valid order.


**Use case: Sort expenses by amount**

**MSS**

1.  User requests to sort existing expenses on ascending/descending order.
2.  UniSave sorts the expense list in specified order by amount.
3.  UniSave displays the new sorted expense list.

    Use case ends.

**Extensions**

* 1a. The user enters an invalid order.
    * 1a1. UniSave detects the error and displays an error message to the user.
    * 1a2. UniSave requests for the correct order.
    * 1a3. User re-enters the command. Step 1a1 and 1a2 are repeated until the user enters a valid order.

### 5.4 Non-Functional Requirements

1. Should be able to function well without connecting to internet.
2. Should be accessed for a single user.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using a mouse.
4. The product should be easy to use by a novice with no experience of using a finance tracking application.
5. Documentation should be easy to read and understand with proper highlighting.

### 5.5 Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Expense**: The amount of money spent by the user student in a certain event
* **Budget**: The maximum amount of money that the user student can spend
* **Currency code** The representation of a currency, following ISO4217, which is published by the International Organisation for Standadization.
It is unique for every currency.

--------------------------------------------------------------------------------------------------------------------

## **6. Appendix B: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### 6.1 Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

### 6.2 Add an expense

1. Add an expense into the expense book. Amount and category are compulsory. Date and description are optional.

   i.   Prerequisites: The amount entered need to be a valid one.<br>
   ii.  Test case: `add a/50 c/ENTERTAINMENT t/1 d/movie` <br>
        Expected: A new expense is added into expense book. Details of the added expense shown in the result box. <br>

   iii. Test case: `add a/50 c/ENTERTAINMENT`<br>
        Expected: A new expense is added into expense book. Since the `date` filed is empty, it will automatically set to today's date. Details of the added expense shown in the result box <br>
   
   iv.  Test case: `add`<br>
        Expected: No expense is added. There will be an error message because the compulsory field instruction is missing.<br>

   v.   Other incorrect add expense commands to try: `add a/100`, `add c/entertainment` (missing compulsory field)<br>
        Expected: Similar to previous test case. <br>
        
### 6.3 Add a description to current expenses

1. Add a description into the expense with the index specified. Index and description field are compulsory.

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `add-d 1 d/movie` <br>
        Expected: A new description is added into the expense with the index specified. Details of the added description shown in the result box <br>


   iii. Test case: `add-d 1 d/movie d/study`<br>
        Expected: A new description is added into expense with the index specified. When more than one descriptions are added, the last one is used. Details of the added description shown in the result box. <br>
   
   iv.  Test case: `add-d`<br>
        Expected: No description is added. There will be an error message because the compulsory field instruction is missing. <br>

   v.   Other incorrect add expense commands to try: `add-d 1`, `add-d d/` (missing compulsory field)<br>
        Expected: Similar to previous test case. <br>

### 6.4 Delete a description to current expenses

1. Delete an description into the expense with the index specified. Index and description field are compulsory.

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `add-d 1 d/` <br>
        Expected: The description of the expense with the index specified is deleted. Details of the deleted description shown in the result box. <br>
   iii. Test case: `add-d`<br>
        Expected: No description is deleted. There will be an error message because the compulsory field instruction is missing. <br>

   iv.   Other incorrect add expense commands to try: `add-d 1`, `add-d d/` (missing compulsory field)<br>
        Expected: Similar to previous test case. <br>
        
### 6.5 Clear all expenses

1. Clear all expenses in the expense book. The budget will also be cleared.

   i .  Test case: `clear` <br>
        Expected: All expenses and budget are cleared. The result box will show the information that all expenses are cleared. <br>

### 6.6 Edit an expense

1. Edit an expense specified by the index in the expense book. Index is compulsory followed by the field to be edited.

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `edit 1 a/120` <br>
        Expected: The first expenses will be updated with an amount of 120. Details of the edited expense shown in the result box. <br>

   iii. Test case: `edit 1 a/120 c/transport`<br>
        Expected: More than two fields are updated. The first expenses will be updated with an amount of 120 and category of transport. Details of the edited expense shown in the result box. <br>
   
   iv.  Test case: `edit`<br>
        Expected: No expense is edited. There will be an error message because the compulsory field instruction is missing. <br>

   v.   Other incorrect add expense commands to try: `edit 1`, `add c/entertainment` (missing compulsory field)<br>
        Expected: Similar to previous test case. <br>
        
### 6.7 Covert currency of current expenses to new currency

1. Currency of current expenses is converted to new specified currency. Currency code is case-insensitive but compulsory.

   i.   Test case: `exchange cc/CNY` <br>
        Expected: The currency of current expense is converted to Chinese Yuan specified by the currency code. Details of the currency conversion shown in the result box. <br>

   ii.  Test case: `exchange`<br>
        Expected: No conversion is done. There will be an error message because the compulsory field instruction is missing. <br>

   iii. Other incorrect add expense commands to try: `exchange CNY`, `exchange cc` (missing compulsory field)<br>
        Expected: Similar to previous test case. <br>
        
### 6.8 Delete an expense

1. delete an expense in the expense book. Index is compulsory.

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `delete 1` <br>
        Expected: First expense is deleted from the list. Details of the deleted expense shown in the result box. <br>

   iii. Test case: `delete 0`<br>
        Expected:No expense is deleted. There will be an error message because the index is invalid. <br>

   iv.  Other incorrect add expense commands to try: `delete -1`(invalid index), `delete 10` (if the expense book has less than 10 expeneses) <br>
        Expected: Similar to previous test case. <br>

### 6.9 Exit from the application

1. Exit from the application

   i .  Test case: `exit` <br>
        Expected: Exit from the current application. <br>

### 6.10 Filter by Category

1. Filter the expenses by category. Show all the expenses whose category match the specified category

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `filter-c entertainment` <br>
        Expected:  Filter all the expenses under category entertainment. <br>

   iii. Test case: `filter-c`<br>
        Expected: No expense is filtered. There will be an error message because the index is invalid. <br>
        
### 6.11 Filter by Date

1. Filter the expenses by date. Show all the expenses whose date match the specified date

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `filter-t 2020-11-02` <br>
        Expected:  Filter all the expenses under the date 2020-11-02. <br>

   iii. Test case: `filter-c`<br>
        Expected: No expense is filtered. There will be an error message because the command is invalid. <br>

### 6.12 Filter by Description

1. Filter the expenses by description. Show all the expenses whose description match the specified description.

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `filter-d movie` <br>
        Expected:  Filter all the expenses for the description movie. <br>

   iii. Test case: `filter-c`<br>
        Expected: No expense is filtered. There will be an error message because the command is invalid. <br>

### 6.13 Help Command

1. Provide a list of command for users to refer to.

   i .  Test case: `help` <br>
        Expected: There will be a command table shown with the link to the user guide. <br>

### 6.14 Listing all expenses

1. List all the expenses in the expense book.

   i.   Prerequisites: The expense book is not empty. <br>
   ii.  Test case: `list` <br>
        Expected:  Show all the expenses in the expense book. The result box shows the successful message. <br>

   iii. Other trivial list commands to try: `list x` (where x is any number or alphabet)<br>
        Expected: Similar to previous. The format of list command is not stated, so the list command is executed as long as the command word `list` is correct. <br>

### 6.15 Set budget for the expense book

1. Set budget for the expense book. The amount of the budget is compulsory.

   i.   Test case: `set-b 500` <br>
        Expected:  The budget of the expense book is set to $500. The result box shows the successful message. <br>

   ii.  Test case: `set-b 0`<br>
        Expected: No budget is set. There will be an error message because the budget set is invalid. <br>
        
   iii. Test case: `set-b`<br>
        Expected: No budget is filtered. There will be an error message because the index is invalid. <br>

### 6.16 Show Currency Code

1. Show the list of currency supported by the expense book as well as its corresponding code.

   i .  Test case: `show-codes` <br>
        Expected: There will be a command table the currency supported and its corresponding code. <br>
   
   ii.  Other trivial list commands to try: `show-codes x` (where x is any number or alphabet)<br>
        Expected: Similar to previous. The format of `show-codes` command is not stated, so the `show-codes` command is executed as long as the command word `show-codes` is correct. <br>
 
### 6.17 Show Statistic

1. Show the statistic of the expenses.

   i .  Test case: `show-stats` <br>
        Expected: There will be a command table that provide a brief summary of the expenses. <br>
   
   ii.  Other trivial list commands to try: `show-stats x` (where x is any number or alphabet)<br>
        Expected: Similar to previous. The format of `show-stats` command is not stated, so the `show-stats` command is executed as long as the command word `show-stats` is correct. <br>
 

### 6.18 Sort by amount

1. Sort the expenses by amount in ascending/descending order. The order is compulsory.

   i .  Test case: `sort-a ascending` <br>
        Expected: The expenses will be sorted by amount in ascending order. <br>

   i .  Test case: `sort-a descending` <br>
        Expected: The expenses will be sorted by amount in descending order. <br>
   
   iii. Test case: `sort-a`<br>
        Expected: Expenses are not sorted. There will be an error message because the compulsory field is missing. <br>
 
### 6.19 Sort by time

1. Sort the expenses by time in ascending/descending order. The order is compulsory.

   i .  Test case: `sort-t ascending` <br>
        Expected: The expenses will be sorted by time in ascending order. <br>

   i .  Test case: `sort-t descending` <br>
        Expected: The expenses will be sorted by time in descending order. <br>
   
   iii. Test case: `sort-t`<br>
        Expected: Expenses are not sorted. There will be an error message because the compulsory field is missing. <br>
 
### 6.20 View a specific expenses

1. View a specific index. The index is compulsory

   i .  Test case: `view 1` <br>
        Expected: View the first expenses. The result box shows the details of the expenses requested. <br>

   ii.  Test case: `view` <br>
        Expected: No expense is viewed. There will be an error message because the compulsory field is missing. <br>
        
   iii. Test case: `view 0` <br>
        Expected: No expense is viewed. There index of expense requested is invalid. <br>

### 6.21 View all the categories

1. View all the categories in the expense book. The category field is compulsory

   i .  Test case: `view-c` <br>
        Expected: Show all the categories in the expense book. The result box shows the successful message. <br>

   ii.  Test case: `view-c x` (where x is any number or alphabet) <br>
        Expected: Similar to previous. The format of `view-c` command is not stated, so the `view-c` command is executed as long as the command word `view-c` is correct. <br>

#  **7. Appendix C: Model Component**
![Model Component](images/ModelClassDiagram.png)
