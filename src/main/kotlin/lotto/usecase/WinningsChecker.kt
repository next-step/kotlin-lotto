package lotto.usecase

import lotto.domain.WinningNumber
import lotto.domain.model.Lottos
import lotto.domain.model.WinningStatistics

class WinningsChecker {

    fun confirmWinning(
        lottos: Lottos,
        winningNumber: WinningNumber,
    ): WinningStatistics {
        val ranks = lottos
            .getLottos()
            .map { lotto ->
                lotto.sortilege(winningNumber)
            }

        return WinningStatistics(
            ranks = ranks
        )
    }
}
