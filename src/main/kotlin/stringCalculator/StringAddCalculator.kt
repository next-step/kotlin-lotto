package stringCalculator

class StringAddCalculator {
    fun sum(inputValue: String?): Int {
        if (inputValue.isNullOrBlank()) {
            return DEFAULT_VALUE
        }
        TODO("구현예정")
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}