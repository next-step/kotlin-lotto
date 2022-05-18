package stringaddcalculator

object StringAddCalculator {
    private val stringInputRegex = "//(.)\\n(.*)".toRegex()

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val (delimiters, numberString) =
            input.takeIf { stringInputRegex.matches(it) }?.let { stringInputRegex.matchEntire(it) }?.groupValues?.let { arrayOf(it[1]) to it[2] }
                ?: (arrayOf(",", ":") to input)

        val numbers = numberString.split(*delimiters).map { it.toInt() }

        return numbers.sum()
    }
}
