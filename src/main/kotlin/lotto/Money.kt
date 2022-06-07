package lotto

private val LOTTO_PRICE: Money = Money(value = 1000)

@JvmInline
value class Money(private val value: Int) {

    init {
        require(value >= 0) { "금액은 0이상의 정수여야 합니다." }
    }

    fun lottoTicketCount(): Int {
        return this.value / LOTTO_PRICE.value
    }
}
