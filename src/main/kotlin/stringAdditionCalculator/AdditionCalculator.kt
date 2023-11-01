package stringAdditionCalculator

class AdditionCalculator(private val stringParser: StringParser = StringParser()) {
    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }

        return stringParser.parseToInt(input).sum()
    }
}
