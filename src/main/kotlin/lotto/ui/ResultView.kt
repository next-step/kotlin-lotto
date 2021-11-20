package lotto.ui

import lotto.constant.Message
import lotto.domain.LottoNumber
import lotto.domain.WinningState

object ResultView {
    fun printLottoNumbers(numbers: List<LottoNumber>) {
        numbers.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printWinningResult(winningStatus: WinningState) {
        println()
        println(Message.WINNING_STATE)
        println(Message.LINE)
        printFourthCount(winningStatus.findFourthCount())
        printThirdCount(winningStatus.findThirdCount())
        printSecondCount(winningStatus.findSecondCount())
        printFirstCount(winningStatus.findFirstCount())
    }

    private fun printFourthCount(count: Int) {
        println(String.format(Message.FOURTH_COUNT_MESSAGE, count))
    }

    private fun printThirdCount(count: Int) {
        println(String.format(Message.THIRD_COUNT_MESSAGE, count))
    }

    private fun printSecondCount(count: Int) {
        println(String.format(Message.SECOND_COUNT_MESSAGE, count))
    }

    private fun printFirstCount(count: Int) {
        println(String.format(Message.FIRST_COUNT_MESSAGE, count))
    }

    fun printMargin(margin: Double) {
        println(String.format(Message.MARGIN_MESSAGE, margin))
    }
}
