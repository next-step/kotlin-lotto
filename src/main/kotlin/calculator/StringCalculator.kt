package calculator

class StringCalculator {
    fun calculate(stringExpression: String?): Double {
        require(!stringExpression.isNullOrBlank()) { "표현식이 입력되지 않았습니다." }
        val expression = parseExpression(stringExpression)
        return expression.calculate()
    }

    private fun parseExpression(stringExpression: String): Expression {
        val customDelimiter = parseCustomDelimiter(stringExpression)
        val mathExpression = parseMathExpression(stringExpression, customDelimiter)

        return Expression(
            mathExpression = mathExpression,
            customDelimiter = customDelimiter,
        )
    }

    private fun parseCustomDelimiter(stringExpression: String): String? =
        Regex("(?<=//).(?=\\n)")
            .find(stringExpression)
            ?.value

    private fun parseMathExpression(
        stringExpression: String,
        customDelimiter: String?,
    ): String =
        if (customDelimiter != null) {
            Regex("(?<=//.\\n).*")
                .find(stringExpression)
                ?.value
                ?: throw RuntimeException("입력한 표현식이 유효하지 않습니다.")
        } else {
            stringExpression
        }
}

private class Expression(
    mathExpression: String,
    customDelimiter: String? = null,
) {
    private val targetNumbers: List<PositiveNumber>

    init {
        val delimiters = DEFAULT_DELIMITERS + listOfNotNull(customDelimiter)
        val parsedTargetNumbers = parseTargetNumbers(mathExpression, delimiters)
        this.targetNumbers = parsedTargetNumbers
    }

    private fun parseTargetNumbers(
        mathExpression: String,
        delimiters: List<String>,
    ) = try {
        mathExpression
            .split(*delimiters.toTypedArray())
            .map { PositiveNumber(it.toDouble()) }
    } catch (e: NumberFormatException) {
        throw RuntimeException("입력한 표현식 \"${mathExpression}\"에 숫자가 아닌 유효하지 않은 문자가 포함되어 있습니다.")
    }

    fun calculate(): Double = targetNumbers.sumOf { it.number }

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}

@JvmInline
private value class PositiveNumber(
    val number: Double,
) {
    init {
        require(number >= 0) { "음수는 더할 수 없습니다." }
    }
}
