package calculator

class Calculator {
    companion object {
        val INTEGER_REGEX = Regex("\\d")
        const val COMMA_DELIMITER = ","
        const val COLON_DELIMITER = ":"
    }

    fun add(value: String): Int {
        when {
            value.isBlank() -> return 0
            value.matches(INTEGER_REGEX) -> return value.toInt()
        }

        val numberList: List<Int> = value.split(COLON_DELIMITER, COMMA_DELIMITER).map(String::toInt)

        return numberList.sum()
    }
}
