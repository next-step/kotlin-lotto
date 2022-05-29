package lotto

import lotto.domain.Issuer
import lotto.domain.Lotto
import lotto.domain.Matcher
import lotto.domain.Money
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

val output = ConsoleOutput()
val console = Console()

fun main() {
    val money = MoneyView(console).readMoney()
    val lottos = getLottos(money)

    LottoView(output, lottos).print()

    val winNumbers = WinNumberView(console).readWinNumbers()

    val matcher = Matcher(winNumbers, WinCondition.toWinPolicy())
    val result = matcher.makeResult(lottos)

    ResultView(output).print(result)

    val profits = Profit(money, result)

    ProfitView(output).print(profits)
}

tailrec fun getLottos(money: Money): List<Lotto> = runCatching {
    val request = ManualIssueView(console).getPurchaseRequest(money)
    val store = Store(Issuer)

    store.sell(request)
}.getOrElse {
    output.print(it.message ?: "에러가 발생했습니다.")

    return getLottos(money)
}
