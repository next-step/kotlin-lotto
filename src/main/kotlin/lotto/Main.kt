package lotto

import lotto.domain.LottoMachine
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {

    val price = InputView.readPrice()

    val lottos = LottoMachine().buy(price)

    OutputView.printLottos(lottos)

    val matchingLottoNumbers = InputView.readMatchingNumber()

    val lottoResult = lottos.getLottoResult(matchingLottoNumbers)

    OutputView.printLottoResult(lottoResult)
}
