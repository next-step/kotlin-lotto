package step1.calculator.domain

class Expression private constructor(
    private val terms: Terms,
    private val delimiterType: DelimiterType
) {
    fun sum() = terms.sum()

    companion object {
        fun of(input: String): Expression {
            val delimiterType = DelimiterType.match(input)
            val extractor = delimiterType.getExtractor()
            val terms = extractor.extractTerms(delimiterType, input)
            return Expression(terms, delimiterType)
        }
    }
}
