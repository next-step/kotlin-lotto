package lotto.controller

import lotto.domain.Lotto
import lotto.service.InputParser
import lotto.service.LottoService
import lotto.view.LottoGameView
import lotto.view.LottoView

class LottoController(private val lottoService: LottoService) {

    fun start() {
        val purchaseAmount = getPurchaseAmount()
        val n = purchaseAmount / 1000

        LottoGameView.printBuyAmount(n)

        val lottos = lottoService.buy(n)

        lottos.map { LottoView(it).print() }

        val winningLotto = getLastWinningLotto()
        val lottoGame = lottoService.createGame(lottos, winningLotto)

        LottoGameView.printWinningStats(lottoGame)
    }

    private fun getPurchaseAmount(): Int {
        LottoGameView.printPurchaseAmountInput()

        val purchaseAmount = InputParser.parsePurchaseAmount(readLine()!!)

        return purchaseAmount
    }

    private fun getLastWinningLotto(): Lotto {
        LottoGameView.printLastWinningNumbers()

        return Lotto(InputParser.parseWinningNumbers(readLine()!!))
    }
}
