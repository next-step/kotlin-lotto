package string.add.calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val tokens = split(text)
        val numbers = tokens.map { NaturalNumber(it) }
        return NaturalNumber.sum(numbers).value
    }

    private fun split(text: String): List<String> {
        val regex = CUSTOM_DELIMITER.toRegex()
        val matchResult = regex.matchEntire(text)
        if (matchResult != null) {
            val (delimiter, numbers) = matchResult.destructured
            return numbers.split(delimiter)
        }
        return text.split(COMMA, COLON)
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}

@JvmInline
value class NaturalNumber(
    val value: Int,
) {
    init {
        if (value < 0) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    constructor(value: String) : this(value.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다."))

    fun add(other: NaturalNumber): NaturalNumber = NaturalNumber(value + other.value)

    companion object {
        val ZERO = NaturalNumber(0)

        fun sum(numbers: List<NaturalNumber>): NaturalNumber = numbers.reduceOrNull { acc, naturalNumber -> acc.add(naturalNumber) } ?: ZERO
    }
}
