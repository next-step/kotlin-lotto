package stringAddCalculator

import java.lang.RuntimeException

@JvmInline
value class CalculatorToken(private val value: String) {
    fun convertOrThrow(formula: String?, customDelimiter: String?): Int {
        val convertedValue = value.toIntOrNull()
        require(convertedValue != null) { throw RuntimeException("invalid formula: $formula failed to parse $value with delimiter $customDelimiter") }
        check(convertedValue > 0) { throw RuntimeException("negative number: $value") }
        return convertedValue
    }
}
