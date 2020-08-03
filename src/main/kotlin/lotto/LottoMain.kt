package lotto

import lotto.ResultView.showAmountsSold
import lotto.ResultView.showLottoDetails
import lotto.ResultView.showResults

fun main() {

    val payment = InputView.readPayment()

    val lottoShop = LottoShop(payment)
    val lottos = Lottos(lottoShop.makeLottos())

    showAmountsSold(lottoShop)
    showLottoDetails(lottos)

    val luckyNumbers = InputView.readLuckyNumbers()
    LottoUtils.luckyNumbers = luckyNumbers

    Results.totalPayment = payment
    showResults(lottos.findResults())
}
