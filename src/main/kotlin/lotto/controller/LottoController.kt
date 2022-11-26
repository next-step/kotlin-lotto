package lotto.controller

import lotto.domain.lotto.Lotto
import lotto.infra.io.LottoInputReader
import lotto.view.LottoAnswerInputView
import lotto.view.LottoCostInputView
import lotto.view.LottoResultView
import lotto.view.LottoView

class LottoController(
    private val lottoView: LottoView = LottoView(),
    private val lottoResultView: LottoResultView = LottoResultView(),
    private val lottoAnswerInputView: LottoAnswerInputView = LottoAnswerInputView(),
    private val lottoCostInputView: LottoCostInputView = LottoCostInputView(),
    private val lottoInputReader: LottoInputReader = LottoInputReader()
) {

    fun run() {
        lottoCostInputView.printLottoCostInputView()

        val lottoCost = lottoInputReader.readLottoCost()

        val lotto = Lotto(lottoCost.cost)

        lottoView.printLottoView(lotto)

        println()

        lottoAnswerInputView.printLottoAnswerInputView()

        val lottoAnswer = lottoInputReader.readLottoAnswer()

        val lottoResult = lotto.result(lottoAnswer)

        println()

        lottoResultView.printLottoResultView(lottoResult)
    }
}