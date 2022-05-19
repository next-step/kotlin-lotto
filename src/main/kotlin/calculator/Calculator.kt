package calculator

object Calculator {
    private val SPLIT_REGEX = "[,:]".toRegex()

    fun split(text: String): List<Int> {
        if (text.isEmpty()) {
            return listOf(0)
        }

        return text.split(SPLIT_REGEX).map { it.toInt() }
    }

    fun sum(numbers: List<Int>): Int {
        return numbers.sum()
    }
}
