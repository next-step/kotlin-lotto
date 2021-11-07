package lotto.usecase

import lotto.domain.model.Lottos

class PurchaseAmountCalculator {
    fun getTotalPurchaseAmount(lottos: Lottos): Int {
        return lottos
            .getLottos()
            .sumOf { lotto -> lotto.price.price }
    }
}
