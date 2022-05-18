package calculator

private val customDelimiterRegex = "//(.)\\n(.*)".toRegex()

sealed interface StringCalculatorProperties {
    val delimiters: Array<String>
    val numberString: String

    fun getPositiveInts(): List<Int> = numberString.split(*delimiters).map { it.toPositiveInt() }

    private fun String.toPositiveInt(): Int = toInt().takeIf { it >= 0 } ?: throw IllegalArgumentException("음수가 아닌 정수를 입력해주세요.")

    companion object {
        fun of(input: String): StringCalculatorProperties = when (customDelimiterRegex.matches(input)) {
            true -> CustomStringCalculatorProperties(input)
            false -> DefaultStringCalculatorProperties(input)
        }
    }
}

private class DefaultStringCalculatorProperties(input: String) : StringCalculatorProperties {
    override val delimiters: Array<String> = arrayOf(",", ":")
    override val numberString: String = input
}

private class CustomStringCalculatorProperties(input: String) : StringCalculatorProperties {
    override val delimiters: Array<String>
    override val numberString: String

    init {
        val matchResult = customDelimiterRegex.matchEntire(input)!!
        delimiters = arrayOf(matchResult.groupValues[1])
        numberString = matchResult.groupValues[2]
    }
}
