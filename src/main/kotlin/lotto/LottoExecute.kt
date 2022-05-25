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

    var first = 0
    var second = 0
    var third = 0
    var fourth = 0

    lottoUser.lottos.forEach { lotto ->
        when (lotto.getContainLottoNumberSameCount(winningNumbers)) {
            Lotto.FOURTH_WINNING_NUMBER_SAME_COUNT -> fourth++
            Lotto.THIRD_WINNING_NUMBER_SAME_COUNT -> third++
            Lotto.SECOND_WINNING_NUMBER_SAME_COUNT -> second++
            Lotto.FIRST_WINNING_NUMBER_SAME_COUNT -> first++
        }
    }

    val winningMoney = lottoUser.calculateWinningMoney(winningNumbers)
    LottoOutputView.printWinningStatistics(fourth = fourth, third = third, second = second, first = first)
    LottoOutputView.printRateOfReturn(
        lottoUser.calculateRateOfReturn(
            spendMoney = LottoSeller.LOTTO_PRICE * ableLottoPurchaseCount,
            winningMoney = winningMoney
        )
    )
}
