package lotto.ui

import lotto.domain.LottoTicket
import lotto.domain.Lottoes
import lotto.domain.Rank

class OutputView {

    fun printPurchasedLottoes(lottoes: Lottoes) {
        println("${lottoes.toList().size}개를 구매했습니다.")
        for (lotto in lottoes.toList()) {
            println(lotto.value.toString())
        }
    }

    fun printLottoesResult(money: Int, ranks: Map<Rank, List<LottoTicket>>) {
        println("\n당첨 통계")
        println("------------")
        println("3개 일치 (5000원) - ${ranks[Rank.FIFTH]?.size ?: 0}개")
        println("4개 일치 (50,000원) - ${ranks[Rank.FOURTH]?.size ?: 0}개")
        println("5개 일치 (1,500,000원) - ${ranks[Rank.THIRD]?.size ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranks[Rank.SECOND]?.size ?: 0}개")
        println("6개 일치 (2,000,000,000원) - ${ranks[Rank.FIRST]?.size ?: 0}개")

        printRateOfReturn(money, ranks)
    }

    private fun printRateOfReturn(money: Int, ranks: Map<Rank, List<LottoTicket>>) {
        var prizeMoney = 0
        ranks.keys.forEach {
            prizeMoney += it.prizeMoney * (ranks[it]?.size ?: 0)
        }

        println("총 수익률은 ${String.format("%.2f", prizeMoney.toFloat() / money.toFloat())}입니다.")
    }
}
