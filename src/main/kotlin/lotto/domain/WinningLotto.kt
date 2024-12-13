package lotto.domain

import Lottos

class WinningLotto(
    private val numbers: Lotto,
    private val bonusNumber: LottoNumber,
) {
    fun checkWinning(lottos: Lottos): WinningResult {
        val winningStatistics =
            lottos.matchNumber(numbers, bonusNumber)
                .filterKeys { it != Rank.NONE }

        return WinningResult(winningStatistics)
    }
}
