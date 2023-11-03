package lotto.view

import lotto.constants.WinningRank
import lotto.domain.Lottos
import lotto.domain.RateOfReturn

object OutputView {

    fun printLotto(lottos: Lottos) {
        println("로또 ${lottos.getLottoCount()}개를 구매했습니다.")
        lottos.lottos.forEach { lotto ->
            println(lotto.lottoNumbers)
        }
    }

    fun printWinningResult(winningRankList: List<WinningRank>) {
        println("당첨 통계")
        println("---------")
        winningRankList.printWinningResult(WinningRank.FIFTH)
        winningRankList.printWinningResult(WinningRank.FOURTH)
        winningRankList.printWinningResult(WinningRank.THIRD)
        winningRankList.printWinningResult(WinningRank.SECOND)
        winningRankList.printWinningResult(WinningRank.FIRST)
    }

    private fun List<WinningRank>.printWinningResult(targetWinningRank: WinningRank) {
        val count = this.filter { it == targetWinningRank }.size
        if (targetWinningRank == WinningRank.SECOND) {
            println("${targetWinningRank.count}개 일치, 보너스 볼 일치(${targetWinningRank.money}원)- ${count}개")
            return
        }
        println("${targetWinningRank.count}개 일치 (${targetWinningRank.money}원)- ${count}개")
    }

    fun printRateOfReturn(inputPrice: Int, winningRankList: List<WinningRank>) {
        val rateOfReturn = RateOfReturn(inputPrice, winningRankList).calculate()
        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
