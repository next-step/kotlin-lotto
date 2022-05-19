package calculator

object Calculator {

    private val SPLIT_REGEX = "[,:]".toRegex()
    private val CUSTOM_SPLIT_REGEX = """//(.)\n(.*)""".toRegex()

    fun split(text: String): List<Int> {
        if (text.isEmpty()) {
            return listOf(0)
        }

        return CUSTOM_SPLIT_REGEX.find(text)?.let { it ->
            val splitChar = it.groupValues[1]
            val input = it.groupValues[2]

            input.split(splitChar).map { value -> value.toInt() }
        } ?: text.split(SPLIT_REGEX).map { it.toInt() }
    }

    fun sum(numbers: List<Int>): Int {
        return numbers.sum()
    }
}
