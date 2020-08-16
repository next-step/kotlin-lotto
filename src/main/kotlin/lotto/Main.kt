package lotto

import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val (money, lottoTicket) = buyLottoTicket()
    val winningLotto = getLastWeekWinningLottoNumber()
    checkLotto(lottoTicket, winningLotto, money)
}

private fun checkLotto(
    lottoTicket: LottoTicket,
    winningLotto: WinningLotto,
    money: Money
) {
    val lottoResult = lottoTicket.match(winningLotto)
    ResultView.printResult(lottoResult, money)
}

private fun buyLottoTicket(): Pair<Money, LottoTicket> {
    val money = InputView.inputMoney()
    val manualCount = InputView.inputManualNumberCount(money)
    val manualLottos = InputView.inputManualNumber(manualCount)
    val lottoTicket = LottoTicket(money, manualLottos)
    ResultView.printLottos(lottoTicket)
    return money to lottoTicket
}

private fun getLastWeekWinningLottoNumber(): WinningLotto {
    val winningNumber = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()
    return WinningLotto(winningNumber, bonusNumber)
}
