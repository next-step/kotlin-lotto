package lotto

import lotto.domain.LottoStatistics
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView(reader = ::readLine, writer = ::print)
    val resultView = ResultView(writer = ::print)

    val money = inputView.readPurchaseMoney()
    val lottoTickets = LottoStore.buy(money)
    resultView.printLottoTickets(lottoTickets)

    val lastLottoNumbers = inputView.readLastLottoNumbers()

    val lottoStatistics = LottoStatistics(lottoTickets, lastLottoNumbers)
    resultView.printLottoStatistics(lottoStatistics)
    resultView.printStatisticsProfit(lottoStatistics, money)
}
