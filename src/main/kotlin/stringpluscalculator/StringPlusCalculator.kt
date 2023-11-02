package stringpluscalculator

object StringPlusCalculator {

    fun plus(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        val parseResult = StringParser.parser(input)
        return plusElements(parseResult)
    }

    private fun plusElements(parseResult: List<String>): Int {
        var result = 0
        parseResult.forEach {
            result += it.toInt()
        }
        return result
    }
}
