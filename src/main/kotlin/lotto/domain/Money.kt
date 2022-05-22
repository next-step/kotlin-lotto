package lotto.domain

@JvmInline
value class Money(val amount: Int) {

    init {
        require(amount >= 0) { "금액은 음수가 될 수 없습니다" }
    }
}
