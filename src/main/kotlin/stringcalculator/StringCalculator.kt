package stringcalculator

class StringCalculator {
    fun calculate(inputString: String): Int {
        val delimiters = findDelimiter(inputString)
        val numbers = excludeDelimiter(inputString).split(*delimiters.toTypedArray())
        return numbers.sumOf { it.toInt() }
    }

    fun findDelimiter(inputString: String): List<String> {
        val delimiters = mutableListOf(",", ":")
        val startIndex = inputString.indexOf("//")
        val endIndex = inputString.indexOf("\n")
        if (startIndex == -1 && endIndex == -1) {
            return delimiters
        }
        delimiters.addAll(inputString.substring(startIndex + 2, endIndex).toCharArray().map { it.toString() })
        return delimiters
    }

    fun excludeDelimiter(inputString: String): String {
        return inputString.substring(inputString.indexOf("\n") + 1)
    }
}
