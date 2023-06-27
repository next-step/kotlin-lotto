package lotto.service

import lotto.domain.LottoPurchase
import lotto.domain.Lottos
import lotto.domain.WinningLotto
import lotto.vo.LottosStatisticsVO
import lotto.vo.OrderRequest
import lotto.vo.Receipt

class LottoShopService {
    fun buy(orderRequest: OrderRequest): Receipt {
        val lottoPurchase = LottoPurchase(orderRequest)
        val lottos = lottoPurchase.purchaseManualAndAuto()

        return Receipt(orderRequest.allBudget, lottos, lottoPurchase.autoAmount, lottoPurchase.manualAmount)
    }

    fun winning(winningLotto: WinningLotto, lottos: Lottos, budget: Int): LottosStatisticsVO {
        val winningMap = lottos.winningMap(winningLotto)
        val totalPrizeMoney = winningMap.totalPrizeMoney()
        val rateOfReturn = totalPrizeMoney.toDouble() / budget.toDouble()

        return LottosStatisticsVO(winningMap, totalPrizeMoney, rateOfReturn)
    }
}
