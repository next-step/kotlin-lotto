package lotto.component

import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView,
    private val lotto: Lotto,
) {
    fun run() {
        val input = lottoInputView.getInput()
        val result = lotto.draw(input.lottoNumbers, input.winningNumbers)

        lottoResultView.printLottoResult(result)
    }
}
