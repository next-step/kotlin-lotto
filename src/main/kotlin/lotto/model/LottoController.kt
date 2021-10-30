package lotto.model

import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private lateinit var price: Price
    private lateinit var purchasedLotto: List<Lotto>

    fun runLottoGame() {
        inputPrice()
        generateLottos()
        getResult()
    }

    private fun inputPrice() {
        price = Price(inputView.inputLottoPrice())
        outputView.resultLottoCount(price.lottoCount)
    }

    private fun generateLottos() {
        purchasedLotto = GenerateLotto(price).generateLottoList()
        outputView.printNumber(purchasedLotto)
    }

    private fun getResult() {
        val winNumberList = inputView.inputLastLottoWinNumber()
        val lottos = Lottos.inputWinNumber(price, purchasedLotto, winNumberList)
        val result = lottos.compareLottoList()
        outputView.printWinStatistic(result)
    }
}
