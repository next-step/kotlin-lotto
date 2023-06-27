package lotto.domain

import lotto.vo.LottosStatisticsVO
import lotto.vo.OrderRequest
import lotto.vo.Receipt

class LottoShop {
    fun buy(orderRequest: OrderRequest): Receipt {
        val lottoPurchase = LottoPurchase(orderRequest)
        val lottos = lottoPurchase.purchaseManualAndAuto()

        return Receipt(orderRequest.allBudget, lottos, lottoPurchase.autoAmount, lottoPurchase.manualAmount)
    }

    fun winning(winningLotto: WinningLotto, lottos: Lottos, budget: Int): LottosStatisticsVO {
        return winningLotto.statistics(lottos, budget)
    }
}
