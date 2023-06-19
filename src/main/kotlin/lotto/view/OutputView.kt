package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinResult
import lotto.dto.WinStats

object OutputView {
    fun printPurchase(lottoTickets: LottoTickets) {
        println("${lottoTickets.lottoTickets.size} 개를 구매했습니다.")
        lottoTickets.lottoTickets.forEach { println(it.lottoNumbers.toString()) }
    }

    fun printWinStats(winStats: WinStats) {
        println("당첨 통계\n" + "---------")

        val maps: Map<WinResult, Int> = winStats.matchMap
        val keys: Set<WinResult> = maps.keys
        keys.forEach {
            println("${it.matchCount}개 일치 (${it.reward}원)- ${maps[it]}개")
        }

        val yield = winStats.yield.toFloat()
        println("총 수익률은 ${String.format("%.2f", yield)}입니다.")
        if (yield < 1) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
}
