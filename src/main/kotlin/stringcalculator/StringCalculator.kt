package stringcalculator

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }

        val splitInputs = splitInput(input)

        return splitInputs.sum()
    }

    private fun splitInput(input: String): Numbers {
        val matchResult = CUSTOM_DELIMITER_FIND_REGEX.find(input)

        return if (matchResult != null) {
            splitByCustomDelimiter(matchResult)
        } else {
            splitByDefaultDelimiter(input)
        }
    }

    private fun splitByCustomDelimiter(matchResult: MatchResult): Numbers {
        val customDelimiter = matchResult.groupValues[1]
        val splitTarget = matchResult.groupValues[2]

        return Numbers.from(splitTarget.split(customDelimiter))
    }

    private fun splitByDefaultDelimiter(input: String): Numbers =
        Numbers.from(input.split(DEFAULT_DELIMITER_REGEX))

    companion object {
        private val CUSTOM_DELIMITER_FIND_REGEX = Regex("//(.)\\\\n(.*)")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    }
}
