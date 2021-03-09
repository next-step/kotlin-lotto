package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.domain.LottoPaper
import lotto.domain.Money
import lotto.domain.Store
import lotto.view.InputView
import lotto.view.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val price = Money(inputView.requestPrice())
    val store = Store()
    val lottoPaper: LottoPaper = store.sell(price)

    outputView.renderLottoPaper(lottoPaper)

    val winLotto = Lotto(inputView.requestWinNums())
    val bonusNum = LottoNum.of(inputView.requestBonusNum())

    outputView.renderStatistics(lottoPaper.doStatistics(price, winLotto, bonusNum))
}
