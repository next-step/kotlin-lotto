package lotto

import lotto.application.LottoService
import lotto.domain.Price
import lotto.view.InputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).checkLottoCount()
    InputView.printBoughtLotto(lottoCount)
    val lottoService = LottoService.from(lottoCount)
    val lottos = lottoService.lottos
}
