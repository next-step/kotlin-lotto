package stringCalculator

class StringCalculator {
    fun execute(parsedStringList: List<String>): Int {
        checkStringList(parsedStringList)
        return parsedStringList.sumOf { it.toInt() }
    }

    private fun checkStringList(parsedStringList: List<String>) {
        check(ParsedStringValidator.check(parsedStringList)) {
            RuntimeException()
        }
    }
}