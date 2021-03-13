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
    val selfLottoNumsList = inputView.requestSelfLottosNums().map { LottoNum.listFrom(it) }

    val lottoPaper: LottoPaper = Store().sell(price, selfLottoNumsList)

    outputView.renderLottoPaper(selfLottoNumsList.size, lottoPaper)

    val winLotto = WinLotto(Lotto(inputView.requestWinNums().map { LottoNum.from(it) }), LottoNum.from(inputView.requestBonusNum()))

    outputView.renderStatistics(lottoPaper.doStatistics(price, winLotto))
}
