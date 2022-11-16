package calculator

private const val REGEX_CUSTOM_DELIMITER = "//(.)\n(.*)"
private const val REGEX_REGULAR_DELIMITER = "[,:]"

class StringAddCalculator {

    fun add(text: String?): Int = when {
        text.isNullOrBlank() -> 0
        text.isInt() -> intTextSum(text)
        else -> parseTextSum(text)
    }

    private fun intTextSum(text: String): Int {
        val number = text.toInt()
        require(number > 0) { "숫자는 음수일 수 없습니다" }
        return number
    }

    private fun parseTextSum(text: String): Int {
        val splitText = when {
            Regex(REGEX_CUSTOM_DELIMITER).matches(text) -> customsDelimiterSplit(text)
            else -> regularDelimiterSplit(text)
        }
        return toSum(splitText)
    }

    private fun customsDelimiterSplit(text: String): List<String> {
        val result = Regex(REGEX_CUSTOM_DELIMITER).find(text)
        requireNotNull(result) { "패턴이 검증되어 필수 값 입니다" }
        result.let {
            return it.groupValues[2].split(it.groupValues[1])
        }
    }

    private fun regularDelimiterSplit(text: String): List<String> =
        text.split(REGEX_REGULAR_DELIMITER.toRegex())

    private fun toSum(intStrList: List<String>): Int =
        intStrList.sumOf { str ->
            require(str.isInt()) { "숫자 이외의 값을 입력할 수 없습니다" }
            str.toInt()
        }
}

fun String.isInt(): Boolean = this.toIntOrNull() != null
