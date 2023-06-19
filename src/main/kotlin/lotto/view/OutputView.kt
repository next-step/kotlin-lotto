package lotto.view

import lotto.domain.Lottos
import lotto.domain.Rank

object OutputView {

    fun printEnterPayment() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printLottos(lottos: Lottos) {
        for (lottoNumbers in lottos.lottoNumbers) {
            println(lottoNumbers)
        }
        println()
    }

    fun printWinningNumbersLastWeek() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    fun printWinnerStatistics() {
        println("당첨 통계")
        println("---------")
    }

    fun printNumberOfMatches(ranks: List<Rank>) {
        for (rank in ranks) {
            println("${rank.title} (${rank.amount})- ${rank.count}개")
        }
    }

    fun printProfitRate(profitRate: Double) {
        print(String.format("총 수익률은 %.2f입니다.", profitRate))
        if (profitRate < 1) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        } else {
            println()
        }
    }
}
