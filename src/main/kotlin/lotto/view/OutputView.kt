package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinResult
import lotto.dto.WinStats

object OutputView {
    fun printPurchase(manualLottoCount: Int, lottoTickets: LottoTickets) {
        println("수동으로 ${manualLottoCount}장, 자동으로 ${lottoTickets.lottoTickets.size - manualLottoCount} 개를 구매했습니다.")
        lottoTickets.lottoTickets.forEach { println(it.lottoNumbers.toString()) }
    }

    fun printWinStats(winStats: WinStats) {
        println("당첨 통계\n" + "---------")

        val maps: Map<WinResult, Int> = winStats.matchMap
        val keys: Set<WinResult> = maps.keys
        keys.forEach {
            print("${it.matchCount}개 일치, ")
            if (it.matchBonus) {
                print("보너스 볼 일치 ")
            }
            println("(${it.reward}원)- ${maps[it]}개")
        }

        val yield = winStats.yield.toFloat()
        println("총 수익률은 ${String.format("%.2f", yield)}입니다.")
        if (yield < 1) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
}
