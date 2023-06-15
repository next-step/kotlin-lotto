package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMaker
import lotto.domain.LottoPurchase
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoMaker = LottoMaker()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val purchaseAmount = LottoPurchase.affordableLottoCount(budget)
        resultView.printPurchaseAmount(purchaseAmount)

        val lottos = mutableListOf<Lotto>()
        repeat(purchaseAmount) {
            lottos.add(lottoMaker.auto())
        }

        lottos.forEach {
            resultView.printLotto(it)
        }
    }
}
