package lotto

object ResultView {
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

    fun printBoughtLotto(user: User) {
        println("수동으로 ${user.manualLottoSize}장, 자동으로 ${user.autoLottoSize}개를 구매했습니다.")
        user.totalLottos.values.forEach { lottos ->
            println("[%s]".format(lottos.values.sorted().map { it.value }.joinToString(", ")))
        }
    }
}
