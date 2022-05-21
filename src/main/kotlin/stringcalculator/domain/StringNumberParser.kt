package stringcalculator.domain

class StringNumberParser(stringExpression: String, separators: ParserSeparators) {
    val parsedNumbers: List<Int>

    init {
        require(separators.getSize() > 0) { ERROR_MESSAGE_SEPARATOR_ZERO }
        validateExpressionForIncludeOtherStrings(stringExpression, separators)

        parsedNumbers = stringExpression.split(Regex(separators.getSeparatorsString().toString())).map { it.toInt() }
        validateParsedNumberForIncludeNegativeNumber(parsedNumbers)
    }

    companion object {
        private const val ERROR_MESSAGE_SEPARATOR_ZERO = "숫자를 추출하기 위한 구분자가 없습니다"

        private fun getErrorMessageIncludeNegativeNumber(negativeNumber: Int): String {
            return "음수($negativeNumber)은 입력할수 없습니다"
        }

        fun validateParsedNumberForIncludeNegativeNumber(parsedNumbers: List<Int>) {
            parsedNumbers.forEach { require(it >= 0) { getErrorMessageIncludeNegativeNumber(it) } }
        }

        fun validateExpressionForIncludeOtherStrings(expression: String, separators: ParserSeparators) {
            val separatorsString = separators.getSeparatorsString().joinToString(separator = ",")
            require(Regex("([$separatorsString,\\d,-])+").matches(expression)) {
                "숫자, 구분 문자($separatorsString) 를 제외한 문자가 포함 되어 있습니다"
            }
        }
    }
}
