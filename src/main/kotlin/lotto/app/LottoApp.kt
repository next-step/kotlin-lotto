package lotto.app

import lotto.domain.AutoLottoNumberGenerator
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutPutView

fun main() {
    val purchaseAmount = InputView().readPurchaseAmount()
    val lottoCount = LottoStore().calculateLottoCount(purchaseAmount)
    OutPutView().printLottoCount(lottoCount)
    val purchasedLottos = LottoStore().issueLottos(lottoCount, AutoLottoNumberGenerator())
    OutPutView().printPurchasedLottos(purchasedLottos)

    val winningNumbers = InputView().readWinningNumbers()
}
