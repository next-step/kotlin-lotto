package lotto.ui

import lotto.Lottoes
import lotto.Rank

class OutputView {
    fun printPurchasedQuantity(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun printPurchasedLottos(lottos: Lottoes) {
        for (lotto in lottos.toList()) {
            println(lotto.getLottoNumbers())
        }
    }

    fun printLottoesResult(ranks: List<Rank>) {
        println("3개 일치 (5000원) - ${ranks.count { rank -> rank == Rank.FIFTH }}")
        println("4개 일치 (50,000원) - ${ranks.count { rank -> rank == Rank.FOURTH }}")
        println("5개 일치 (1,500,000원) - ${ranks.count { rank -> rank == lotto.Rank.THIRD }}")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranks.count { rank -> rank == lotto.Rank.SECOND }}")
        println("6개 일치 (2,000,000,000원) - ${ranks.count { rank -> rank == lotto.Rank.FIRST }}")
    }

    fun printRateOfReturn() {
    }
}
