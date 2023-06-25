package lotto

import lotto.domain.LottoGame
import lotto.view.InputView

fun main() {
    val purchasePrice = InputView.inputPurchasePrice()
    val lottoGame = LottoGame(lottoPrice = purchasePrice)
    val previousLottoNumbers = InputView.inputPreviousLottoNumbers()
}
