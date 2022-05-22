package stringaddcalculator

// 이전 코드
class Parse(private var formula: String, delimiters: List<String>) {
    init {
        val regexResult = Regex(Pattern.CUSTOM_DELIMITER).find(formula)

        regexResult?.let {
            formula = regexResult.groupValues[2]
        }
    }

    val result: List<Int> =
        formula
            .split(delimiters.joinToString("|").toRegex())
            .map { if (it.isEmpty()) 0 else it.toPositiveIntOrThrow() }

    private fun String.toIntOrThrow() = requireNotNull(toIntOrNull()) { "올바른 계산식이 아닙니다." }

    private fun String.toPositiveIntOrThrow(): Int {
        val number = toIntOrThrow()

        require(number > 0) { "음수는 계산 할 수 없습니다." }

        return number
    }
}
