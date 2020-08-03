package lotto

import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.Results
import lotto.view.ResultView.showAmountsSold
import lotto.view.ResultView.showLottoDetails
import lotto.view.ResultView.showResults
import lotto.view.InputView

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
