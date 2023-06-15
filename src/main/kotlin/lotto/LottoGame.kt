package lotto

import lotto.domain.LottoGenerator
import lotto.io.ResultView

class LottoGame(amount: Int) {
    val lottos = LottoGenerator.generateLottos(amount)
    init {
        ResultView.printLottos(lottos)
    }
}
