package lotto.util

class SplitString private constructor(
    val delimiter: Regex = DEFAULT_DELIMITER_REGEX,
    val targetString: String,
) {
    init {
        targetString.split(delimiter).map { it.toInt() }.forEach { if (it < 0) throw RuntimeException() }
    }

    fun extractNumbers(): List<String> = this.targetString.split(delimiter)

    companion object {
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
        private val DEFAULT_DELIMITER_REGEX = ", ".toRegex()
        private const val FORMULA_PATTERN_SIZE_LIMIT = 3

        fun of(input: String?): SplitString {
            require(input.isNullOrEmpty().not()) { "지난주 당첨 번호를 입력해주세요." }
            return CUSTOM_DELIMITER_REGEX.find(input!!)?.let {
                buildCustomDelimiterFormula(it)
            } ?: SplitString(targetString = input)
        }

        private fun buildCustomDelimiterFormula(matchResult: MatchResult): SplitString {
            require(matchResult.groupValues.size == FORMULA_PATTERN_SIZE_LIMIT)
            val (_, customDelimiter, expression) = matchResult.groupValues
            return SplitString(delimiter = customDelimiter.toRegex(), targetString = expression)
        }
    }
}
