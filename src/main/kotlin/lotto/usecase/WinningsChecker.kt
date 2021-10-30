package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.WinningNumber
import lotto.domain.WinningStatistics

class WinningsChecker {

    fun confirmWinning(
        lottos: List<Lotto>,
        winningNumber: WinningNumber,
    ): WinningStatistics {
        val ranks = lottos.map { lotto ->
            lotto.sortilege(winningNumber)
        }

        return WinningStatistics(
            ranks = ranks
        )
    }
}
