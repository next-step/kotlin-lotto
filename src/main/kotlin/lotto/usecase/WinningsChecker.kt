package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.Rank
import lotto.domain.WinningNumber

class WinningsChecker {

    fun check(
        lottos: List<Lotto>,
        winningNumber: WinningNumber,
    ): LottoStatistics {
        val ranks = lottos.map { lotto ->
            lotto.sortilege(winningNumber)
        }
        val totalPurchaseAmount = lottos.sumOf { lotto -> lotto.price }

        return LottoStatistics(
            totalPurchaseAmount = totalPurchaseAmount,
            firstRank = ranks.filter { rank -> rank == Rank.FIRST }.size,
            secondRank = ranks.filter { rank -> rank == Rank.SECOND }.size,
            thirdRank = ranks.filter { rank -> rank == Rank.THIRD }.size,
            fourthRank = ranks.filter { rank -> rank == Rank.FOURTH }.size,
            totalReward = ranks.sumOf { rank -> rank.reward },
        )
    }
}
