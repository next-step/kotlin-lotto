package study.calculator

class StringAddCalculator(
    private val parser: Parser<String, List<Int>>,
    private val validagtors: NumberValidators
) {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return DEFAULT_NUMBER

        val intNumbers = parser.parse(text)
        validagtors.validates(intNumbers)

        return calculateSum(intNumbers)
    }

    private fun calculateSum(numbers: List<Int>): Int = numbers.sum()

    private companion object {
        const val DEFAULT_NUMBER = 0
    }
}
