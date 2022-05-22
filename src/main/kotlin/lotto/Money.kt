package lotto

@JvmInline

value class Money(val amount: Int) {
    companion object {
        fun of(money: Int): Money {
            require(money >= 0) { "금액은 음수가 될 수 없습니다" }

            return Money(money)
        }
    }
}
