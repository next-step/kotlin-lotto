package stringaddcalculator

object StringAddCalculator {
    private val stringInputRegex = "//(.)\\n(.*)".toRegex()

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val (delimiters, numberString) =
            input.takeIf { stringInputRegex.matches(it) }?.let { stringInputRegex.matchEntire(it) }?.groupValues?.let { arrayOf(it[1]) to it[2] }
                ?: (arrayOf(",", ":") to input)

        val numbers = numberString.split(*delimiters).map { it.toPositiveInt() }

        return numbers.sum()
    }

    private fun String.toPositiveInt(): Int = toInt().takeIf { it >= 0 } ?: throw RuntimeException("음수가 아닌 정수를 입력해주세요.")
}
