package lotto.ui

import lotto.domain.Lottoes
import lotto.domain.Rank

class OutputView {

    fun printPurchasedLottoes(lottoes: Lottoes) {
        println("${lottoes.toList().size}개를 구매했습니다.")
        for (lotto in lottoes.toList()) {
            println(lotto.getLottoNumbers())
        }
    }

    fun printLottoesResult(ranks: List<Rank>) {
        println("\n당첨 통계")
        println("------------")
        println("3개 일치 (5000원) - ${ranks.count { rank -> rank == Rank.FIFTH }}개")
        println("4개 일치 (50,000원) - ${ranks.count { rank -> rank == Rank.FOURTH }}개")
        println("5개 일치 (1,500,000원) - ${ranks.count { rank -> rank == Rank.THIRD }}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranks.count { rank -> rank == Rank.SECOND }}개")
        println("6개 일치 (2,000,000,000원) - ${ranks.count { rank -> rank == Rank.FIRST }}개")
    }

    fun printRateOfReturn(money: Int, prizeMoney: Int) {
        println("총 수익률은 ${String.format("%.2f", prizeMoney.toFloat() / money.toFloat())}입니다.")
    }
}
