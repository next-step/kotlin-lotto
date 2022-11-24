package calculator

class StringCalculator(private val inputString: String?) {

    fun calculate(): Int {
        return if (inputString.isNullOrBlank()) {
            RESULT_EMPTY_VALUE
        } else {
            val matchResult: MatchResult? = Regex(REGEX_DIVIDER).find(inputString)
            val divider = extractionDivider(matchResult)

            require(divider.isNotEmpty()) { "구분자를 찾지 못 했습니다" }

            val splitStr = splitInputStr(divider, matchResult)
            val numbers = splitToNumbers(splitStr)
            add(numbers)
        }
    }

    private fun extractionDivider(matchResult: MatchResult?): String = when (matchResult) {
        null -> DEFAULT_DIVIDER
        else -> extractionCustomDivider(matchResult)
    }

    private fun extractionCustomDivider(matchResult: MatchResult): String =
        matchResult.let {
            it.groupValues[1]
        }

    private fun splitInputStr(divider: String, matchResult: MatchResult?): List<String> {
        val convertString: String = when (matchResult) {
            null -> inputString!!
            else -> matchResult.let { it.groupValues[2] }
        }

        return convertString.split(divider.toRegex())
    }

    private fun splitToNumbers(splitStr: List<String>): List<Int> {
        val result = ArrayList<Int>()
        splitStr.forEach { str ->
            val number: UInt = str.toUInt()
            result.add(number.toInt())
        }

        return result
    }

    private fun add(numberList: List<Int>): Int {
        var sum = 0
        numberList.forEach { num ->
            sum += num
        }
        return sum
    }

    companion object {
        private const val DEFAULT_DIVIDER = ",|:"
        private const val REGEX_DIVIDER = "//(.)\n(.*)"
        private const val RESULT_EMPTY_VALUE = 0
    }
}
