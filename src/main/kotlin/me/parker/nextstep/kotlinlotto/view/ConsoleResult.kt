package me.parker.nextstep.kotlinlotto.view

import me.parker.nextstep.kotlinlotto.domain.LottoRank
import me.parker.nextstep.kotlinlotto.domain.LottoResult
import me.parker.nextstep.kotlinlotto.domain.LottoTicket

object ConsoleResult {
    fun outputPurchasedLottoTickets(purchasedLottoTickets: List<LottoTicket>) {
        println("${purchasedLottoTickets.size}개를 구매했습니다.")
        purchasedLottoTickets.forEach {
            println(it.lottoNumbers.values.joinToString(prefix = "[", postfix = "]"))
        }
    }

    fun outputLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")

        lottoResult.matchCount.forEach { (rank, count) ->
            if (rank == LottoRank.MISS) return@forEach

            if (rank == LottoRank.SECOND) {
                println("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.prize}원)- ${count}개")
                return@forEach
            }

            println("${rank.matchCount}개 일치 (${rank.prize}원)- ${count}개")
        }

        println("총 수익률은 ${String.format("%.2f", lottoResult.profitRate)}입니다.")
    }
}
