package calculator.domain

class Separator {
    private val customExtractor: DelimiterExtractor = CustomDelimiterExtractor()
    private val defaultExtractor: DelimiterExtractor = DefaultDelimiterExtractor()

    fun separate(expression: String): List<Long> {
        if (customExtractor.isValidExpression(expression)) {
            return customExtractor.extract(expression)
        }
        return defaultExtractor.extract(expression)
    }
}
