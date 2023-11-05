package stringpluscalculator

private const val DEFAULT_DELIMITERS = "[,:]"
private val inputRegex = Regex("//(.)\n(.*)")

object StringParser {
    fun parser(input: String): List<String> {
        val tokens = splitWithCustomDelimiter(input)
        val parseResult = splitWithDefaultDelimiter(tokens, input)
        checkValidInput(parseResult)
        return parseResult
    }

    private fun splitWithCustomDelimiter(input: String): List<String> {
        val result = inputRegex.find(input)
        var tokens = listOf<String>()
        result?.let {
            val customDelimiter = it.groupValues[1]
            tokens = it.groupValues[2].split(customDelimiter)
        }
        return tokens
    }

    private fun splitWithDefaultDelimiter(tokens: List<String>, input: String): List<String> {
        if (tokens.isEmpty()) {
            return input.split(DEFAULT_DELIMITERS.toRegex())
        }
        return tokens.filter { it.isNotBlank() }.flatMap { it.split(DEFAULT_DELIMITERS.toRegex()) }
    }

    private fun checkValidInput(parseResult: List<String>) {
        for (element in parseResult) {
            val parseNum = element.toIntOrNull() ?: throw IllegalArgumentException("커스텀 구분자 외에는 숫자 이외의 값을 사용할 수는 없습니다. 요소 : $element")
            checkNegative(parseNum)
        }
    }

    private fun checkNegative(parseNum: Int) {
        require(parseNum >= 0) { "음수를 값으로 사용할 수는 없습니다. 요소 : $parseNum" }
    }
}
