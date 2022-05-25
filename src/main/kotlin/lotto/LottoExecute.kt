package lotto

import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() {
    val money: Int = LottoInputView.inputLottoPurchase()

    val ableLottoPurchaseCount: Int = LottoSeller.ableSellLottoCount(money)

    val lottoUser = LottoUser()
    lottoUser.purchaseLotto(ableLottoPurchaseCount)
    LottoOutputView.printPurchaseLotto(ableLottoPurchaseCount)

    LottoOutputView.printLottoNumbers(lottoUser.lottos)

    val winningNumbers: List<Int> = LottoInputView.inputWinningNumbers()

    val winningMoney = lottoUser.calculateWinningMoney(winningNumbers)
    LottoOutputView.printWinningStatistics(lottos = lottoUser.lottos, winningNumbers = winningNumbers)
    LottoOutputView.printRateOfReturn(
        lottoUser.calculateRateOfReturn(
            spendMoney = LottoSeller.LOTTO_PRICE * ableLottoPurchaseCount,
            winningMoney = winningMoney
        )
    )
}
