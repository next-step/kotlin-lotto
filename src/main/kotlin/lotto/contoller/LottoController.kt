package lotto.contoller

import lotto.model.LottoEvaluator
import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Results
import lotto.view.input.InputView
import lotto.view.output.OutputView

class LottoController(
    private val lottosInputView: InputView<Lottos>,
    private val winningLottoInputView: InputView<Lotto>,
    private val outputView: OutputView? = null // option : to support headless
) {

    private val lottoEvaluator = LottoEvaluator

    fun executeGame(): Results {
        val lottos = lottosInputView.getInput()
        val winningLotto = winningLottoInputView.getInput()
        val resultList = lottoEvaluator.evaluate(winningLotto, lottos)
        outputView?.printResults(resultList)

        return resultList
    }
}
