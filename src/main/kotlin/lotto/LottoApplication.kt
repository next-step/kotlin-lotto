package lotto

import lotto.domain.Amount
import lotto.domain.LottoIssuer
import lotto.domain.LottoWinningNumber
import lotto.domain.RandomIssueStrategy
import lotto.view.InputView
import lotto.view.ResultView


fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottoIssuer = LottoIssuer(Amount(1_000), RandomIssueStrategy)
    val lottoTicket = lottoIssuer.issue(purchaseAmount)

    ResultView.writeLottoTicket(lottoTicket)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val lottoWinningNumber = LottoWinningNumber(winningNumbers, bonusNumber)
    val lottoRank = lottoTicket.evaluateRank(lottoWinningNumber)

    ResultView.writeLottoRank(lottoRank)
}
