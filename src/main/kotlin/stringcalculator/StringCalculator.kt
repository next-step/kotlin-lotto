package stringcalculator

class StringCalculator {
    fun calculate(inputString: String?): Int {
        val delimiterNumberSpliter = DelimiterNumberSpliter()
        if (inputString.isNullOrBlank()) return 0
        val delimiters = delimiterNumberSpliter.findDelimiter(inputString)
        val numbers = delimiterNumberSpliter.excludeDelimiter(inputString).split(delimiters.toRegex())
        require(isAllDigit(numbers)) { "숫자가 아니에요" }
        require(!isMinusInNumbers(numbers)) { "음수가 입력으로 들어왔어요" }
        return numbers.sumOf { it.toInt() }
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
