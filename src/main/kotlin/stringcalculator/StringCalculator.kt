package stringcalculator

class StringCalculator(input: String) {
    private val separators: Separators
    private val numbers: List<Number>

    init {
        val initialization =
            if (input.isBlank()) {
                initializeForBlankInput()
            } else {
                initializeWithInput(input)
            }

        this.separators = initialization.first
        this.numbers = initialization.second
        validate(input)
    }

    private fun initializeForBlankInput(): Pair<Separators, List<Number>> {
        return Pair(Separators(), listOf(Number(0)))
    }

    private fun initializeWithInput(input: String): Pair<Separators, List<Number>> {
        val separators = extractSeparators(input)
        val numbers = extractNumbers(input)

        return Pair(separators, numbers)
    }

    private fun extractSeparators(input: String): Separators {
        val pattern = CUSTOM_SEPARATOR_DELIMITER_PATTERN.toRegex()
        val allMatches = pattern.findAll(input).toList()
        return allMatches.fold(Separators()) { tempSeparator, match ->
            val potentialSeparator = extractSeparatorFromMatch(match)
            return tempSeparator.addSeparator(potentialSeparator)
        }
    }

    private fun extractSeparatorFromMatch(match: MatchResult): String {
        val groupValues = match.groupValues
        if (groupValues.size > 1) {
            return groupValues[1]
        }
        throw IllegalArgumentException("유효한 구분자를 포함하지 않는 매치입니다.")
    }

    private fun extractNumbers(input: String): List<Number> {
        val cleanedInput = input.replaceFirst(CUSTOM_SEPARATOR_DELIMITER_PATTERN.toRegex(), "")
        return NUMBER_PATTERN.toRegex().findAll(cleanedInput)
            .map { Number(it.value) }
            .toList()
    }

    private fun validate(input: String) {
        val cleanedInput = input.replaceFirst(CUSTOM_SEPARATOR_DELIMITER_PATTERN.toRegex(), "")
        val nonNumberMatches = NON_NUMBER_PATTERN.toRegex().findAll(cleanedInput).map { it.value }.toList()
        checkNonMatchSeparator(nonNumberMatches)
        checkInputFomula(nonNumberMatches)
    }

    private fun checkNonMatchSeparator(nonNumberMatches: List<String>) {
        require(nonNumberMatches.all { separators.isExist(it) }) {
            "입력에 유효하지 않은 구분자가 포함되어 있습니다."
        }
    }

    private fun checkInputFomula(nonNumberMatches: List<String>) {
        require(nonNumberMatches.size == numbers.size - 1) { "입력 형식이 올바르지 않습니다." }
    }

    fun calculate(): Int {
        return numbers.reduce { acc, number -> acc.plus(number) }.amount
    }

    companion object {
        private const val CUSTOM_SEPARATOR_DELIMITER_PATTERN = "//(.*?)\\\\n"
        private const val NUMBER_PATTERN = "\\d+"
        private const val NON_NUMBER_PATTERN = "[^\\d]+"
    }
}
