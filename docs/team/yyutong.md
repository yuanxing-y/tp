---
layout: page
title: Yang Yutong's Project Portfolio Page
---

## Project: UniSave

Unisave is a desktop finance planner app, optimized for use via a Command Line Interface (CLI) while still having
the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **New Feature**: Added SortByAmount Command `sort-a`
  * What it does: Allows the user to sort the expense list in ascending/descending order of amount.
  * Justification: This feature allows the user to have a clearer idea of how much have they spended on each expense.
  * Highlights: It is useful for other functionalities such as delete. For example, it is now easy for the user to delete the expense with the highest/lowest amount.

* **New Feature**: Added SortByTime Command `sort-t`
  * What it does: Allows the user to sort the expense list in ascending/descending order of time.
  * Justification: This feature allows the user to have a clearer idea of when have they made each expense.
  * Highlights: It is useful for other functionalities such as delete. For example, it is now easy for the user to delete the expense with the nearest date.

* **New Feature**: Added ViewExpense Command `view index`
  * What it does: Allows the user to view the details of the expense at position of hte input index in the expense list.
  * Justification: This feature allows the user to view the details of an expense without having to scroll down the list to find it.
  * Highlights: It is useful for other functionalities such as delete. For example, it is now easy and clearier for the user to edit the selected expense.

* **New Feature**: Added ViewCategories Command `view-c`
  * What it does: Allows the user to view the eixsting categories.
  * Justification: This feature allows the user to have a clearer idea of what categories they currently have in their expense book.
  * Highlights: It is useful for other functionalities such as filter and add.
  By clearly knowing the current existing categories, it will be easier for the user to add new expense or to filter by certain category.

* **New Feature**: Added pop-up window of `show-stats`
  * What it does: Allows the user to clear see their expense structure in the form of pie chart and table.
  * Justification: This feature allows users to better visualize their spendings and expense structure.
  * Highlights: The animation effect of the pie chart at the time of update makes UniSave more attractive and comfortable to use for the user.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&until=2020-11-09&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=yyutong&tabRepo=AY2021S1-CS2103T-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

* **Enhancements implemented**:
    * Functional Code:
       * Changed UI background color ([\#161](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/161))
       * Added more elements to UI layout ([\#154](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/154),
       [\#227](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/227))

    * Test Code:
       * Wrote additional tests for existing features to increase coverage ([\#118](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/118))
       * Wrote useful classes for testing, such as ExpenseBuilder, ExpenseBookBuilder, Typical Expenses. ( [\#118](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/118))

* **Documentation**:
   * User Guide: ([\#162](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/162))
      * Added documentation for the features `view expense`
      * Added documentation for the features `view-c`
      * Added documentation for the features `sort-a`
      * Added documentation for the features `sort-t`

   * Developer Guide:
      * Added implementation details of `sort-a`, `sort-t`, `view index`, `view-c`. ([\#267](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/267)) ([\#130](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/130))
      * Added UML diagram for `sort-a`, `sort-t`, `view index`, `view-c`. ([\#130](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/130))
      * Added use cases details of `sort-a`, `sort-t`, `view index`, `view-c`. ([\#30](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/30))

* **Review/mentoring contributions**:
   * Help to review, approve and merge the pull requests. ([\#236](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/30), [\#123](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/123), [\#52](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/52), [\#233](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/233))
   * Solve issues reported along the project development and PE-dry run. [issues solved](https://github.com/AY2021S1-CS2103T-W10-1/tp/issues?q=is%3Aissue+is%3Aclosed+assignee%3Ayyutong)

* **Contributions beyond the project team**:
   * Evidence of helping others:
       * Report the bugs I found during PE-dry run [PED](https://github.com/yyutong/ped/issues)
       * Discuss related questions with peers in the forum [forum posts](https://nus-cs2103-ay2021s1.github.io/dashboards/contents/forum-activities.html#58-yang-tong-yyutong-7-posts)
