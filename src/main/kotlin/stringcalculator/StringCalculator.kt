package stringcalculator

object StringCalculator {
    private val CUSTOM_SEPARATOR_DELIMITER_PATTERN = "//(.*?)\\\\n".toRegex()
    private val NUMBER_PATTERN = "\\d+".toRegex()
    private val NON_NUMBER_PATTERN = "[^\\d]+".toRegex()

    private val EMPTY_INITIALIZATION: Pair<Separators, List<Number>> =
        Pair(Separators(), listOf(Number(0)))

    fun calculate(input: String): Int {
        val initialization =
            if (input.isBlank()) {
                initializeForBlankInput()
            } else {
                initializeWithInput(input)
            }

        val separators = initialization.first
        val numbers = initialization.second
        validate(input, separators, numbers)
        return numbers.reduce { acc, number -> acc.plus(number) }.amount
    }

    private fun initializeForBlankInput(): Pair<Separators, List<Number>> {
        return EMPTY_INITIALIZATION
    }

    private fun initializeWithInput(input: String): Pair<Separators, List<Number>> {
        val separators = extractSeparators(input)
        val numbers = extractNumbers(input)

        return Pair(separators, numbers)
    }

    private fun extractSeparators(input: String): Separators {
        val pattern = CUSTOM_SEPARATOR_DELIMITER_PATTERN
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
        val cleanedInput = input.replaceFirst(CUSTOM_SEPARATOR_DELIMITER_PATTERN, "")
        return NUMBER_PATTERN.findAll(cleanedInput)
            .map { Number(it.value) }
            .toList()
    }

    private fun validate(
        input: String,
        separators: Separators,
        numbers: List<Number>,
    ) {
        val cleanedInput = input.replaceFirst(CUSTOM_SEPARATOR_DELIMITER_PATTERN, "")
        val nonNumberMatches = NON_NUMBER_PATTERN.findAll(cleanedInput).map { it.value }.toList()
        checkNonMatchSeparator(nonNumberMatches, separators)
        checkInputFomula(nonNumberMatches, numbers)
    }

    private fun checkNonMatchSeparator(
        nonNumberMatches: List<String>,
        separators: Separators,
    ) {
        require(nonNumberMatches.all { separators.isExist(it) }) {
            "입력에 유효하지 않은 구분자가 포함되어 있습니다."
        }
    }

    private fun checkInputFomula(
        nonNumberMatches: List<String>,
        numbers: List<Number>,
    ) {
        require(nonNumberMatches.size == numbers.size - 1) { "입력 형식이 올바르지 않습니다." }
    }
}
