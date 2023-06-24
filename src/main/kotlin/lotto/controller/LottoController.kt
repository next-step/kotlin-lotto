package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.LottoReturnCalculator
import lotto.domain.LottoVendingMachine
import lotto.domain.LottoWinningNumbers
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasedLottos = LottoVendingMachine()
        .purchase(InputView.getPurchaseAmount())
    ResultView.printLotto(purchasedLottos)
    val lottoNumbersOfLastWeek = getLottoWinningNumbers()
    val lottoReturn = LottoReturnCalculator(purchasedLottos).calculate(lottoNumbersOfLastWeek)
    ResultView.printReturn(lottoReturn)
}

private tailrec fun getLottoWinningNumbers(): LottoWinningNumbers {
    runCatching {
        LottoWinningNumbers(
            LottoNumbers(InputView.getLottoNumbersOfLastWeek()),
            InputView.getBonusNumber()
        )
    }.onSuccess {
        return it
    }.onFailure {
        ResultView.printError(it)
    }
    return getLottoWinningNumbers()
}
