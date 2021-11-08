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
        val lottoNumbers = inputView.getManualLottoNumbers()
        val shop = LottoShop()
        val lottoList = shop.buy(amount, lottoNumbers)
        outputView.printLottoList(lottoList)

        val winnerNumbers = inputView.getWinnerLottoNumbers()
        val bonus = inputView.getBonusLottoNumber()
        val result = LottoResult.of(lottoList, winnerNumbers, bonus)
        outputView.printLottoResult(result)
    }
}
