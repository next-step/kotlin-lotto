package calculator.domain

/**
 * 계산을 하는 클래스.
 * Created by Jaesungchi on 2022.05.21..
 */
object Calculator {
    private val DEFAULT_SEPARATORS = listOf(Separator(":"), Separator(","))
    fun getResultOfCalculate(input: String?): Int {
        // 빈 문장 또는 null이 입력되면 0을 반환 한다.
        if (input.isNullOrBlank()) {
            return 0
        }
        val numbers = getNumberList(input)
        return numbers.reduce { left, right -> left + right }.value
    }

    private fun getNumberList(input: String): List<Operand> {
        return input.split(
            "[${DEFAULT_SEPARATORS.joinToString("")}]".toRegex()
        ).map { Operand.of(it) }
    }
}
