# kotlin-lotto
## Step 2 
### Programming Requirements
- All features must be implemented using TDD, and each must have corresponding unit tests (excluding UI logic).
  - Separate core logic from UI logic.
  - Use dedicated classes such as InputView and ResultView for UI-related code.
- Limit indentation depth to 1 (must not exceed 2).
  - For example, a while loop with an if inside results in a depth of 2.
  - 💡 Tip: Extract functions/methods to reduce indentation.
- Keep each function/method under 15 lines.
  - Ensure each function does only one thing.

### Implementation
### LottoNumber
- [x] Wrap the Int value of lotto number
- [x] Number should be in between 1 and 45

### Lotto
- First class collection of LottoNumber
- [x] Should have only 6 numbers of LottoNumber
- [x] Return whether a number is in Lotto

### LottoMachine
- [x] Generate Lotto

### WinningLotto
- [x] Has one Lotto as a combination
- [x] Return how many numbers are matched in WinningLotto with other 

### Rank
- [x] enum class which means rank and has prize money
- [x] Return the rank by using match count

### InputView
- [x] Get purchase amount
- [x] Get winning numbers

### ResultView
- [x] Display all the lotto generated
- [x] Display Winning Statistics
- [x] Display total return rate

### WinningStatistics
- [x] Store the count for each rank
- [x] Calculate profit
- [x] Return the count by rank

---

## Step 1 String Addition Calculator
### Programming Requirements
- Keep indentation depth to 1 (do not exceed 2 levels).
    - e.g., an if inside a while equals 2 levels and should be avoided.
- 💡 Hint: Split logic into functions to reduce indentation.
- Each function should be no longer than 10 lines.
- Each function should perform a single responsibility.

## Implementation
### String Calculator
- [x] return the sum of the numbers split by delimiters.
    - [x] comma can be used as delimiters (,)
    - [x] colon can be used as delimiters (:)
    - [x] a custom delimiter can be specified. A custom delimiter is defined between // and \n.
- [x] If the input contains non-numeric values or negative numbers, throw a RuntimeException.
