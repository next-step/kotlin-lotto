package lotto.app

import lotto.domain.LottoStore
import lotto.domain.AutoLottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutPutView

fun main() {
    val purchaseAmount = InputView().readPurchaseAmount()
    val lottoCount = LottoStore().calculateLottoCount(purchaseAmount)
    OutPutView().printLottoCount(lottoCount)
    val lottos = LottoStore().issueLottos(lottoCount, AutoLottoNumberGenerator())
    OutPutView().printLottos(lottos)

    val winningNumbers = InputView().readWinningNumbers()
}
