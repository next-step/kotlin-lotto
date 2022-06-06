package lotto.controller

import lotto.LottoGameService
import lotto.view.LottoGameView
import lotto.view.LottoView

class LottoController(val lottoGameService: LottoGameService) {

    fun start() {
        LottoGameView.printPurchaseAmountInput()

        val amount = readLine()!!.toInt()
        val n = amount / 1000

        LottoGameView.printBuyAmount(n)

        val lottos = lottoGameService.buy(n)

        lottos.map { LottoView(it).print() }
    }
}
