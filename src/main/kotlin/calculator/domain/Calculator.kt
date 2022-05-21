package calculator.domain

/**
 * 계산을 하는 클래스.
 * Created by Jaesungchi on 2022.05.21..
 */
object Calculator {
    private val CUSTOM_REGEX = Regex("//(.)\n(.*)")
    private val DEFAULT_SEPARATORS = listOf(Separator(":"), Separator(","))

    fun getResultOfCalculate(input: String?): Int {
        // 빈 문장 또는 null이 입력되면 0을 반환 한다.
        if (input.isNullOrBlank()) return 0

        return getNumberList(input).reduce { left, right -> left + right }.value
    }

    private fun getNumberList(input: String): List<Operand> {
        val result = CUSTOM_REGEX.find(input)
        return if (result != null) {
            val customDelimiter = Separator(result.groupValues[1])
            result.groupValues[2].split(customDelimiter.value).map { Operand.of(it) }
        } else {
            input.split(getDefaultRegex()).map { Operand.of(it) }
        }
    }

    private fun getDefaultRegex(): Regex {
        return "[${DEFAULT_SEPARATORS.joinToString("|")}]".toRegex()
    }
}
