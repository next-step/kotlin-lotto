package step1.calculator.domain

class Expression private constructor(
    private val terms: Terms,
    private val expressionType: ExpressionType
) {
    fun sum() = terms.sum()

    companion object {
        fun of(input: String): Expression {
            val expressionType = ExpressionType.match(input)
            val extractor = expressionType.extractor()
            val terms = extractor.extractTerms(expressionType, input)
            return Expression(terms, expressionType)
        }
    }
}
