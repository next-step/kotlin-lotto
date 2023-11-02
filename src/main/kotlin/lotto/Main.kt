package lotto

import lotto.domain.LottoStore
import lotto.view.InputView

fun main() {

    val inputPrice = InputView.inputPrice()
    val lottos = LottoStore.buyLottos(inputPrice)
}
