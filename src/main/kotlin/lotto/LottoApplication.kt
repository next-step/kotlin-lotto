package lotto

import lotto.domain.Amount
import lotto.domain.LottoIssuer
import lotto.domain.RandomIssueStrategy
import lotto.view.InputView
import lotto.view.ResultView


fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottoIssuer = LottoIssuer(Amount(1_000), RandomIssueStrategy)
    val lottoTicket = lottoIssuer.issue(purchaseAmount)

    ResultView.writeLottoTicket(lottoTicket)

    val winningNumber = InputView.readWinningNumber()
    val lottoRank = winningNumber.evaluateRank(lottoTicket)

    ResultView.writeLottoRank(lottoRank)
}
