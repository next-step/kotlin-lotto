package calculator

object Calculator {
    private const val NOT_POSITIVE_NUMBER_MSG = "문자 또는 숫자가 포함된 입력값은 사용할 수 없습니다."
    private val SPLIT_REGEX = "[,:]".toRegex()
    private val CUSTOM_SPLIT_REGEX = """//(.)\n(.*)""".toRegex()

    private fun List<String>.toPositiveListOrThrow(): List<Int> {
        if (this.filter { it.isPositiveInt() }.size != this.size) {
            throw RuntimeException(NOT_POSITIVE_NUMBER_MSG)
        }
        return this.map { it.toInt() }
    }

    private fun String.isPositiveInt(): Boolean = this.toIntOrNull()?.let { it > 0 } ?: false

    fun calculate(text: String): Int {
        return split(text).sum()
    }

    fun split(text: String): List<Int> {
        if (text.isEmpty()) {
            return listOf(0)
        }

        return CUSTOM_SPLIT_REGEX.find(text)?.let { it ->
            val splitChar = it.groupValues[1]
            val input = it.groupValues[2]
            input.split(splitChar).toPositiveListOrThrow()
        } ?: text.split(SPLIT_REGEX).toPositiveListOrThrow()
    }
}
