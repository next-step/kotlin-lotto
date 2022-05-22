package calculator.domain

class Params(text: String?) {
    val intList: List<Int>

    init {
        if (text.isNullOrBlank() || text.isEmpty()) {
            intList = listOf(0)
        } else {
            val tokens = split(text)
            tokens.forEach { validate(it) }
            intList = tokens.map { toInt(it) }
        }
    }

    private fun toInt(it: String): Int {
        if (it.isBlank()) {
            return 0
        }
        return it.toInt()
    }

    private fun validate(token: String) {
        if (token.matches(".*[^\\d^\\s]+.*".toRegex())) {
            throw RuntimeException("숫자가 아닌 입력은 들어올 수 없습니다. (음수도 안됩니다!)")
        }
    }

    private fun split(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: text.split(DEFAULT_DELIMITER)
    }

    companion object {
        private val DEFAULT_DELIMITER: Regex = "[,:]".toRegex()
    }
}
