package lotto.view

import lotto.entity.Lottery
import lotto.entity.WinLottery
import lotto.entity.WinLotteryResult

class ResultView {
    fun buyLottery(num: Int) {
        var buyLotteryMsg = "${num}개를 구매했습니다"
        println(buyLotteryMsg)
    }

    fun printLottery(lottery: Lottery) {
        println(lottery.values)
    }

    fun printWinResult(winLotteryResult: WinLotteryResult) {
        printWin(3, winLotteryResult.matchThree)
        printWin(4, winLotteryResult.matchFour)
        printWin(5, winLotteryResult.matchFive)
        printWin(6, winLotteryResult.matchSix)
    }

    private fun printWin(matchNum: Int, winLottery: WinLottery) {
        val printWinMsg = "${matchNum}개 일치 (${winLottery.reward}원) - ${winLottery.matchNum}개"
        println(printWinMsg)
    }
}
