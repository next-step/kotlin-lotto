package step1

class StringAddCalculator(
    vararg delimiter: String = DEFAULT_DELIMITERS
) {
    companion object {
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
        private const val REGEX_DELIMITER = "|"
        private const val REGEX_PREFIX = "("
        private const val REGEX_POSTFIX = ")"
        private const val REGEX_INPUT_PARSING = "//(.*)\n(.*)"
        private const val ESCAPE_CHARACTER = '\\'
    }

    private val delimiterRegex: Regex

    init {
        delimiterRegex = delimiterRegex(listOf(*delimiter))
    }

    /**
     * @param input input string
     * @return sum for all numbers containing input string
     */
    fun calculate(input: String?): Int {
        // 1. Null or Blank check
        if (input.isNullOrBlank()) {
            return 0
        }

        // 2. Parse input string, output: Delimiter Regex, Input Number String containing delimiter
        val (regex: Regex, inputNumberString: String) = parse(input)

        // 3. convert Input Number String to Input Number List by using delimiter regex
        val inputNumberList = inputNumberString.trim()
            .split(regex)
            .asSequence()
            .map { it.toInt() }
            .toList()

        require(inputNumberList.none { it < 0 }) {
            "Negative number is not supported [$input]"
        }

        // 4. add all numbers
        return inputNumberList.sum()
    }

    /**
     * @param input input string
     * @return Regex of delimiter, Input String containing only numbers and delimiter
     */
    private fun parse(input: String): Pair<Regex, String> {
        val result = Regex(REGEX_INPUT_PARSING).find(input)

        return result?.let {
            Pair(delimiterRegex(it.groupValues[1]), it.groupValues[2])
        } ?: Pair(delimiterRegex, input)
    }

    /**
     * @param delimiter delimiter string
     * @return Regex of delimiter
     */
    private fun delimiterRegex(delimiter: String): Regex {
        return delimiterRegex(delimiter.chunked(1))
    }

    /**
     * @param delimiterList delimiter string list
     * @return Regex of delimiter
     */
    private fun delimiterRegex(delimiterList: List<String>): Regex =
        Regex(
            delimiterList.joinToString(REGEX_DELIMITER, REGEX_PREFIX, REGEX_POSTFIX) {
                "$ESCAPE_CHARACTER$it"
            }
        )
}
