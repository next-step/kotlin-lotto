# kotlin-lotto

## String Add Calculator

- [x] return 0 for empty or null strings
- [x] Return the number if the string contains only one number
- [x] Return the sum when two numbers are separated by commas
- [x] Allow both comma and colon as delimiters
- [x] Support custom delimiters between // and \n
- [x] Throw RuntimeException if negative numbers are present

## Lotto (Auto)

Amount

- [x] must be above 1,000, below 100,000

LottoNumber

- [x] number must be between 1 and 45 (inclusive)
- [x] numbers are cached

Lotto

- [x] must contain 6 numbers
- [x] numbers must be sorted

LottoMachine

- [x] insert amount and create lotto which costs 1,000 KRW for each
- [x] all decimals are discarded when divided by 1,000

WinningNumber

- [x] must contain 6 numbers

Prize

- [x] enum for all prizes
- [x] provides match count, prize value, and function matcher

Lottery

- [x] get prizes according to lottos and winning numbers
- [x] calculate return rate
