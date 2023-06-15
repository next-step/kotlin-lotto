package lotto

import lotto.domain.LottoChecker
import lotto.domain.LottoGenerator
import lotto.io.ResultView

class LottoGame(amount: Int) {

    val lottos = LottoGenerator.generateLottos(amount)

    init {
        ResultView.printLottos(lottos)
    }

    fun getResult(winNumber: List<Int>): Map<Int, Int> {
        return LottoChecker.checkResult(lottos, winNumber)
    }
}
