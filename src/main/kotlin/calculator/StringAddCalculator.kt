package calculator

import calculator.convert.CalculatorNumberConvert

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val result =
            customExpression(input)?.map { e -> e.toInt() }
                ?: input.split(Regex(DEFAULT_PATTERN)).map { e -> CalculatorNumberConvert.convertInt(e) }
        return result.sum()
    }

    private fun customExpression(text: String): List<String>? {
        return Regex(CUSTOM_PATTERN).find(text)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }
    }

    companion object {
        private const val DEFAULT_PATTERN = "[,:]" // 콤마 또는 콜론을 의미하
        private const val CUSTOM_PATTERN = "[//(.)\n(.*)]"
    }
}
