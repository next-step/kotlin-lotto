package calculator.stringcalculator.splitter

object DefaultDelimiterSplitter : Splitter<String, List<String>> {
    private val DELIMITER_REGEX = "[,:]".toRegex()
    private val DEFAULT_RETURN_VALUE = listOf("")

    override fun supported(input: String): Boolean = true

    override fun split(input: String): List<String> {
        return if (input.isBlank()) DEFAULT_RETURN_VALUE
        else input.split(DELIMITER_REGEX).map { it.trim() }
    }
}
