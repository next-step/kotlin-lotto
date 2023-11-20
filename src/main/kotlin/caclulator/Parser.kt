package caclulator

object Parser {

    private const val CUSTOM_PREFIX = "//"

    private const val CUSTOM_POSTFIX = "\\n"

    private val DEFAULT_OPERATOR = arrayOf(",", ":")

    fun parse(input: String?): List<Int> {
        if (input == null) {
            return emptyList()
        }
        if (input.isBlank()) {
            return emptyList()
        }
        if (input.startsWith(CUSTOM_PREFIX)) {
            return processCustomOperator(input)
        }
        return makeIntList(input, DEFAULT_OPERATOR)
    }

    private fun processCustomOperator(stringExpr: String): List<Int> =
        stringExpr.split(CUSTOM_POSTFIX)
            .let {
                val customOperator = it[0]
                val expr = it[1]
                val operator = customOperator.split(CUSTOM_PREFIX)[1]
                makeIntList(expr, arrayOf(operator))
            }

    private fun makeIntList(input: String, operator: Array<String>): List<Int> =
        input.split(delimiters = operator)
            .map {
                val int = it.toInt()
                numberValidation(int)
                int
            }

    private fun numberValidation(number: Int) {
        if (number < 0) {
            throw RuntimeException("음수는 들어올 수 없습니다")
        }
    }
}
