package lotto.service

import PurchasedLottos
import lotto.domain.Lotto
import lotto.domain.LottoPrice
import lotto.domain.LottoRandomGenerator
import lotto.domain.Rank
import lotto.domain.WinningResult

class LottoService {
    fun purchase(price: LottoPrice): PurchasedLottos {
        val purchaseCount = price.calculatePurchaseCount()
        val tickets = (1..purchaseCount).map { LottoRandomGenerator.randomGenerate() }
        return PurchasedLottos(tickets)
    }

    fun checkWinning(
        lottos: PurchasedLottos,
        winningNumbers: Lotto,
    ): WinningResult {
        val winningStatistics =
            lottos.matchNumber(winningNumbers)
                .filterKeys { it != Rank.NONE }

        return WinningResult(winningStatistics)
    }
}
