package lotto.domain

private const val MIN_PURCHASED_MONEY = 0

@JvmInline
value class Money(
    val value: Int,
) {
    init {
        require(value >= MIN_PURCHASED_MONEY) { "구입 금액은 음수가 될 수 없습니다." }
    }

    fun divide(value: Int) = this.value / value
}
