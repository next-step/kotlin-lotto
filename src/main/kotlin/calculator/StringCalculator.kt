package calculator

object StringCalculator {

    private const val BASE_DELIMETER_COMMA = ','
    private const val BASE_DELIMETER_COLON = ':'

    fun calculate(input: String): Int {
        val nums = splitNum(input)
        return nums.sum()
    }

    private fun splitNum(input: String): List<Int> {
        return input.split(BASE_DELIMETER_COMMA, BASE_DELIMETER_COLON).map { it.toInt() }
    }
}
