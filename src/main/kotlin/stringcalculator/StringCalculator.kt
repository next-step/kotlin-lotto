package stringcalculator

class StringCalculator {
    fun calculate(inputString: String?): Int {
        if (inputString.isNullOrBlank()) return 0
        val delimiters = findDelimiter(inputString)
        val numbers = excludeDelimiter(inputString).split(*delimiters.toTypedArray())
        require(isAllDigit(numbers)) { "숫자가 아니에요" }
        require(!isMinusInNumbers(numbers)) { "음수가 입력으로 들어왔어요" }
        return numbers.sumOf { it.toInt() }
    }

    private fun findDelimiter(inputString: String): List<String> {
        val delimiters = mutableListOf(",", ":")
        val startIndex = inputString.indexOf("//")
        val endIndex = inputString.indexOf("\n")
        if (startIndex == -1 && endIndex == -1) {
            return delimiters
        }
        delimiters.addAll(inputString.substring(startIndex + 2, endIndex).toCharArray().map { it.toString() })
        return delimiters
    }

    private fun excludeDelimiter(inputString: String): String {
        return inputString.substring(inputString.indexOf("\n") + 1)
    }

    private fun isMinusInNumbers(numberStrings: List<String>): Boolean {
        return numberStrings.any { isMinusNumberString(it) }
    }

    private fun isMinusNumberString(numberString: String): Boolean {
        val charArray = numberString.toCharArray()
        return charArray.get(0).equals('-') &&
            charArray.filterIndexed { index, c ->
                if (index == 0) return true
                return CharRange('0', '9').contains(c)
            }.all { true }
    }

    private fun isAllDigit(numbers: List<String>): Boolean {
        return numbers.all {
            val charArray = it.toCharArray()
            charArray.all { c -> c.isDigit() } || isMinusNumberString(it)
        }
    }
}
