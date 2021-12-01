package lotto

import lotto.constant.Const
import lotto.domain.LottoShop
import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.validation.InputValidation

fun main() {
    val amount = InputView.getPurchaseAmount().also {
        InputValidation.checkAmountPaid(it)
    }.toInt()

    val lotto = LottoShop.exchangeMoneyForLotto(amount)
    ResultView.printLottoNumbers(lotto.getLottoNumbers())

    val winningNumber = InputView.getWinningNumber().also {
        InputValidation.checkWinningNumber(it)
    }.split(Const.LOTTO_NUMBER_DELIMITER)

    lotto.checkMatchingNumbers(winningNumber)
    ResultView.printWinningResult(lotto.getWinningStatus())

    val margin = lotto.getWinningStatus().getAllWinningAmount().toDouble() / amount.toDouble()
    ResultView.printMargin(margin)
}
