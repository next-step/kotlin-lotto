package calculator

class SplitHelper {

    fun split(input: String): List<String> = input.split(
        DELIMITER_COMMA, DELIMITER_COLON
    )

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
    }
}
