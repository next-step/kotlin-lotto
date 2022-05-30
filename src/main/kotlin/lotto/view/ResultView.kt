package lotto.view

import lotto.domain.PurchaseRecord
import lotto.domain.Winner
import lotto.domain.WinnerStat

object ResultView {
    fun printPurchaseRecord(purchaseRecord: PurchaseRecord) {
        println("${purchaseRecord.lottoList.size}개를 구매 했습니다.")

        purchaseRecord.lottoList.map {
            println(it.toString(",", "[", "]"))
        }
    }

    fun printWinnerStat(winnerStat: WinnerStat) {
        println("당첨 통계")
        println("---------")

        Winner.values()
            .sortedBy { it.matchedNumbers }
            .forEach { winner ->
                val winNumbers = winnerStat.winnerMap.getOrDefault(winner, 0)
                println("${winner.matchedNumbers}개 일치 (${winner.prizeMonery}원) - ${winNumbers}개")
            }

        println("총 수익률은 ${winnerStat.per()}. (${getAppendix(winnerStat.per())})")
    }

    private fun getAppendix(per: Double): String {
        if (per > 1) {
            return "기준이 1이기 때문에 결과적으로 이득라는 의미임"
        } else if (per == 1.toDouble()) {
            return "기준이 1이기 때문에 결과적으로 본전이라는 의미임"
        } else {
            return "기준이 1이기 때문에 결과적으로 손해라는 의미임"
        }
    }
}
