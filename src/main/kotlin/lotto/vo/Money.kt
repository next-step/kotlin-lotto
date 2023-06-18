package lotto.vo

@JvmInline
value class Money(
    val amount: Int,
) {
    init {
        require(amount >= 0)
    }
}
