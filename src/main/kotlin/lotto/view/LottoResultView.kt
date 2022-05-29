package lotto.view

import lotto.domain.NormalLottery
import lotto.infra.port.OutputSystem
import lotto.vo.LottoScore
import lotto.vo.LottoSet

class LottoResultView(private val outputSystem: OutputSystem) {

    fun printResult(lottoSet: LottoSet<NormalLottery>, winningNormalLottery: NormalLottery) {
        printHeadLine()
        staticalLottery(lottoSet, winningNormalLottery)
    }

    private fun printHeadLine() {
        outputSystem.write("당첨 통계\n")
        outputSystem.write("-------\n")
    }

    private fun staticalLottery(lottoSet: LottoSet<NormalLottery>, winningNormalLottery: NormalLottery) {
        val curriedPrintLottery = { rank: LottoScore -> { printLottery(rank, lottoSet, winningNormalLottery) } }

        LottoScore
            .values()
            .drop(1)
            .map {
                curriedPrintLottery(it)()
            }

        outputSystem.write("총 수익률은 ${lottoSet.rate(winningNormalLottery)}입니다.")
    }

    private fun printLottery(lotteryRank: LottoScore, lottoSet: LottoSet<NormalLottery>, winningNormalLottery: NormalLottery) {
        val count = lottoSet.countPlace(winningNormalLottery, lotteryRank)
        outputSystem.write("${lotteryRank.matchCount}개 일치(${lotteryRank.rewardMoney}원)-${count}개\n")
    }
}
