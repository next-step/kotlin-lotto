package lotto.step4.view

import lotto.step4.domain.Lotto
import lotto.step4.domain.LottoNumber
import lotto.step4.domain.Rank
import lotto.step4.domain.WinningStatistics

object OutputView {
    fun printPurchaseResult(
        manualLottos: List<Lotto>,
        autoLottos: List<Lotto>,
    ) {
        println("수동으로 ${manualLottos.size}장, 자동으로 ${autoLottos.size}개를 구매했습니다.")
        manualLottos.plus(autoLottos).forEach {
            this.printLottoNumbers(it.numbers)
        }
    }

    fun printStatistics(winningStatistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        this.printMatchCount(rank = Rank.FIFTH, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.FOURTH, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.THIRD, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.SECOND, rankMap = winningStatistics.rankMap)
        this.printMatchCount(rank = Rank.FIRST, rankMap = winningStatistics.rankMap)
        println("총 수익률은 ${winningStatistics.profit}입니다.")
    }

    private fun printLottoNumbers(lottoNumbers: List<LottoNumber>) {
        println(lottoNumbers.joinToString(", ", "[", "]"))
    }

    private fun printMatchCount(
        rank: Rank,
        rankMap: Map<Rank, Long>,
    ) {
        if (rank.hasBonusNumber) {
            println("${rank.matchCount}개 일치, 보너스 볼 일치(${rank.winningAmount}원)- ${rankMap[rank] ?: 0}개")
        } else {
            println("${rank.matchCount}개 일치 (${rank.winningAmount}원)- ${rankMap[rank] ?: 0}개")
        }
    }
}
