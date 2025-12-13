Describe your testing strategy and which functionalities you targeted for testing (S6).
How did you analyse test results to identify and fix errors int he code (S4)?
What different debugging approaches did you try and how did your tests improve code quality (S4)?
How did you decide which test cases were most important and what was your experience with TDD (S6)?

## Testing Strategy
*In this section I will be outlining the testing strategy that I employed for the AccountTest and SavingsAccountTest classes within the solution. The goal was to provide correctness, ensuring the solution was robust and provided maintainability of the core functionalities through the use of systematic unit testing.*

I adpoted a systematic unit testing approach using JUnit, to validate the core functionalities of both AccountTest and SavingsAccontTest. The strategy focused on correctness, roubustness and maintainability. Below is a brief overview of the main functionalities that were tested inside of the fincore solution:

*Deposit functionality (Account)
For the Account class to ensure deposits functionality I focused on the positive deposit which increases the balance and return success.
With any negative deposits it was important to ensure they would be rejected, therefore the balance remained unchanged.
*Withdraw functionality(Account)
To ensure the withdraw functionality worked having a test for withdraw functionality, the valid withdrawal reduced the balance.
Meaning any overdrawn would fail, again ensuring those attempts were blocked and the balance remained the same.

*String Representation(toString)
There is also string representation using the toString() function that outputs the correctly formatted account details. Inside of the SavingAccount class I have used applyInterestRate() to demonstrate the testing of interest application it correcly calculates and adds the interest. There is also interest rate management using the setInterestRate() that accepts valid rates and rejects the invalid ones. 
This coverage ensured that both business-critical operations and edge cases were tested, while also validating subclass inheritance behavior.

## Test Result Analysis and Error Indentification 
*Throughout this section I will provide test result analysis, explaining where I applied the test results and also identification of errors.*

To analyze the test results and indentify errors I followed a structured process:

Starting with assertion failures these were primary indicators of logical flaws, due to mismatches between expected and actual behavior. Example: In depositShouldIncrease, the test incorrectly used assertFalse(result) when a successful deposit should return true. Which reavealed a logical flaw in the test design.
Boundary testing: Negative deposits and overdraw attempts highlighted edge cases requiring validation logic. Also console ouput checks used for intermediate verification of changes to the balance and interest application during debugging. This interative analysis helped me to quickly indentify logical errors and mismatched expectations.

## Debugging Approaches 
*In this section I will be discussing a few debugging techiques that I employed for refinning and improving the code.*
To refine and improve the code, I employed multiple techniques. 

Debbuger: Using the IDE debugger I was able to step through execution to inspect method flows and variable states.

Test refactoring:Refactoring tests by isolating failing logic in order to confirm any assumptions and reduce the noise in error detection.

Manual verification: Using the console ourputs to cross-check intermediate states against any expected outcomes.
Those approaches helped me to be able to identify incorrect assertions, formatting mismatches in the toString() and logic errors in deposit() and withdraw() methods.

## How Tests Improved Code Quality 
*Here I will be explaining why tests help to improve the code quality.*

My tests helped to contribute to code quality in these meaningful ways:
A key way was in preventing regressions, the tests did this by catching unintended changes within the behavior of the code. Enforcing input validations, for instance rejecting negative deposits and invalid interest rates, the rejections were consitent.
They also helped to improve readability and maintainbility by documenting expected behavior through test cases. Lastly they encouraged modular design by testing methods in isolation aiding in promoting cleaner archecture.

## Priotization of Test Cases
*This sections provides a look at prioritized test cases.*
Heres a breakdown of some of the pritiozation of test cases based on the following criteria:

- Business-Critical operations: Deposit, withdraw and interest applications have a direct impact on the user balances.

- Edge cases and invalid inputs: These are the most common sources of bugs and vulnerabilites within the code.

- Inheritance behavior: Making sure the SavingsAccount correctly extends and overrides the Account functionality.
  
Prioritizing those criterias ensured that the most error-prone areas got tested first, aligning with the wider objectives of the Fincore solution overall.


## Justification of Test Case selection
*Here I will justify why I shows the test cases.*
I selected the test cases based on their risk level and business importance, for instance high-risk operations would be deposit and withdraw as these directly affect account balances. Any error involving those two functionalities could cause financial inconsistencies, so it was important to prioritize those first. 
Medium risk operations like the interest application and rate management. Errors in interest calculations could lead systemic issues over time. So those were tested to ensure accuracy and validation.
Low risk operations (toString): While the lower risk functionalities would not be critical to financial correctness, formatting errors reduce usability and debugging clarity so including those tests helped to improve maintainability.
This risk-based prioziation helped me to ensure that the most error-prone and impactful areas of the system were tested first, aligning with the wider objectives of robustness and reliabilty.

## Influence of TDD on Implementation Approach 
*This section provides details around the influence TTD had on implementation*

Test Driven Development helped to shape my implementation in several different ways:

Method design influenced by tests: Writing the tests first meant methods like deposit() and withdraw() had to return boolean flags to indicate success/failure, aligning with test expectations. 
Validation of logic introduced earlier on: Tests for negative deposits and invalid interest rates forced me to add input validation before implementation was complete.
Readable outputs enforced: The toString() test required clear, formatted string, influencing how the account details were strcutured. 
Refactoring tests: With tests covering core behaviors, I could safely refine methods without the fear of regressions.

Overall, TDD encouraged incremental; development, where each new feature was validated by a failing test that later passed once the implementation was corrected.

## Coverage Decisions
*This final section provides details around why coverage decisions were made*
My coverage decisions were based on balancing breadth and depth:
Breadth: Ensured that all major functionalities(deposit, withdraw, interest, Tostring) were tested.
Depth; Focused on edge cases (negative deposits, overdraw attempts, invalid interest rates) to catch potential vulnerabilities.
Inheritance validation: Tested that SavingsAccount correctly extended Account without breaking parent functionality. 
Excluded Areas: I did not yet test concurrency or mutli-threadded access, as these were outside the current scope. Future coverage could expand into performance and stress testng.
This systematic coverage helped to ensure both corectness and resilience against invalid inputs.