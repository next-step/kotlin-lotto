package lotto

class LottoGame {
    fun execute(lastWeekWinningNumbers: List<Int>, lottos: List<Lotto>): WinningStatistics {
        val afterLottos = LottoMatcher.match(lottos, lastWeekWinningNumbers)

        return WinningStatistics(
            map = RewardManager.find(afterLottos),
            profit = ProfitCalculator.calculate(afterLottos),
        )
    }


    fun execute2(lastWeekWinningNumbers: List<Int>, lottos: List<Lotto>) {
        val result = lottos.map { lotto ->
            lotto.pickNumbers.count { lastWeekWinningNumbers.contains(it) }
        }
        val afterLottos = LottoMatcher.match(lottos, lastWeekWinningNumbers)
        val matchCount = result.groupingBy { it }.eachCount()
        val threeMatchCount = matchCount[3] ?: 0
        val fourMatchCount = matchCount[4] ?: 0
        val fiveMatchCount = matchCount[5] ?: 0
        val sixMatchCount = matchCount[6] ?: 0

        println("당첨 통계")
        println("---------")
        println("3개 일치 ($threeMatchCount) - ${threeMatchCount * 5000}원")
        println("4개 일치 ($fourMatchCount) - ${fourMatchCount * 50000}원")
        println("5개 일치 ($fiveMatchCount) - ${fiveMatchCount * 1500000}원")
        println("6개 일치 ($sixMatchCount) - ${sixMatchCount * 2000000000}원")
        println("총 수익률은 ${ProfitCalculator.calculate(afterLottos)}입니다.")
    }
}