package stringAddCalculator

import java.lang.RuntimeException

@JvmInline
value class CalculatorToken(private val value: String) {
    fun convertOrThrow(formula: String?, customDelimiter: String?) =
        value.toIntOrNull()?.let { converted ->
            if (converted < 0)
                throw RuntimeException("negative number: $value")
            else converted
        }
            ?: throw RuntimeException("invalid formula: $formula failed to parse $value with delimiter $customDelimiter")
}
