package calculator.splitter

object CustomDelimiterSplitter : Splitter {
    private val customDelimiterRegex = "//(.)\\n(.*)".toRegex()

    override fun isApplicable(input: String): Boolean = customDelimiterRegex.matches(input)

    override fun trySplit(input: String): List<String> {
        val matchResult = customDelimiterRegex.matchEntire(input)!!
        val delimiter = matchResult.groupValues[1]
        val numberString = matchResult.groupValues[2]
        return numberString.split(delimiter)
    }
}
