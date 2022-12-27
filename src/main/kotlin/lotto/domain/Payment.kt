package lotto.domain

data class Payment(
    var amount: Int
) {
    init {
        require(amount >= 0) { "지불액은 음수가 될 수 없습니다." }
    }

    fun charge(charge: Int): Payment {
        require(amount >= charge) { "잔액 부족으로 금액을 차감할 수 없습니다." }
        return Payment(amount.minus(charge))
    }
}
