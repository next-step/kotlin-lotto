package lotto

import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.Results
import lotto.view.ResultView.showSalesVolume
import lotto.view.ResultView.showLottosDetail
import lotto.view.ResultView.showResults
import lotto.view.InputView

fun main() {

    val payment = InputView.readPayment()

    val lottoShop = LottoShop(payment)
    val lottos = Lottos(lottoShop.makeLottos())

    showSalesVolume(lottoShop)
    showLottosDetail(lottos)

    val luckyNumbers = InputView.readLuckyNumbers()
    LottoUtils.luckyNumbers = luckyNumbers

    Results.payment = payment
    showResults(lottos.getResults())
}
