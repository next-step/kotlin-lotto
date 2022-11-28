package lotto.domain

data class Cash(val amount: Int) {
    init {
        require(this.amount >= 0) { "금액은 음수가 될 수 없습니다." }
    }

    fun play(payment: Int): Cash {
        check(this.amount >= payment) { "잔액이 부족홥니다." }

        return this.copy(amount = this.amount.minus(payment))
    }
}
