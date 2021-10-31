package lotto

import lotto.model.LottoResult
import lotto.model.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val amount = inputView.getPurchaseAmount()
        val shop = LottoShop()
        val lottoList = shop.buy(amount)
        outputView.printLottoList(lottoList)

        val winnerNumbers = inputView.getWinnerLottoNumbers()
        val result = LottoResult.of(lottoList, winnerNumbers)
        outputView.printLottoResult(result)
    }
}
