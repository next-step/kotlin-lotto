package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoMatcher
import lotto.domain.LottoShop
import lotto.domain.Money.PaidMoney
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val paidMoney = PaidMoney(InputView.getPurchaseAmount())
    val lottoTickets = LottoShop().buyLotto(paidMoney)
    ResultView.showLottoInfo(lottoTickets)

    val winningLotto = WinningLotto.from(InputView.getWinningNumbers())
    val bonusNumber = BonusNumber.from(InputView.getBonusNumber())
    LottoMatcher.also { matcher ->
        val matchResult = matcher.matchResult(lottoTickets, winningLotto, bonusNumber)
        val earnedRate = matcher.calculateEarnedRate(matchResult.earnedMoney, paidMoney)
        ResultView.showMatchResult(matchResult, earnedRate)
    }
}
