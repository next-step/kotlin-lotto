package stringcalculator.domain.customparser

class CustomNumbersStringParser(stringExpression: String, separators: ParserSeparators) {
    val parsedNumbers: List<Int>

    init {
        validateExpressionIncludeOtherStrings(stringExpression, separators)
        parsedNumbers = splitBySeparators(stringExpression, separators)
        validateParsedNumberForIncludeNegativeNumber(parsedNumbers)
    }

    private fun splitBySeparators(
        stringExpression: String,
        separators: ParserSeparators
    ) = stringExpression.split(Regex(separators.separatorsString.toString())).map { it.toInt() }

    companion object {
        private fun validateParsedNumberForIncludeNegativeNumber(parsedNumbers: List<Int>) {
            parsedNumbers.forEach { require(it >= 0) { getErrorMessageIncludeNegativeNumber(it) } }
        }

        private fun getErrorMessageIncludeNegativeNumber(negativeNumber: Int): String {
            return "음수($negativeNumber)은 입력할수 없습니다"
        }

        private fun validateExpressionIncludeOtherStrings(expression: String, separators: ParserSeparators) {
            require(getRegexBySeparators(separators).matches(expression)) {
                "숫자, 구분 문자(${getSeparatorStringForRegex(separators)}) 를 제외한 문자가 포함 되어 있습니다"
            }
        }

        private fun getRegexBySeparators(separators: ParserSeparators): Regex {
            val separatorsString = getSeparatorStringForRegex(separators)
            return Regex("([-,$separatorsString,\\d])+")
        }

        private fun getSeparatorStringForRegex(separators: ParserSeparators) =
            separators.separatorsString.joinToString(separator = ",")
    }
}
