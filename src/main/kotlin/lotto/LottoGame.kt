package lotto

import lotto.domain.LottoGenerator
import lotto.io.ResultView

class LottoGame(amount: Int) {
    val lottos = LottoGenerator.generateLottos(amount)
    fun start() {
        ResultView.printLottos(lottos)
    }
}
