package lotto

private val LOTTO_PRICE: Money = Money(1_000)

@JvmInline
value class Money(private val value: Int) {

    init {
        require(value >= 0) { "금액은 0이상의 정수여야 합니다." }
    }
}
