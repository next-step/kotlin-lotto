package calculator

class StringAddCalculator {

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) return EMPTY_RESULT

        val split: List<String> = input.split(DEFAULT_DELIMITER_REGEX)

        val findRegex = Regex("//(.)\n(.*)").find(input)
        val numbers = findRegex?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: split

        return checkNegativeNumbers(numbers.map { it.toInt() })
    }

    private fun checkNegativeNumbers(numbers: List<Int>): Int {
        val negativeNumbers = numbers.filter { it < 0 }
        if (negativeNumbers.isNotEmpty()) throw RuntimeException("음수 입력되었습니다!!!!")

        return numbers.sum()
    }

    companion object {
        private const val EMPTY_RESULT = 0
        private val DEFAULT_DELIMITER_REGEX = ",|:".toRegex()
    }
}
