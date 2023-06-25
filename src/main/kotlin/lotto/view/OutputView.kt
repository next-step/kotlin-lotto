package lotto.view

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.LottoTickets

class OutputView {
    fun printTickets(lottoTickets: LottoTickets) {
        println("${lottoTickets.values.size}개를 구매했습니다.")
        lottoTickets.values.forEach {
            println(it.values)
        }
    }

    fun printWinningStatistics(lottoResult: LottoResult) {
        println("\n당첨 통계")
        println("--------")
        for (rank in LottoRank.values().reversed()) {
            if (rank == LottoRank.MISS) {
                continue
            }
            print("${rank.countOfMatch}개 일치")
            if (rank == LottoRank.SECOND) {
                print(", 보너스 볼 일치")
            }
            println(" (${rank.price}) - ${lottoResult.map[rank] ?: 0}개")
        }
    }

    fun printProfitRate(profitRate: Double) {
        if (profitRate < 0.5) {
            println("총 수익률은 ${profitRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
            return
        }
        println("총 수익률은 ${profitRate}입니다.")
    }
}