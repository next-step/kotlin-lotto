package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.WinningNumber

class WinningsChecker {

    fun confirmWinning(
        lottos: List<Lotto>,
        winningNumber: WinningNumber,
    ): LottoStatistics {
        val ranks = lottos.map { lotto ->
            lotto.sortilege(winningNumber)
        }
        val totalPurchaseAmount = lottos.sumOf { lotto -> lotto.price }

        return LottoStatistics(
            totalPurchaseAmount = totalPurchaseAmount,
            ranks = ranks,
            totalReward = ranks.sumOf { rank -> rank.reward },
        )
    }
}
