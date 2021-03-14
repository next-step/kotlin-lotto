package lotto.controller

import lotto.model.BonusNumbers
import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.Money
import lotto.model.WinningCounter
import lotto.model.WinningLotto
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val moneyAmount = Money(InputView.readLine("구입금액을 입력해 주세요.").toInt())

    val store = LottoStore()
    val tickets = store.buy(moneyAmount)

    OutputView.printTickets(tickets)

    val winningNumbers = WinningNumbers(InputView.readLine("지난 주 당첨 번호를 입력해 주세요.").split(",").map { it.toInt() })
    val bonusNumbers = BonusNumbers(listOf(InputView.readLine("보너스 볼을 입력해 주세요.").toInt()))

    val winningCounter = WinningCounter(tickets, WinningLotto(winningNumbers, bonusNumbers))
    val result = LottoResult(winningCounter, moneyAmount)

    OutputView.printResult(result)
}
