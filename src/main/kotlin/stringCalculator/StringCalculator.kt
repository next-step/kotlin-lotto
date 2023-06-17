package stringCalculator

class StringCalculator(
    private val parsedStringList: List<String>
) {
    init {
        ParsedStringValidator(parsedStringList).check()
    }

    fun execute(): Int {
        return parsedStringList.map { it.toInt() }.sum()
    }
}