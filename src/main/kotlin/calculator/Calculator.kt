package calculator

class Calculator {
    companion object {
        val INTEGER_REGEX = Regex("\\d")
    }

    fun add(value: String): Int {
        when {
            value.isBlank() -> return 0
            value.matches(INTEGER_REGEX) -> return value.toInt()
        }

        return 0
    }
}
