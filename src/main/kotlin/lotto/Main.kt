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
    val lottoResult = lottoTicket.match(winningLotto) // Model
    ResultView.printResult(lottoResult) // View
    val totalRate = lottoResult.calculateTotalRate(money) // Model
    ResultView.printTotalRate(totalRate) // View
}

private fun buyLottoTicket(): Pair<Money, LottoTicket> {
    val money = InputView.inputMoney() // view
    val lottoTicket = LottoTicket(money) // model
    ResultView.printLottos(lottoTicket) // view
    return money to lottoTicket
}

private fun getLastWeekWinningLottoNumber(): WinningLotto {
    val winningNumber = InputView.inputWinningNumber() // View
    val bonusNumber = InputView.inputBonusNumber() // View
    return WinningLotto(winningNumber, bonusNumber) // model
}
