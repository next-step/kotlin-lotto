package calcuator

class AddRequest(
    val numbers: List<Int>
) {
    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        fun from(input: String): AddRequest = AddRequest(toNumbers(input))

        private fun toNumbers(input: String): List<Int> = input
            .split(COMMA_DELIMITER, COLON_DELIMITER)
            .map { it.toInt() }
    }
}
