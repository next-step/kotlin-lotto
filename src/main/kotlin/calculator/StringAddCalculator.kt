package calculator

class StringAddCalculator {

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) return EMPTY_RESULT

        val numbers = splitInputByDelimiter(input)
        checkNegativeNumbers(numbers)

        return numbers.sum()
    }

    private fun splitInputByDelimiter(input: String): List<Int> {
        val findRegex = Regex("//(.)\n(.*)").find(input)
        val split = findRegex?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: input.split(DEFAULT_DELIMITER_REGEX)

        return split.map { it.toInt() }
    }

    private fun checkNegativeNumbers(numbers: List<Int>) {
        val negativeNumbers = numbers.filter { it < 0 }
        if (negativeNumbers.isNotEmpty()) throw RuntimeException("음수 입력되었습니다!!!!")
    }

    companion object {
        private const val EMPTY_RESULT = 0
        private val DEFAULT_DELIMITER_REGEX = ",|:".toRegex()
    }
}
