package lotto.domain

class LottoGame {
    fun execute(
        lastWeekWinningNumbers: List<Int>,
        lottos: List<Lotto>,
    ): WinningStatistics {
        val matchedLottos = LottoMatcher.match(lottos, lastWeekWinningNumbers)
        val rewardMap = RewardClassifier.classify(matchedLottos)
        val profit = LottoProfitManager.computeProfit(matchedLottos)

        return WinningStatistics(
            rewardMap = rewardMap,
            profit = profit,
        )
    }
}
