package lotto.contoller

import lotto.model.LottoEvaluator
import lotto.model.data.Lottos
import lotto.model.data.Results
import lotto.model.data.WinningLotto
import lotto.view.input.InputView
import lotto.view.output.OutputView

class LottoController(
    private val lottosInputView: InputView<Lottos>,
    private val winningLottoInputView: InputView<WinningLotto>,
    private val outputView: OutputView? = null // option : to support headless
) {

    private val lottoEvaluator = LottoEvaluator

    fun executeGame(): Results {
        val lottos = lottosInputView.getInput()
        val winningLotto = winningLottoInputView.getInput()
        val results = lottoEvaluator.evaluate(winningLotto, lottos)
        outputView?.printResults(results)
        return results
    }
}
