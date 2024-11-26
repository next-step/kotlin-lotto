package lotto.step3.domain

class LottoGame {
    fun execute(
        lastWeekWinningNumbers: Set<LottoNumber>,
        lottos: List<Lotto>,
        bonusNumber: LottoNumber,
    ): WinningStatistics {
        val rankMap =
            RankClassifier.classify(
                lottos = lottos,
                winningNumbers = lastWeekWinningNumbers,
                bonusNumber = bonusNumber,
            )
        val profit = LottoProfitManager.computeProfit(rankMap = rankMap)

        return WinningStatistics(
            rankMap = rankMap,
            profit = profit,
        )
    }
}
