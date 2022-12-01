package lotto.domain

data class Cash(val amount: Int) {
    init {
        require(amount >= 0) { "금액은 음수가 될 수 없습니다." }
    }

    fun pay(amount: Int): Cash = this.copy(amount = this.amount - amount)
}
