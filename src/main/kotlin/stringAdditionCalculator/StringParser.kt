package stringAdditionCalculator

class StringParser(private val separatorList: List<String> = listOf(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON)) {

    init {
        require(separatorList.all { it.isNotEmpty() }) { "구분자가 없습니다.\n빈 문자는 구분자가 될 수 없습니다. 스페이스 공백은 허용합니다." }
    }

    private fun parseable(input: String): Boolean = this.separatorList.any { input.contains(it) }

    fun parseToInt(input: String): List<Int> {
        return parse(input).map { it.toInt() }
    }

    fun parse(input: String): List<String> {
        if (!parseable(input)) {
            throw IllegalStateException("${this.separatorList.joinToString(", ")} 중 하나 이상의 구분자가 포함되어야 합니다.")
        }

        return parse(input, this.separatorList)
    }

    private fun parse(input: String, separatorList: List<String>): List<String> {
        if (separatorList.size == 1) {
            return input.split(separatorList.first())
        }

        return parse(input, separatorList.drop(1)).flatMap { parse(it, listOf(separatorList.first())) }
    }

    companion object {
        private const val DEFAULT_SEPARATOR_COLON = ":"
        private const val DEFAULT_SEPARATOR_COMMA = ","
    }
}
