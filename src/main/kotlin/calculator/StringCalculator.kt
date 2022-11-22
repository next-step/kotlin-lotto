package calculator

class StringCalculator(private val str: String?) {

    fun calculate(): Int = when (str.isNullOrBlank()) {
        true -> { RESULT_EMPTY_VALUE }
        false -> {
            val matchResult: MatchResult? = Regex(REGEX_DIVIDER).find(str)
            val divider = getDivider(matchResult)

            require(!divider.isNullOrEmpty()) { "divider" }

            val splitStr = splitStr(divider, matchResult)
            val numbers = splitToNumbers(splitStr)
            add(numbers)
        }
    }

    private fun getDivider(matchResult: MatchResult?): String = when (matchResult) {
        null -> DEFAULT_DIVIDER
        else -> getCustomDivider(matchResult)
    }

    private fun getCustomDivider(matchResult: MatchResult): String =
        matchResult.let {
            it.groupValues[1]
        }

    private fun splitStr(divider: String, matchResult: MatchResult?): List<String> {
        val convertString: String = when (matchResult) {
            null -> str!!
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
