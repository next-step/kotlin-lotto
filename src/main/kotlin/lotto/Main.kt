package lotto

import lotto.entity.Lotto
import lotto.entity.WinningNumber
import lotto.util.SplitString
import lotto.view.InputView
import lotto.view.OutputView
import lotto.workflow.RankLotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val money = inputView("구입금액을 입력해 주세요.")
    val lottoTickets = Lotto.ticketing(money)

    outputView.printPurchaseQuantity(lottoTickets.size)
    outputView.printLotto(lottoTickets)
    println()

    val winningNumberString = inputView("지난 주 당첨 번호를 입력해 주세요.")
    val numbers = SplitString.of(winningNumberString).extractNumbers()
    val winningNumber = WinningNumber.of(numbers)
    val rankLotto = RankLotto(winningNumber)
    val lottoResult = rankLotto(lottoTickets)
    println()

    outputView.printResult(lottoResult)
}
