package calculator.splitter

object DefaultDelimiterSplitter : Splitter {
    private val defaultDelimiterRegex = "[\\d|,|:]+".toRegex()

    override fun isApplicable(input: String): Boolean = defaultDelimiterRegex.matches(input)

    override fun trySplit(input: String): List<String> = input.split(",", ":")
}
