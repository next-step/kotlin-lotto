package lotto.view

import lotto.domain.Lotto
import lotto.infra.port.OutputSystem
import lotto.vo.LottoScore
import lotto.vo.LottoSet

class LottoResultView(private val outputSystem: OutputSystem) {

    fun printResult(lottoSet: LottoSet, winningLottery: Lotto) {
        printHeadLine()
        staticalLottery(lottoSet, winningLottery)
    }

    private fun printHeadLine() {
        outputSystem.write("당첨 통계\n")
        outputSystem.write("-------\n")
    }

    private fun staticalLottery(lottoSet: LottoSet, winningLottery: Lotto) {
        val curriedPrintLottery = { rank: LottoScore -> { printLottery(rank, lottoSet, winningLottery) } }

        curriedPrintLottery(LottoScore.FOUR_PLACE)()
        curriedPrintLottery(LottoScore.THIRD_PLACE)()
        curriedPrintLottery(LottoScore.TWO_PLACE)()
        curriedPrintLottery(LottoScore.ONE_PLACE)()

        outputSystem.write("총 수익률은 ${lottoSet.rate(winningLottery)}입니다.")
    }

    private fun printLottery(lotteryRank: LottoScore, lottoSet: LottoSet, winningLottery: Lotto) {
        val count = lottoSet.countPlace(winningLottery, lotteryRank)
        outputSystem.write("${lotteryRank.matchCount}개 일치(${lotteryRank.rewardMoney}원)-${count}개\n")
    }
}
