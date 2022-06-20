package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoMatcher
import lotto.domain.LottoShop
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val paidMoney = InputView.getPurchaseAmount()
    val lottoTickets = LottoShop().buyLotto(paidMoney)
    ResultView.showLottoInfo(lottoTickets)

    val winningNumbers = WinningNumber(InputView.getWinningNumbers())
    val bonusNumber = BonusNumber(InputView.getBonusNumber())
    LottoMatcher().also { matcher ->
        val matchResult = matcher.matchResult(lottoTickets, winningNumbers, bonusNumber)
        val earnedRate = matcher.calculateEarnedRate(matchResult.earnedMoney, paidMoney)
        ResultView.showMatchResult(matchResult, earnedRate)
    }
}
