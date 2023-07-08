package lotto.ui

import lotto.LottoTicket
import lotto.Match

object ResultView {
    fun printPurchasedTicket(lottoTicket: LottoTicket) {
        println("${lottoTicket.size} 개 구매했습니다")
        lottoTicket.lottos.map { lotto ->
            lotto.numbers.map { it.value }
        }.forEach {
            println(it)
        }
    }

    fun printMatchResult(matches: List<Match>) {
        println("당첨 통계")
        println("---------")
        Match.values().forEach {
            println("${it.count}개 일치 (${it.winningAmount}원) - ${matches.count { match -> match == it }}개")
        }
    }

}
