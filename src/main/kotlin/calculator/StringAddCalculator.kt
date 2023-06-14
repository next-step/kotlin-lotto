package calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {

        if (input.isNullOrEmpty()) {
            return ZERO
        } else if (input.length == 1 && input[0].isDigit()) {
            return input.toInt()
        } else if (!containsDelimiter(input) && input.toInt() < ZERO) {
            throw RuntimeException("음수를 입력할 수 없습니다")
        }

        val stringList = split(input)

        return stringAdd(stringList)
    }

    fun split(input: String): List<String> {

        var customDelimiter = getCustomDelimiter(input)
        var customString: String? = null

        customDelimiter?.let {
            customDelimiter = DELIMITER.plus("|$it")
            customString = input.split("\n")[1]
        }

        val splitList = customDelimiter?.let { customString?.split(it.toRegex()) }
            ?:input.split(DELIMITER.toRegex())

        checkNegativeNumber(splitList)
        return splitList
    }

    fun getCustomDelimiter(input: String): String? {
        val result = Regex("//(.)\n(.*)").find(input)
        return result?.let {
            return it.groupValues[1]
        }
    }

    private fun checkNegativeNumber(splitList: List<String>) {
        splitList.forEach {
            if (it.toInt() < ZERO) {
                throw RuntimeException("음수를 입력할 수 없습니다")
            }
        }
    }

    fun stringAdd(input: List<String>): Int {
        return input.sumOf { it.toInt() }
    }

    private fun containsDelimiter(input: String): Boolean {
        return input.contains(DELIMITER_COMMA) || input.contains(DELIMITER_COLON)
    }

    companion object {
        private const val ZERO: Int = 0
        private const val DELIMITER_COMMA: Char = ','
        private const val DELIMITER_COLON: Char = ':'
        private const val DELIMITER: String = ",|:"
    }
}
