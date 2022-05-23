package calculator

class Params(text: String?) {
    val intList: List<Int>

    init {
        intList = if (text.isNullOrBlank()) {
            listOf(0)
        } else {
            val tokens = split(text)
            tokens.forEach { validate(it) }
            tokens.map { toInt(it) }
        }
    }

    fun fold(initial: Int, operation: (acc: Int, Int) -> Int): Int {
        return intList.fold(initial, operation)
    }

    private fun toInt(token: String): Int {
        if (token.isBlank()) {
            return 0
        }
        return token.toInt()
    }

    private fun validate(token: String) {
        if (token.matches(TOKEN_NOT_MATCH_VALIDATOR)) {
            throw RuntimeException("숫자가 아닌 입력은 들어올 수 없습니다. (음수도 안됩니다!)")
        }
    }

    private fun split(text: String): List<String> {
        val result = TOKEN_SPLITTER.find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: text.split(DEFAULT_DELIMITER)
    }

    companion object {
        private val DEFAULT_DELIMITER: Regex = "[,:]".toRegex()
        private val TOKEN_NOT_MATCH_VALIDATOR = ".*[^\\d^\\s]+.*".toRegex()
        private val TOKEN_SPLITTER = "//(.)\n(.*)".toRegex()
    }
}
