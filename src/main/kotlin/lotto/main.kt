package lotto

import lotto.domain.Issuer
import lotto.domain.Matcher
import lotto.domain.Money
import lotto.domain.Profit
import lotto.domain.Store
import lotto.domain.WinPolicy
import lotto.view.Console
import lotto.view.ConsoleOutput
import lotto.view.LottoView
import lotto.view.MoneyView
import lotto.view.ProfitView
import lotto.view.ResultView
import lotto.view.WinNumberView

fun main() {
    val output = ConsoleOutput()
    val console = Console()

    val money = MoneyView(console).readMoney()

    val store = Store(Issuer)
    val lottos = store.buy(money)

    LottoView(output, lottos).print()

    val winNumbers = WinNumberView(console).readWinNumbers()

    val policies = listOf(
        WinPolicy(3, Money(5000)),
        WinPolicy(4, Money(50000)),
        WinPolicy(5, Money(1500000)),
        WinPolicy(6, Money(2000000000)),
    )
    val matcher = Matcher(winNumbers, policies)
    val result = matcher.makeResult(lottos)

    ResultView(output).print(result)

    val profits = Profit(money, result)

    ProfitView(output).print(profits)
}
