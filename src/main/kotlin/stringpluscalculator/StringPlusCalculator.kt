package stringpluscalculator

object StringPlusCalculator {

    fun plus(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        val parseResult = StringParser.parser(input)
        checkValidInput(parseResult)
        return plusElements(parseResult)
    }

    private fun checkValidInput(parseResult: List<String>) {
        for (element in parseResult) {
            val parseNum = element.toIntOrNull() ?: throw RuntimeException()
            checkNegative(parseNum)
        }
    }

    private fun checkNegative(parseNum: Int) {
        if (parseNum < 0) {
            throw RuntimeException()
        }
    }

    private fun plusElements(parseResult: List<String>): Int {
        var result = 0
        parseResult.forEach {
            result += it.toInt()
        }
        return result
    }
}
