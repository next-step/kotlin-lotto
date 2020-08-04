package lotto

import lotto.model.LottoManager
import lotto.view.ResultView

class MoneyManager(
    private val input: Int = 10_100,
    private val resultView: ResultView = ResultView
) {
    fun buyLotto() {
        val lottos = LottoManager(input)
        resultView.showLottos(lottos.lottos)
    }
}
