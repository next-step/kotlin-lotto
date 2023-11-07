package study.lotto.view

class ResultView {
    fun displayLottos(lottoNumbersList: List<List<Int>>) {
        println("${lottoNumbersList.size}개를 구매했습니다.")
        lottoNumbersList.forEach { println(it) }
    }

    fun displayStatistics(statistics: Map<Int, Int>) {
        println("당첨 통계")
        println("---------")
        statistics.toSortedMap().forEach { (matchCount, count) ->
            val prize = getPrizeUnit(matchCount)
            println("${matchCount}개 일치 ($prize)- ${count}개")
        }
    }

    private fun getPrizeUnit(matchCount: Int) = when (matchCount) {
        3 -> "5000원"
        4 -> "50000원"
        5 -> "1500000원"
        6 -> "2000000000원"
        else -> "0원"
    }

    fun displayProfitRate(profitRate: Double) {
        val resultMessage = getProfitRateMessage(profitRate)
        println(
            "총 수익률은 ${String.format("%.2f", profitRate)}입니다." +
                "(기준이 1이기 때문에 결과적으로 $resultMessage(이)라는 의미임)"
        )
    }

    private fun getProfitRateMessage(profitRate: Double) = when {
        profitRate > 1 -> "이익"
        profitRate < 1 -> "손해"
        else -> "본전"
    }
}
