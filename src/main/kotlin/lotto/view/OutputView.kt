package lotto.view

import lotto.constants.WinningRank
import lotto.domain.Lottos
import lotto.domain.WinningRanks

object OutputView {

    fun printLotto(lottos: Lottos) {
        println("수동으로 ${lottos.manualLottoCount()}장, 자동으로 ${lottos.autoLottoCount()}개를 구매했습니다.")
        lottos.lottos.forEach { lotto ->
            println(lotto.lottoNumbers)
        }
    }

    fun printWinningResult(winningMap: Map<WinningRank, Int>) {
        println(WINNING_STATISTICS)
        println(SEPARATOR)
        WinningRank.values().filter { it != WinningRank.MISS }
            .sortedDescending()
            .forEach { printWinningRanks(winningMap, it) }
    }

    private fun printWinningRanks(winningMap: Map<WinningRank, Int>, printWinningRank: WinningRank) {
        val winningCount = winningMap[printWinningRank] ?: 0
        if (printWinningRank == WinningRank.SECOND) {
            return println("${printWinningRank.count}개 일치, 보너스 볼 일치(${printWinningRank.money}원)- ${winningCount}개")
        }
        println("${printWinningRank.count}개 일치 (${printWinningRank.money}원)- ${winningCount}개")
    }

    fun printRateOfReturn(inputPrice: Int, winningRanks: WinningRanks) {
        val rateOfReturn = winningRanks.calculateRateOfReturn(inputPrice)
        println("총 수익률은 ${rateOfReturn}입니다.")
    }

    private const val WINNING_STATISTICS = "당첨 통계"
    private const val SEPARATOR = "---------"
}
