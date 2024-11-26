package lotto

object ResultView {
    fun printBoughtLotto(boughtLotto: Lottos) {
        boughtLotto.values.forEach { lottos ->
            println("[%s]".format(lottos.values.sorted().map { it.value }.joinToString(", ")))
        }
    }

    fun printStatistics(statistics: LottoStatistics) {
        println("당첨 통계")
        println("---------")
        Rank.prizeRanks.forEach {
            val count = statistics.machRankCount(it)
            println("${it.matchCount}개 일치 (${it.prize.value}원) - ${count}개")
        }
        printRate(statistics)
    }

    private fun printRate(statistics: LottoStatistics) {
        val result = if (statistics.isLoss()) "손해" else "이익"

        println("총 수익률은 ${statistics.rate()}입니다.(기준이 1이기 때문에 결과적으로 ${result}이라는 의미임)")
    }

    fun print(message: String) {
        println(message)
    }
}
