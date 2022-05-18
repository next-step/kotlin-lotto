package lotto.contoller

import lotto.model.LottoBuilder
import lotto.model.LottoEvaluator
import lotto.model.data.Lotto
import lotto.model.data.Results
import lotto.view.input.InputView
import lotto.view.output.OutputView

class LottoController(
    private val lottoBuilder: LottoBuilder,
    private val lottoCountInputView: InputView<Int>,
    private val winningLottoInputView: InputView<Lotto>,
    private val outputView: OutputView? = null // option : to support headless
) {

    private val lottoEvaluator = LottoEvaluator

    fun executeGame(): Results {
        val countOfLotto = lottoCountInputView.getInput()
        val lottos = lottoBuilder.createLottos(countOfLotto)
        outputView?.printLottos(lottos)

        val winningLotto = winningLottoInputView.getInput()
        val resultList = lottoEvaluator.evaluate(winningLotto, lottos)
        outputView?.printResults(resultList)

        return resultList
    }
}
