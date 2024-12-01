package lotto.step4.view

import lotto.step4.domain.LottoNumber
import lotto.step4.domain.Lottos
import lotto.step4.domain.Rank
import lotto.step4.domain.Ranks
import lotto.step4.domain.WinningStatistics

object OutputView {
    fun printPurchaseResult(
        manualLottos: Lottos,
        autoLottos: Lottos,
    ) {
        println("수동으로 ${manualLottos.size()}장, 자동으로 ${autoLottos.size()}개를 구매했습니다.")
        manualLottos.add(autoLottos).getAll().forEach {
            this.printLottoNumbers(it.numbers)
        }
    }

    fun printStatistics(winningStatistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        printMatchCount(winningStatistics.ranks)
        println("총 수익률은 ${winningStatistics.profit}입니다.")
    }

    private fun printLottoNumbers(lottoNumbers: List<LottoNumber>) {
        println(lottoNumbers.joinToString(", ", "[", "]"))
    }

    private fun printMatchCount(ranks: Ranks) {
        ranks.asMap()
            .filterNot { (rank, _) -> rank == Rank.MISS } // MISS 제외
            .forEach { (rank, count) ->
                println(formatRankOutput(rank, count))
            }
    }

    private fun formatRankOutput(
        rank: Rank,
        count: Long,
    ): String {
        return if (rank.hasBonusNumber) {
            "${rank.matchCount}개 일치, 보너스 볼 일치(${rank.winningAmount}원)- ${count}개"
        } else {
            "${rank.matchCount}개 일치 (${rank.winningAmount}원)- ${count}개"
        }
    }
}
