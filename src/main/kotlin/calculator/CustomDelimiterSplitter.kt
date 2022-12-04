package calculator

object CustomDelimiterSplitter : ExpressionSplitter {
    private const val CUSTOM_DELIMITER_REG_EXP = "//(.)\n(.*)"

    override fun split(expression: Expression): List<String> {
        val result = Regex(CUSTOM_DELIMITER_REG_EXP).find(expression.value)
        require(result != null) { "커스텀 구분자를 포함하고 있지 않습니다." }

        val customDelimiter = result.groupValues[1]
        val targetExpression = result.groupValues[2]

        return targetExpression.split(customDelimiter)
    }
}
