package lotto.domain

import lotto.common.IntegerNumber

class Payment(
    var payment: IntegerNumber
) {
    init {
        require(payment.isNegative().not()) { "지불액은 음수가 될 수 없습니다." }
    }

    fun charge(charge: IntegerNumber) {
        require(payment.number >= charge.number) { "잔액 부족으로 금액을 차감할 수 없습니다." }
        payment = payment.minus(charge)
    }
}
