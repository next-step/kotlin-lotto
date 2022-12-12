package lotto.domain

import lotto.common.Number

class Payment(
    val payment: Number
) {
    init {
        require(payment.isNegative().not()) { "지불액은 음수가 될 수 없습니다." }
    }
}
