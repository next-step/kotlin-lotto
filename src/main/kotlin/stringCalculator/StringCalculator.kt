package stringCalculator

class StringCalculator(
    private val parsedStringList: List<String>
) {
    init {
        check(ParsedStringValidator().check(parsedStringList)) {
            RuntimeException()
        }
    }

    fun execute(): Int {
        return parsedStringList.sumOf { it.toInt() }
    }
}