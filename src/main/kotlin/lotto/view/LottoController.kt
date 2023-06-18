package lotto.view

import lotto.domain.LottoShop

fun main() {
    val money = LottoInputView.inputMoney()
    val lottos = LottoShop.sellByMoney(money)
    LottoOutputView.printLottos(lottos)

    val winningNumbers = LottoInputView.inputWinningLottoNumbers()
    val lottosResult = lottos.calculateResults(winningNumbers)
    LottoOutputView.printLottoResults(lottosResult)
}
