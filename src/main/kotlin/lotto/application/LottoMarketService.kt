package lotto.application

import lotto.core.LottoMarket
import lotto.core.Lottos

object LottoMarketService {
    fun start(purchaseAmount: String?): Lottos {
        return LottoMarket.purchase(purchaseAmount)
    }
}
