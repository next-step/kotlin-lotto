package calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank())
            return 0

        return parseToNum(text).sum()
    }

    private fun parseToNum(text: String): List<Int> {
        val stringNums = text.split(COMMA_AND_COLON_REGEX)
        return stringNums.map { convertToInt(it) }
    }

    private fun convertToInt(num: String): Int {
        return if (num.isNullOrBlank())
            0
        else if (num.matches(NUM_REGEX))
            num.toInt()
        else
            throw RuntimeException("숫자가 아닌 값을 입력할 수 없습니다.")
    }

    companion object {
        val NUM_REGEX = "\\d+".toRegex()
        val COMMA_AND_COLON_REGEX = ",|:".toRegex()
    }
}
