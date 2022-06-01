package lotto.domain

@JvmInline
value class Money private constructor(private val value: Int) {

    init {
        require(value.isPositive()) { "금액은 음수를 가질 수 없습니다." }
    }

    companion object {

        fun of(value: Int) = Money(value)
    }

    private fun Int.isPositive() = 0 <= this
}
