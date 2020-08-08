package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.LuckyNumbers
import lotto.domain.Payment
import lotto.domain.Profit
import lotto.domain.Result
import lotto.view.ResultView.showPurchasedQuantity
import lotto.view.ResultView.showLottosDetail
import lotto.view.ResultView.showResults
import lotto.view.InputView
import lotto.view.ResultView.showProfitRatio

fun main() {

    val payment = Payment(InputView.readPayment())

    val lottos = Lottos(LottoShop.sellLottos(payment))

    val quantity = LottoShop.quantitySold(payment)
    showPurchasedQuantity(quantity)
    if (quantity == 0) return

    showLottosDetail(lottos)

    LottoUtils.luckyNumbers = LuckyNumbers(InputView.readLuckyNumbers())
    LottoUtils.bonusNumber = BonusNumber(InputView.readBonusNumber())

    val result = Result(lottos)
    val profit = Profit(result.getProfit())

    showResults(result.getResult())
    showProfitRatio(profit.getProfitRatio(payment))
}
