package calculator

class StringCalculator {
    fun calculate(stringExpression: String?): Double {
        require(!stringExpression.isNullOrBlank()) { "표현식이 유효하지 않습니다." }
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
                ?: throw IllegalArgumentException("표현식이 유효하지 않습니다.")
        } else {
            stringExpression
        }
}

private class Expression(
    mathExpression: String,
    customDelimiter: String? = null,
) {
    private val targetNumbers: List<Double>

    init {
        val delimiters = DEFAULT_DELIMITERS + listOfNotNull(customDelimiter)
        val parsedTargetNumbers = parseTargetNumbers(mathExpression, delimiters)
        requirePositiveNumbers(parsedTargetNumbers)
        this.targetNumbers = parsedTargetNumbers
    }

    private fun parseTargetNumbers(
        mathExpression: String,
        delimiters: List<String>,
    ) = try {
        mathExpression
            .split(*delimiters.toTypedArray())
            .map { it.toDouble() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자만 더할 수 있습니다.")
    }

    private fun requirePositiveNumbers(parsedTargetNumbers: List<Double>) {
        require(parsedTargetNumbers.all { it >= 0 }) { "음수는 더할 수 없습니다." }
    }

    fun calculate(): Double = targetNumbers.sum()

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}