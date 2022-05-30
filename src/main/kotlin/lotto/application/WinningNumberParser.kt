package lotto.application

object WinningNumberParser {
    private const val DEFAULT_DELIMITER = ","

    fun parse(inputStr: String): Set<Int> {
        val result = inputStr.replace(" ", "").split(DEFAULT_DELIMITER)
        return result.mapNotNull { it.toIntOrNull() }.toSet()
    }
}
