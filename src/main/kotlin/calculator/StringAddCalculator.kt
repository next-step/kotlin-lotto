package calculator

class StringAddCalculator(
    private val input: String?
) {

    fun calculate(): Int {

        if (input.isNullOrEmpty()) {
            return ZERO
        } else if (input.length == 1 && input[0].isDigit()) {
            return input.toInt()
        } else if (!containsDelimiter(input) && input.toInt() < ZERO) {
            throw RuntimeException("음수를 입력할 수 없습니다")
        }

        val customDelimiter = DelimiterManager().getCustomDelimiter(input)
        val fixedDelimiter = customDelimiter?.let { DelimiterManager().combineDelimiter(it) }
        val customInput = getCustomInput(input)
        val splitList = DelimiterManager().splitByDelimiter(fixedDelimiter, customInput, input)

        checkNegativeNumber(splitList)
        return BasicCalculator().add(splitList)
    }

    private fun getCustomInput(input: String): String {
        return input.split("\n")[CUSTOM_INPUT_INDEX]
    }

    private fun checkNegativeNumber(splitList: List<String>) {
        splitList.forEach {
            if (it.toInt() < ZERO) {
                throw RuntimeException("음수를 입력할 수 없습니다")
            }
        }
    }

    private fun containsDelimiter(input: String): Boolean {
        return input.contains(DELIMITER_COMMA) || input.contains(DELIMITER_COLON)
    }

    companion object {
        private const val CUSTOM_INPUT_INDEX: Int = 1
        private const val ZERO: Int = 0
        private const val DELIMITER_COMMA: Char = ','
        private const val DELIMITER_COLON: Char = ':'
    }
}
