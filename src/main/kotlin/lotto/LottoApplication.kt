package lotto

import lotto.domain.DefaultLottoGenerator
import lotto.domain.LottoPurchaseCount
import lotto.service.LottoService
import lotto.view.input.BuyInputView
import lotto.view.input.WinNumberInputView
import lotto.view.result.BuyResultView
import lotto.view.result.LottoListView
import lotto.view.result.LottoResultView

fun main() {
    val lottoService = LottoService(DefaultLottoGenerator)

    val payAmount = BuyInputView.print()
    val purchaseCount = LottoPurchaseCount(payAmount)
    BuyResultView.print(purchaseCount.amount)

    val lottos = lottoService.buy(purchaseCount)

    LottoListView.print(lottos)

    val winningNumbers = WinNumberInputView.print()
    val results = lottoService.getResults(lottos, winningNumbers)

    LottoResultView.print(results)
}
