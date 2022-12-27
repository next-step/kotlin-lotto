package lotto.domain

class Payment(
    var payment: Int
) {
    init {
        require(payment >= 0) { "지불액은 음수가 될 수 없습니다." }
    }

    fun charge(charge: Int) {
        require(payment >= charge) { "잔액 부족으로 금액을 차감할 수 없습니다." }
        payment = payment.minus(charge)
    }
}
