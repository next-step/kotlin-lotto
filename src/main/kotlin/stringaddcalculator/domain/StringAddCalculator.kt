package stringaddcalculator.domain

class StringAddCalculator(
    private val separators: Separators = Separators()
) {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0

        val expression = when (isContainsCustomSeparator(input)) {
            true -> {
                val (customSeparator, expression) = extractCustomSeparator(input)
                separators.add(customSeparator)
                expression
            }
            false -> input
        }

        val operands = extractOperands(expression)

        return operands.sumOf { it.value }
    }

    private fun extractOperands(expression: String): List<Operand> {
        println(separators.toRegex())
        return expression.split(separators.toRegex())
            .map { Operand.of(it) }
    }

    private fun isContainsCustomSeparator(input: String): Boolean {
        return CUSTOM_REGEX.containsMatchIn(input)
    }

    private fun extractCustomSeparator(input: String): Pair<String, String> {
        val matchResult = CUSTOM_REGEX.find(input)
        return matchResult?.let {
            it.groupValues[1] to it.groupValues[2]
        } ?: throw IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다")
    }

    companion object {
        private val CUSTOM_REGEX = "//(.)\n(.*)".toRegex()
    }
}
