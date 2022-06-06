package lotto

import lotto.domain.LottoMatcher
import lotto.domain.LottoShop
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val paidMoney = InputView.getPurchaseAmount()
    val lottoTickets = LottoShop().buyLotto(paidMoney)
    ResultView.showLottoInfo(lottoTickets)
    val winningNumbers = InputView.getWinningNumbers()
    LottoMatcher().apply {
        val matchResult = matchResult(lottoTickets, WinningNumber(winningNumbers))
        val earnedMoney = getEarnedMoney(matchResult)
        val earnedRate = getEarnedRate(paidMoney, earnedMoney)
        ResultView.showMatchResult(matchResult, earnedRate)
    }
}
