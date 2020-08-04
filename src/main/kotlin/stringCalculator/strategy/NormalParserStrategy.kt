package stringCalculator.strategy

import stringCalculator.view.showMessage

class NormalParserStrategy : ParserStrategy {

    override fun parsingNumber(inputValue: String): List<Int> {
        var numberTokens: List<Int> = listOf()
        try {
            numberTokens = inputValue.split(DELIMITER_TYPE_COMMA, DELIMITER_TYPE_COLON)
                .filter { !it.isBlank() }
                .map { it.toIntOrNull() ?: DEFAULT_VALUE }
        } catch (e: NumberFormatException) {
            showMessage("숫자가 아닌 값이 존재합니다.", e)
        }
        return numberTokens
    }

    companion object {
        const val DELIMITER_TYPE_COMMA = ","
        const val DELIMITER_TYPE_COLON = ":"
        // [질문] 동일한 용도의 값이 StringCaculator에도 있는데 그걸 재사용하는게 더 좋을까요?
        const val DEFAULT_VALUE = 0
    }
}
