package lotto.view

import lotto.domain.Lottos
import lotto.domain.Rank
import lotto.domain.RankFactory

object OutputView {

    fun printEnterPayment() {
        println("구입금액을 입력해 주세요.")
    }

    fun printEnterManualLottoCount() {
        println("수동으로 구매할 로또 수를 입력해주세요.")
    }

    fun printEnterManualLottoNumbers() {
        println("수동으로 구매할 번호를 입력해 주세요.")
    }

    fun printPurchaseCount(manualLottoCount: Int, lottoCount: Int) {
        println("수동으로 ${manualLottoCount}장, 자동으로 ${lottoCount - manualLottoCount}개를 구매했습니다.")
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

    fun printBonusBall() {
        println("보너스 볼을 입력해주세요.")
    }

    fun printWinnerStatistics() {
        println("당첨 통계")
        println("---------")
    }

    fun printStatisticsAccordingToBonus(rankFactory: RankFactory) {
        for (rank in rankFactory.getRanks().reversed()) {
            printNumberOfMatches(rank, rankFactory)
        }
    }

    private fun printNumberOfMatches(rank: Rank, rankFactory: RankFactory) {
        if (rank.isSecond()) {
            println("${rank.matchCount}개 일치, 보너스 볼 일치(${rank.winningMoney})- ${rankFactory.getRankCount(rank)}개")
            return
        }
        println("${rank.matchCount}개 일치 (${rank.winningMoney})- ${rankFactory.getRankCount(rank)}개")
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
