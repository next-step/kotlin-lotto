package lotto.view

import lotto.Lottos
import lotto.rank.LottoRank

object ResultView {
    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다")
    }

    fun printLottoList(lottos: Lottos) {
        lottos.lottos.forEach { println(it.numbers.numbers) }
        println()
    }

    fun printStatistics(lottoRanks: List<LottoRank>) {
        println("당첨 통계")
        println("---------")

        lottoRanks
            .filter { it != LottoRank.NONE }
            .groupBy { it.key }
            .forEach { (key, ranks) -> println("${key.matchCount}개 일치 ${key.message ?: ""} (${ranks.first().prize}원) - ${ranks.size}개") }
    }

    fun printProfit(profit: Double) {
        println("총 수익률은 ${profit}입니다.")
    }
}
