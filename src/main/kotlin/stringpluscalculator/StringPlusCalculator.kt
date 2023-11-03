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
        return parseResult.sumOf {
            it.toInt()
        }
    }
}
