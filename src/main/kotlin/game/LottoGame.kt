package game

import game.domain.lotto.machine.LottoMachine
import game.view.ConsoleInput
import game.view.ConsoleOutput
import game.view.Input
import game.view.Output

class LottoGame(private val input: Input, private val output: Output) {
    fun run() {
        val purchaseMoney = input.askLottoPurchaseMoney()
        val lotto = LottoMachine.issueLottoAutomatically(purchaseMoney.getLottoPurchaseCount())
        output.printPurchaseList(lotto)
        val winningNumber = input.askWinningNumber()
        val lottoResult = winningNumber.match(lotto)
        output.printStatistics(lottoResult)
    }
}

fun main() {
    val lottoGame = LottoGame(ConsoleInput(), ConsoleOutput())
    lottoGame.run()
}
