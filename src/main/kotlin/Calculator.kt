private const val DELIMITER_PATTERN = "//(.)\\\\n"
private const val DELIMITER_SUFFIX = "(.*)"
private const val DELIMITER_CHARACTER_POSITION = 2
class Calculator {
    companion object {
        @JvmField
        val DEFAULT_DELIMITERS = listOf(":", ",")
        val DEFAULT_EMPTY_LIST = listOf(0)
    }

    fun existDelimiter(content: String): Boolean = Regex(pattern = DELIMITER_PATTERN).containsMatchIn(content)
    fun addNumbers(numbers: List<Int>): Int = numbers.sum()

    fun getDelimiters(content: String): List<String> {
        val regex = Regex(pattern = DELIMITER_PATTERN)
        val find = regex.find(content)

        checkNotNull(find) {
            return DEFAULT_DELIMITERS
        }

        return DEFAULT_DELIMITERS + find.value[DELIMITER_CHARACTER_POSITION].toString()
    }

    fun splitNumbersToDelimiters(content: String, delimiters: List<String>): List<Int> {
        if (content.isNullOrEmpty()) {
            return DEFAULT_EMPTY_LIST
        }

        if (existDelimiter(content).not()) {
            return content.split(*delimiters.toTypedArray()).map { it.toInt() }
        }

        val regex = Regex(pattern = DELIMITER_PATTERN + DELIMITER_SUFFIX)
        val delimiterRemainContent = regex.matchEntire(content)!!

        return delimiterRemainContent.groupValues.last().split(*delimiters.toTypedArray()).map { it.toInt() }
    }
}

fun main() {
    // 입력
    val inputStr = readLine()!!

    val calculator = Calculator()

    val delimiters = calculator.getDelimiters(inputStr)
    val numbers = calculator.splitNumbersToDelimiters(inputStr, delimiters)
    val sum = calculator.addNumbers(numbers)
    println("sum:$sum")
}
