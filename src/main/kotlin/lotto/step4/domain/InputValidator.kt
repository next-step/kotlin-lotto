package lotto.step4.domain

import lotto.step4.domain.LottoPurchaseManager.Companion.LOTTO_PRICE

object InputValidator {
    fun validateManualPurchaseCount(
        money: Money,
        count: Long,
    ) {
        if (money.value < LOTTO_PRICE.multiply(count).value) {
            throw IllegalArgumentException("최대 구입가능한 로또 개수를 초과하였습니다.")
        }
    }
}
