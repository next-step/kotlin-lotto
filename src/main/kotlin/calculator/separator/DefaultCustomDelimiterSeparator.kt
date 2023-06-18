package calculator.separator

import calculator.vo.Delimiter

object DefaultCustomDelimiterSeparator : CustomDelimiterSeparator {
    private val SEARCH_PATTERN = Regex("""//(.)\\n(.*)""")

    override fun separateFrom(target: String): Pair<Delimiter?, String> {
        val searchResult = SEARCH_PATTERN.find(target)
            ?: return null to target

        val delimiterCandidate = searchResult
            .groupValues[1]
            .toCharArray()[0]

        val delimiter = Delimiter(delimiterCandidate)
        val separatedInput = searchResult.groupValues[2]

        return delimiter to separatedInput
    }
}
