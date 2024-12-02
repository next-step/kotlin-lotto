package calculator

import calculator.convert.CalculatorNumberConvert

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val result =
            customExpression(input)?.mapNotNull { it.toIntOrNull() }
                ?: input.split(Regex(DEFAULT_PATTERN))
                    .filter { it.isNotBlank() }
                    .map { CalculatorNumberConvert.convertInt(it) }
        return result.sum()
    }

    private fun customExpression(text: String): List<String>? {
        val matchResult = Regex(CUSTOM_PATTERN).find(text) ?: return null
        return matchResult.groupValues.getOrNull(2)?.split(matchResult.groupValues[1])
    }

    companion object {
        private const val DEFAULT_PATTERN = "[,:]" // 콤마 또는 콜론을 의미하
        private const val CUSTOM_PATTERN = "[//(.)\n(.*)]"
    }
}
