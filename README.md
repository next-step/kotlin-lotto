# kotlin-lotto

## Step 1 - String Addition Calculator

Create test cases that cover the functionality described below. Iterate over test and code refactoring until all the
requirements are met

1. Implement basic addition with default delimiters:
    - "" should return 0
    - "1,2" should return 3
    - "1,2:3" should return 6
2. Support custom delimiters specified between // and \n:
    - "//;\n1;2;3" should return 6
    - Delimiter not specified in the input beginning shouldn't be considered as one
3. Handle errors:
    - Non-numeric values or Negative Numbers should throw a RuntimeException