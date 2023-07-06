package lotto.domain

import lotto.view.ExceptionMessage

@JvmInline
value class PurchaseAmount(val amount: Int) {
    init {
        require(amount >= 1000) { ExceptionMessage.REQUIRE_MORE_THAN_1000.message }
    }
}
