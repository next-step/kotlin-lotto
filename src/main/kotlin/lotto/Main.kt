package lotto

import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice()
    val lottos = LottoStore.buyLottos(inputPrice)
    OutputView.printLotto(lottos)
}
