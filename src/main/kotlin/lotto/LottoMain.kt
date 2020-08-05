package lotto

import lotto.LottoUtils.provideNumbers
import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Result
import lotto.view.ResultView.showPurchaseAmounts
import lotto.view.ResultView.showLottosDetail
import lotto.view.ResultView.showResults
import lotto.view.InputView
import lotto.view.ResultView.showProfitRatio

fun main() {

    val payment = InputView.readPayment()
    val amounts = payment / LOTTO_PRICE

    val lottos = Lottos((1..amounts).map { Lotto(provideNumbers()) })

    showPurchaseAmounts(amounts)
    showLottosDetail(lottos)

    LottoUtils.luckyNumbers = InputView.readLuckyNumbers()

    val result = Result(lottos)

    showResults(result.getResult())
    showProfitRatio(result.getProfitRatio(payment))
}
