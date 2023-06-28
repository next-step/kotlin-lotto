package stringCalculator

class StringCalculator(
    private val stringValidator: ParsedStringValidator
) {
    fun execute(parsedStringList: List<String>): Int {
        checkStringList(parsedStringList)
        return parsedStringList.sumOf { it.toInt() }
    }

    private fun checkStringList(parsedStringList: List<String>) {
        check(stringValidator.check(parsedStringList)) {
            RuntimeException()
        }
    }
}
