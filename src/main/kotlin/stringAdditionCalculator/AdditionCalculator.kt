package stringAdditionCalculator

class AdditionCalculator(private val stringParser: StringParser = StringParser()) {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }

        return stringParser.parseToInt(input).sum()
    }
}
