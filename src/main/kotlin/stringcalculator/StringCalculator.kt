package stringcalculator

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }

        val splitInputs = splitInput(input)
        validate(splitInputs)

        return add(splitInputs)
    }

    private fun splitInput(input: String): List<String> {
        val matchResult = CUSTOM_DELIMITER_FIND_REGEX.find(input)

        return if (matchResult != null) {
            splitByCustomDelimiter(matchResult)
        } else {
            splitByDefaultDelimiter(input)
        }
    }

    private fun splitByCustomDelimiter(matchResult: MatchResult): List<String> {
        val customDelimiter = matchResult.groupValues[1]
        val splitTarget = matchResult.groupValues[2]

        return splitTarget.split(customDelimiter)
    }

    private fun splitByDefaultDelimiter(input: String) =
        input.split(DEFAULT_DELIMITER_REGEX)

    private fun validate(splitInputs: List<String>) {
        splitInputs.map {
            it.toIntOrNull()
        }.forEach {
            require(it != null && it >= 0) { "문자열 계산기에는 0, 양수만 인자로 올 수 있습니다!" }
        }
    }

    private fun add(splitInputs: List<String>) =
        splitInputs.fold(0, { accu, curr -> accu + curr.toInt() })

    companion object {
        private val CUSTOM_DELIMITER_FIND_REGEX = Regex("//(.)\\\\n(.*)")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    }
}
