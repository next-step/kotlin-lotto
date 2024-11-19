package study

data class PositiveNumber(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    constructor(str: String?) : this(parseText(str))

    operator fun plus(other: PositiveNumber): PositiveNumber {
        return PositiveNumber(value + other.value)
    }

    companion object {
        val ZERO: PositiveNumber = PositiveNumber(0)

        private fun parseText(text: String?): Int {
            if (text.isNullOrBlank()) {
                return 0
            }

            return try {
                text.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("숫자만 입력 가능합니다.")
            }
        }
    }
}
