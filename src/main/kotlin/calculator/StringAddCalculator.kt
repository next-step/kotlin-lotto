package calculator

object StringAddCalculator {
    private const val DELIMITERS = "[,:]"

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers = text.split(DELIMITERS.toRegex())

        return numbers.sumOf { it.toInt() }
    }
}
