package calculator.domain

class Params(value: String?) {
    val values: List<Int>

    init {
        if (value.isNullOrBlank()) {
            values = listOf(0)
        } else {
            val stringList = split(value)
            stringList.forEach { validate(it) }
            values = stringList.map { toInt(it) }
        }
    }

    private fun toInt(it: String): Int {
        if (it.isBlank()) {
            return 0
        }
        return it.toInt()
    }

    private fun validate(string: String) {
        if (string.matches(".*[^\\d^\\s]+.*".toRegex())) {
            throw RuntimeException("숫자가 아닌 입력은 들어올 수 없습니다. (음수도 안됩니다!)")
        }
    }

    private fun split(value: String): List<String> {
        val delimiter = getDelimiter(value)
        val contents = getContents(value)
        return contents.split(delimiter)
    }

    private fun getDelimiter(value: String): Regex {
        if (hasCustomDelimiter(value)) {
            return value.split("//|\n".toRegex())[1].toRegex()
        } else {
            return DEFAULT_DELIMITER
        }
    }

    private fun getContents(value: String): String {
        if (hasCustomDelimiter(value)) {
            return value.split("//|\n".toRegex())[2]
        } else {
            return value
        }
    }

    private fun hasCustomDelimiter(value: String): Boolean =
        value.contains("//") && value.contains("\n")

    companion object {
        private val DEFAULT_DELIMITER: Regex = "[,;]".toRegex()
    }
}
