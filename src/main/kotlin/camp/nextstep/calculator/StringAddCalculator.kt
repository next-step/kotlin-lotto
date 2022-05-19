package camp.nextstep.calculator

object StringAddCalculator {

    private val EXPRESSION_PATTERN = Regex("""^(//(.)\n)?((\d+(\2|[,:])?)+)$""")
    private val DEFAULT_DELIMITERS = Regex("[,:]")

    fun calculate(exp: String?): Int {
        if (exp.isNullOrBlank()) return 0
        val matchResult = EXPRESSION_PATTERN.matchEntire(exp) ?: throw RuntimeException("올바른 표현식을 입력해주세요.")

        val (_, delimiter, validExp) = matchResult.destructured
        val stringNumbers = if (delimiter.isNotEmpty()) validExp.split(delimiter) else validExp.split(DEFAULT_DELIMITERS)
        val numbers = mapToInt(stringNumbers)

        if (!isPositiveNumbers(numbers)) throw RuntimeException("양수만 입력해주세요.")

        return numbers.sum()
    }

    private fun mapToInt(stringNumbers: List<String>): List<Int> {
        return try {
            stringNumbers.map { it.toInt() }
        } catch (numberFormatException: NumberFormatException) {
            throw RuntimeException("올바른 구분자와 숫자를 입력해주세요.")
        }
    }

    private fun isPositiveNumbers(numbers: List<Int>): Boolean {
        return numbers.filter { it < 0 }.take(1).isEmpty()
    }
}
