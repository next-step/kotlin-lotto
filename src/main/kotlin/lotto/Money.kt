package lotto

private val LOTTO_PRICE: Money = Money(value = 1000)

@JvmInline
value class Money(private val value: Int) {

    init {
        require(value >= 0) { "금액은 0이상의 정수여야 합니다." }
    }

    operator fun div(other: Money) = this.value / other.value

    fun lottoTicketCount(): Int {
        return this / LOTTO_PRICE
    }
}
