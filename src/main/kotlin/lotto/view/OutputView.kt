package lotto.view
import lotto.Lotto
import lotto.LottoRanking


object OutputView {
    fun showLottoList(lottoList: List<Lotto>) {
        lottoList.forEach {
            println(it.selectNumberList)
        }
        println()
    }

    fun showWinningStatus(winningStatus: Map<LottoRanking, Int>) {
        println("당첨 통계")
        printDivingLine()

        printStatus(LottoRanking.FourthPlace, winningStatus)
        printStatus(LottoRanking.ThirdPlace, winningStatus)
        printStatus(LottoRanking.SecondPlace, winningStatus)
        printStatus(LottoRanking.FirstPlace, winningStatus)
    }

    private fun printStatus(lottoRanking: LottoRanking, winningStatus: Map<LottoRanking, Int>) {
        val matchingLottoCnt = winningStatus.getOrDefault(lottoRanking, 0)
        val matchingNumberCnt = lottoRanking.matchingNumberCnt
        val matchingPrice = lottoRanking.price
        println("{${matchingNumberCnt}개 일치 (${matchingPrice}원)- ${matchingLottoCnt}개}")
    }

    private fun printDivingLine() {
        println("---------")
    }
}
