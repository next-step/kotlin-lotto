package lotto

import lotto.domain.LottoManager
import lotto.ui.InputView

fun main() {

    val lottoManager = LottoManager()
    val lottos = lottoManager.buyLotto()
    val matchingLottoNumbers = InputView.readMatchingNumber()
    lottoManager.getResult(lottos, matchingLottoNumbers)
}
