package calculator

object Calculator {
    private val SPLIT_REGEX = "[,:]".toRegex()
    private val CUSTOM_SPLIT_REGEX = """//(.)\n(.*)""".toRegex()

    private fun List<String>.toNumbers() = this.map { Number(it) }

    private fun List<Number>.sum() = this.sumOf { it.positive }

    fun calculate(text: String): Int {
        val numbers = CUSTOM_SPLIT_REGEX.find(text)?.let { it ->
            val (splitChar, input) = it.destructured
            input.split(splitChar).toNumbers()
        } ?: text.split(SPLIT_REGEX).toNumbers()

        return numbers.sum()
    }
}
