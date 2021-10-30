package lotto

import lotto.model.GenerateLotto
import lotto.model.LottoController
import lotto.model.Lottos
import lotto.model.Price
import lotto.view.InputView
import lotto.view.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    LottoController.runLottoGame()
    // val price = inputView.inputLottoPrice()
    // val lottoPrice = Price(price)
    // outputView.resultLottoCount(lottoPrice.lottoCount)
    //
    // val list = GenerateLotto(lottoPrice).generateLottoList()
    // outputView.printNumber(list)
    //
    // val winNumberList = inputView.inputLastLottoWinNumber()
    // val lottos = Lottos.inputWinNumber(lottoPrice, list, winNumberList)
    // val result = lottos.compareLottoList()
    // outputView.printWinStatistic(result)
}
