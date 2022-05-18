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
            .map { if (it == "") 0 else it.toIntOrThrow() }

    private fun String.toIntOrThrow() = toIntOrNull() ?: throw IllegalArgumentException("올바른 계산식이 아닙니다.")
}