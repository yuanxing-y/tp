---
layout: page
title: Zhang Yuanxing's Project Portfolio Page
---
## Project: UniSave

UniSave is a desktop finance planner app, optimized for use via a Command Line Interface (CLI) while still having
the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **New Feature**: Added SetBudget Command `set-b` that allows the user to set a budget for UniSave.
* **New Feature**: Added ShowBudget Command that allows the user to check the latest budget and remaining budget.
  * Highlights: The response of this command is moved to UI panel at Milestone v1.4.
* **New Feature**: Added Exchange Command  `exchange` that allows the user to convert the currency for the whole expense book.
  * Justification: This is the feature distinct UniSave from other expense book, it allows a currency conversion of 168 currencies.
* **New Feature**: Added Currencies Command `show-codes` that displays a table of currency codes with the corresponding currency full names.
* **New Feature**: Added Rates Command `show-rates` that allows the user to check the exchange rates from SGD.

* Credits: *{The exchange rates, currency codes with corresponding full names are adopted from 
[currencylayer](https://currencylayer.com/) on 2020-10-31, but are converted into java code by me.}*

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=yuanxing-y&tabRepo=AY2021S1-CS2103T-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

* **Enhancements to existing features**:
  * Wrote additional tests for existing features to increase coverage by 12.98% (Pull requests [\#240](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/240))

* **Documentation**:
  * User Guide:
    * Change the flow of User Guide [\#240](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/240)
    * Added documentation for the features `set-b`, `exchange`, `show-rates`, `show-codes` [\#240](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/240)
  * Developer Guide:
    * Reorder the flow for USS (Pull request [\#42](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/42))
    * Update Overview Session ([\#260](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/260]))
    * Added implementation details of the `set-b`, `exchange` feature.
    * Added use cases for `Set Budget`, `Exchange Currency` feature.([\#279](https://github.com/AY2021S1-CS2103T-W10-1/tp/pull/279))
    * Update UML diagram for `Model`, `Expense class`, `Set Budget Activity Diagram`, `Set Budget Sequence Diagram`, `Exchange Activity Diagram`, `Exchange Sequence Diagram`.

* **Community**:
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/yuanxing-y/ped/issues/1), [2](https://github.com/yuanxing-y/ped/issues/2), [3](https://github.com/yuanxing-y/ped/issues/3))
