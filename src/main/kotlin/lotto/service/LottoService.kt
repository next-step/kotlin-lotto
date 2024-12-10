package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoPrice
import lotto.domain.LottoRandomGenerator
import lotto.domain.WinningResult

class LottoService {
    fun purchase(price: LottoPrice): List<Lotto> {
        val purchaseCount = price.calculatePurchaseCount()
        return (1..purchaseCount).map { LottoRandomGenerator.randomGenerate() }
    }

    fun calculateWinningResult(
        tickets: List<Lotto>,
        winningNumbers: Lotto,
    ): WinningResult {
        val winningStatistics =
            tickets.map { it.match(winningNumbers) }
                .groupBy { it }
                .mapValues { it.value.size }
                .filterKeys { it >= 3 }

        return WinningResult(winningStatistics)
    }
}
