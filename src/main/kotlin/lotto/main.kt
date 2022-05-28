package lotto

import lotto.domain.Issuer
import lotto.domain.Matcher
import lotto.domain.Profit
import lotto.domain.Store
import lotto.domain.WinCondition
import lotto.view.Console
import lotto.view.ConsoleOutput
import lotto.view.LottoView
import lotto.view.ManualIssueView
import lotto.view.MoneyView
import lotto.view.ProfitView
import lotto.view.ResultView
import lotto.view.WinNumberView

fun main() {
    val output = ConsoleOutput()
    val console = Console()

    val money = MoneyView(console).readMoney()

    val request = ManualIssueView(console).getPurchaseRequest(money)

    val store = Store(Issuer)
    val lottos = store.sell(request)

    LottoView(output, lottos).print()

    val winNumbers = WinNumberView(console).readWinNumbers()

    val matcher = Matcher(winNumbers, WinCondition.toWinPolicy())
    val result = matcher.makeResult(lottos)

    ResultView(output).print(result)

    val profits = Profit(money, result)

    ProfitView(output).print(profits)
}
