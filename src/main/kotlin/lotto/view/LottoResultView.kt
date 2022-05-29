package lotto.view

import lotto.domain.NormalLottery
import lotto.infra.port.OutputSystem
import lotto.vo.LotteryRank
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
        val curriedPrintLottery = { rank: LotteryRank -> { printLottery(rank, lottoSet, winningNormalLottery) } }

        curriedPrintLottery(LotteryRank.FOUR_PLACE)()
        curriedPrintLottery(LotteryRank.THIRD_PLACE)()
        curriedPrintLottery(LotteryRank.TWO_PLACE)()
        curriedPrintLottery(LotteryRank.ONE_PLACE)()

        outputSystem.write("총 수익률은 ${lottoSet.rate(winningNormalLottery)}입니다.")
    }

    private fun printLottery(lotteryRank: LotteryRank, lottoSet: LottoSet<NormalLottery>, winningNormalLottery: NormalLottery) {
        val count = lottoSet.countPlace(winningNormalLottery, lotteryRank)
        outputSystem.write("${lotteryRank.matchCount}개 일치(${lotteryRank.rewardMoney}원)-${count}개\n")
    }
}
