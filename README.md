# kotlin-lotto
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
