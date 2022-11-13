package step1


private const val DEFAULT_RETURN_VALUE = 0

class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            if (input.isNullOrEmpty()) return DEFAULT_RETURN_VALUE

            return StringParser.splitBySeparator(input)
                .map { stringNumber -> PositiveInt.of(stringNumber) }
                .reduce(PositiveInt::plus)
                .value
        }


    }
}
