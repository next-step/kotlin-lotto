package calculator

class StringCalculator(private val str: String?) {

    fun calculate(): Int {
        return if (str.isNullOrBlank()) {
            RESULT_EMPTY_VALUE
        } else {
            val isCustomDivider = isCustomDivider()
            val divider = getDivider(isCustomDivider)

            require(!divider.isNullOrEmpty()) { "divider" }

            add(splitToNumbers(splitStr(divider, isCustomDivider)))
        }
    }

    private fun getDivider(isCustomDivider: Boolean) = when (isCustomDivider) {
        true -> getCustomDivider()
        false -> DEFAULT_DIVER
    }

    private fun isCustomDivider(): Boolean = str!!.startsWith("//")

    private fun getCustomDivider(): String? =
        Regex(REGEX_DIVER).find(str!!)?.let {
            it.groupValues[1]
        }

    private fun splitStr(divider: String, isCustomDivider: Boolean): List<String> {
        val convertString = if (isCustomDivider) {
            str!!.substring(str.lastIndexOf("\n") + 1)
        } else {
            str!!
        }

        return convertString.split(divider.toRegex())
    }

    private fun splitToNumbers(splitStr: List<String>): List<Int> {
        val result = ArrayList<Int>()
        splitStr.forEach { str ->
            val number = str.toInt()
            minusCheck(number >= 0) { "minus number" }
            result.add(number)
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

    private inline fun minusCheck(value: Boolean, lazyMessage: () -> Any) {
        if (!value) {
            val message = lazyMessage()
            throw java.lang.RuntimeException(message.toString())
        }
    }

    companion object {
        private const val DEFAULT_DIVER = ",|:"
        private const val REGEX_DIVER = "//(.)\n(.*)"
        private const val RESULT_EMPTY_VALUE = 0
    }
}
