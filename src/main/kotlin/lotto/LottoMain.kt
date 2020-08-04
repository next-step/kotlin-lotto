package lotto

import lotto.LottoUtils.provideNumbers
import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Results
import lotto.view.ResultView.showPurchaseAmounts
import lotto.view.ResultView.showLottosDetail
import lotto.view.ResultView.showResults
import lotto.view.InputView

fun main() {

    val payment = InputView.readPayment()
    val amounts = payment / LOTTO_PRICE

    val lottos = Lottos((1..amounts).map { Lotto(provideNumbers()) })

    showPurchaseAmounts(amounts)
    showLottosDetail(lottos)

    val luckyNumbers = InputView.readLuckyNumbers()
    LottoUtils.luckyNumbers = luckyNumbers

    Results.payment = payment
    showResults(lottos.getResults())
}
