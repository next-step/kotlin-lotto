package calculator

import calculator.convert.CalculatorNumberConvert

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val result = customExpression(input)?.map { e -> e.toInt() } ?:
        input.split(",", ":").map { e -> CalculatorNumberConvert.convertInt(e) }
        return result.sum()
    }
    private fun customExpression(text: String): List<String>? {
        return Regex("//(.)\n(.*)").find(text)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }
    }

}
