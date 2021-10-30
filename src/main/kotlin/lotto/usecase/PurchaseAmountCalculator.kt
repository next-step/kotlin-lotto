package lotto.usecase

import lotto.domain.Lotto

class PurchaseAmountCalculator {
    fun getTotalPurchaseAmount(lottos: List<Lotto>): Int {
        return lottos.sumOf { lotto -> lotto.price }
    }
}
