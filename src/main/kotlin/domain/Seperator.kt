package domain

class Seperator {

    fun parse(text: String): List<Int> {
        val result =
            if (hasCustomDelimeter(text)) {
                customDelimiter(text)
            } else {
                defaultDelimiter(text)
            }
        checkMinusInt(result)
        return result.map { it.toInt() }.toList()
    }

    private fun checkMinusInt(input: List<String>) {
        require(input.all { it.toInt() >= 0 }) { throw IllegalArgumentException(ExceptionCode.NOT_ALLOWED_MINUS.getMessage()) }
    }
    private fun defaultDelimiter(text: String): List<String> {
        return text.split(",|:".toRegex())
    }

    private fun customDelimiter(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        val customDelimiter = result!!.groupValues[1]
        return result.groupValues[2].split(customDelimiter)
    }

    private fun hasCustomDelimeter(text: String): Boolean {
        return Regex("//(.)\n(.*)").find(text) != null
    }
}
