package stringcalculator

class DelimiterNumberSpliter {
    fun findDelimiter(inputString: String): String {
        val delimiters = ",|:"
        val startIndex = inputString.indexOf("//")
        val endIndex = inputString.indexOf("\n")
        if (startIndex == -1 && endIndex == -1) {
            return delimiters
        }
        val newDelimiters =
            delimiters.plus("|")
                .plus(inputString.substring(startIndex + 2, endIndex).toCharArray().map { it.toString() }.joinToString("|"))
        return newDelimiters
    }

    fun excludeDelimiter(inputString: String): String {
        return inputString.substring(inputString.indexOf("\n") + 1)
    }
}
