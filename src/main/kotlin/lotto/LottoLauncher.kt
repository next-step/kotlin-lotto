package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.domain.LottoPaper
import lotto.domain.Money
import lotto.domain.Store
import lotto.domain.WinLotto
import lotto.view.InputView
import lotto.view.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val price = Money(inputView.requestPrice())
    val selfLottosNums = inputView.requestSelfLottosNums()

    val lottoPaper: LottoPaper = Store().sell(price, selfLottosNums)

    outputView.renderLottoPaper(selfLottosNums.size, lottoPaper)

    val winLotto = WinLotto(Lotto.createLotto(inputView.requestWinNums()), LottoNum.from(inputView.requestBonusNum()))

    outputView.renderStatistics(lottoPaper.doStatistics(price, winLotto))
}
