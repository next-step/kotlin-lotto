package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoVendor
import lotto.view.InputView
import lotto.view.LottoResult
import lotto.view.ResultView

fun main() {
    val lottoApplication = LottoApplication()
    lottoApplication.run()
}

class LottoApplication {
    fun run() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val lottos = LottoVendor.purchaseLotto(purchaseAmount)
        ResultView.printLotto(lottos)

        val winnerLottoNumbers = LottoNumbers.from(InputView.inputWinnerLottoNumbers())
        val bonusNumber = LottoNumber.from(InputView.inputBonusNumber())
        val lottoRanks = lottos.map { it.matchLotto(winnerLottoNumbers, bonusNumber) }
        val lottoResult = LottoResult(lottoRanks)
        ResultView.printLottoResult(lottoResult, purchaseAmount)
    }
}
