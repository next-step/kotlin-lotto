package step2

import step2.domain.*
import step2.ui.InputView
import step2.ui.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()

    val lottoPurchaseCount = InputView.getPurchaseCount(purchaseAmount)

    val answer = Lotto(InputView.answer())

    val lottoList = Lottos(List(lottoPurchaseCount) { RandomGenerateStrategy().of() })

    OutputView.generateLotto(lottoList)

    val answerCount = lottoList.getAnswerCountList(answer)

    val statistics = Statistics(answerCount)

    OutputView.lottoResult(statistics.matchResult())

    val rateOfRevenue = statistics.rateOfRevenue(statistics.revenue(), purchaseAmount)

    OutputView.rateOfReturn(rateOfRevenue)
}
