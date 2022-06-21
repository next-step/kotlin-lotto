package lotto.domain

@JvmInline
value class PositiveNumber(
    private val number: Int
) {
    init {
        require(number >= 0) { "0이상이 아닌 값이 들어있습니다." }
    }

    fun toInt() = number
}
