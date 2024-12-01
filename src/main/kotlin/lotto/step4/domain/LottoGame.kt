package lotto.step4.domain

class LottoGame {
    fun execute(
        lastWeekWinningNumbers: Set<LottoNumber>,
        lottos: Lottos,
        bonusNumber: LottoNumber,
    ): WinningStatistics {
        val ranks =
            lottos.matchWinningNumbers(
                winningNumbers = lastWeekWinningNumbers,
                bonusNumber = bonusNumber,
            )
        val profit = ranks.profit()

        return WinningStatistics(
            ranks = ranks,
            profit = profit,
        )
    }
}
