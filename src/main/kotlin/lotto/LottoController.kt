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
        val lottoList = shop.buyLotto(amount)
        outputView.printLottoList(lottoList)

        val winnerNumbers = inputView.getWinnerLottoNumbers()
        val result = LottoResult(lottoList, winnerNumbers)
        outputView.printLottoResult(result)
    }
}
