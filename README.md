Describe your testing strategy and which functionalities you targeted for testing (S6).
How did you analyse test results to identify and fix errors int he code (S4)?
What different debugging approaches did you try and how did your tests improve code quality (S4)?
How did you decide which test cases were most important and what was your experience with TDD (S6)?

## Testing Strategy
*In this section I will be outlining the testing strategy that I employed for the AccountTest and SavingsAccountTest classes within the solution. The goal was to provide correctness, ensuring the solution was robust and provided maintainability of the core functionalities through the use of systematic unit testing.*

I adpoted a unit testing approach using JUnit. Below is a brief overview of the main functionalities that were tested inside of the fincore solution. 

For the Account class to ensure deposit functionality I focused on the positive deposit which increases the balance and negative deposit which meant it would be rejected. To ensure the withdraw functionality works having a test for withdraw functionality, the valid withdrawal reduces balance and Overdraw attempts are blocked. There is also string representation using the toString() function that outputs the correctly formatted account details. Inside of the SAVINGAccount class I have used applyInterestRate() to demonstrate the testing of interest application it correcly calculates and adds the interest. There is also interest rate management using the setInterestRate() that accepts valids rates and rejects the invalid ones. 

## Test Result Analysis and Error Indentification 
*Throughout this section I will provide test result analysis, explaining where I applied the test results and also identification of errors.*

To analyze the test results and indentify errors I followed a structured process:

Starting with Assertion failures these were my main indicators of logical flaws. For example in the depositShouldIncrease, the test inccorectly asserts assertFalse(result) when a sucessful deposit should return true. Which helped me to spot a mismatch between expected and actual behavior.
Boundary testing such as the depositing negative ammounts realeved edge cases that needed handling. Console ouput from methods like checkBalance() and applyInterest() were used to manually verify intermediate states whilst debugging.

## Debugging Approaches 
*In this section I will be discussing a few debugging techiques that I employed for refinning and improving the code.*

One of the techniques that I employed in order to refine and improve the could was stepping through in the debugger inside the IDE this was to inspect the different states and the method flows. Also refactoring tests to isolate any failing logic in oder to comfirm any assumptions. Those approaches helped me to be able to identify incorrect assertions, formatting mismatches in the toString() and logic errors in deposit() and withdraw() methods.

## How Tests Improved Code Quality 
*Here I will be explaining why tests help to improve the code quality.*

My tests helped to contribute to code quality in these meaningful ways:
A key way was in preventing regressions, the tests did this by catching unintended changes within the behavior of the code. Enforcing input validations, for instance rejecting negative deposits and invalid interest rates. They also helped to improve readability and maintainbility by documenting expected behavior through test cases. Lastly they encouraged modular design by testing methods in isolation.

## Priotization of Test Cases
*This final sections provides a look at prioritized test cases.*
Heres a breakdown of some of the pritiozation of test cases based on the following criteria:

- Business-Critical operations: Deposit, withdraw and interest applications have a direct impact on the user balances.

- Edge cases and invalid inputs: These are the most commons sources of bugs and vulnerabilites within the code.

- Inheritance behavior: Making sure the SavingsAccount correctly extends and overrides the Account functionality.
  
Prioritizing those criterias ensured that the most error-prone areas got tested first, aligning with the wider objectives of the Fincore solution overall.








