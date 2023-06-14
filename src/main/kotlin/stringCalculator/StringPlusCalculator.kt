package stringCalculator

object StringPlusCalculator {

    const val DEFAULT_SEPERATOR_1 = ":"
    const val DEFAULT_SEPERATOR_2 = ","
    const val CUSTOM_SEPERATOR_PREFIX = "//"
    const val CUSTOM_SEPERATOR_POSTFIX = "\n"
    const val CUSTOM_SEPERATOR_POSITION = 0
    const val EMPTY_VALUE = 0
    const val VALUE_POSITION = 1

    private var customSeperators = mutableListOf(DEFAULT_SEPERATOR_1, DEFAULT_SEPERATOR_2)
    fun seperate(string: String): List<Int> {
        if (string.isEmpty()) {
            return listOf(EMPTY_VALUE)
        }
        val convertedString = setCustomSeperatorAndGetConvertedString(string)

        return checkValidTypedString(convertedString.split(*customSeperators.toTypedArray()))
    }

    private fun checkValidTypedString(strings: List<String>): List<Int> {
        return strings.map {
            checkPlusNumberString(it)
        }
    }

    private fun checkPlusNumberString(string: String): Int {
        val intString = runCatching {
            string.toInt()
        }.getOrElse {
            throw RuntimeException("숫자만 올 수 있음")
        }
        if (intString < 0) {
            throw RuntimeException("음수는 올 수 없음")
        }
        return intString
    }

    private fun setCustomSeperatorAndGetConvertedString(string: String): String {
        var convertedString = string
        if (CUSTOM_SEPERATOR_PREFIX in string && CUSTOM_SEPERATOR_POSTFIX in string) {
            val splitStrings = string.split(CUSTOM_SEPERATOR_POSTFIX)
            convertedString = splitStrings[VALUE_POSITION]
            customSeperators.add(splitStrings[CUSTOM_SEPERATOR_POSITION].split(CUSTOM_SEPERATOR_PREFIX)[VALUE_POSITION])
        }
        return convertedString
    }

    fun calculate(numbers: List<Int>): Int {
        return numbers.reduce {
            total, number ->
            total + number
        }
    }
}
