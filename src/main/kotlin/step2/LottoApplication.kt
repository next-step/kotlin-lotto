package step2

import step2.domain.*
import step2.ui.InputView
import step2.ui.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoPurchaseCount = InputView.getPurchaseCount(purchaseAmount)

    val lottoList = List(lottoPurchaseCount) {
        Lotto(RandomGenerateStrategy().of())
    }

    OutputView.generateLotto(lottoList)

    val answerCount = Lottos(lottoList).getAnswerCountList(InputView.answerLotto())

    val winningAmount = Statistics().matchCount(answerCount)

    OutputView.lottoResult(Statistics.matchResult())
    OutputView.rateOfReturn(winningAmount, purchaseAmount)
}
