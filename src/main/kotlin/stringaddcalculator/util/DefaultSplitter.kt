package stringaddcalculator.util

object DefaultSplitter : AbstractSplitter {
    private const val DEFAULT_DELIMITER1 = ","
    private const val DEFAULT_DELIMITER2 = ":"

    override fun split(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER1, DEFAULT_DELIMITER2)
    }
}
