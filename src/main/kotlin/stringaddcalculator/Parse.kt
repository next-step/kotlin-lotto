package stringaddcalculator

class Parse(private var formula: String, delimiters: List<String>) {
    init {
        val regexResult = Regex("//(.)\n(.*)").find(formula)

        regexResult?.let {
            formula = regexResult.groupValues[2]
        }
    }

    val result: List<Int> =
        formula
            .split(delimiters.joinToString("|").toRegex())
            .map { if (it.isEmpty()) 0 else it.toPositiveIntOrThrow() }

    private fun String.toIntOrThrow() = toIntOrNull() ?: throw IllegalArgumentException("올바른 계산식이 아닙니다.")

    private fun String.toPositiveIntOrThrow() = if(toIntOrThrow() > 0) toInt() else throw RuntimeException("음수는 계산 할 수 없습니다.")
}