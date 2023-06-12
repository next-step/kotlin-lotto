package calculator.stringcalculator.splitter

object DefaultDelimiterSplitter : StringSplitter() {
    private val DELIMITER_REGEX = "[,:]".toRegex()
    private val DEFAULT_RETURN_VALUE: List<String> = emptyList()

    override fun supported(input: String): Boolean = true

    override fun split(input: String): List<String> =
        if (input.isBlank()) DEFAULT_RETURN_VALUE
        else input.split(DELIMITER_REGEX).map { it.trim() }
}
