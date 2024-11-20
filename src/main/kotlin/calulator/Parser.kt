package calulator

object Parser {
    fun parse(text: String): Numbers {
        if (text.isBlank()) {
            return Numbers(emptyList())
        }

        val matchResult = Regex("//(.)\n(.*)").find(text)
        val numbers = if (matchResult != null) {
            getNumbersByCustomDelimiter(matchResult)
        } else {
            getNumbersByDefaultDelimiter(text)
        }

        return Numbers(numbers.map { it.toInt() })
    }

    private fun getNumbersByCustomDelimiter(matchResult: MatchResult): List<String> {
        val delimiter = matchResult.groupValues[1]
        val nums = matchResult.groupValues[2]
        return nums.split(delimiter)
    }

    private fun getNumbersByDefaultDelimiter(text: String) = text.split("[,:]".toRegex())
}
