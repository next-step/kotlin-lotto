package stringcalculator.domain.customparser

data class CustomNumberExpression(val string: String, val separators: ParserSeparators) {

    init {
        validateExpressionIncludeOtherStrings(string, separators)
    }

    companion object {
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
