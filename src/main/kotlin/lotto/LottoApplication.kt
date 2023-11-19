package lotto

import lotto.domain.LottoIssuer
import lotto.view.InputView
import lotto.view.ResultView

fun main() {

    val purchaseMoney = InputView.inputPurchaseMoney()

    val lottoIssuer = LottoIssuer()
    val lottos = lottoIssuer.issueLottoByAuto(purchaseMoney)

    ResultView.printPurchasedLottos(lottos)

    val winningLottoNumbers = InputView.inputWinningLottoNumbers()
}
