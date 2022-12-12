package lotto.domain

import lotto.common.IntegerNumber

class Payment(
    val payment: IntegerNumber
) {
    init {
        require(payment.isNegative().not()) { "지불액은 음수가 될 수 없습니다." }
    }
}
