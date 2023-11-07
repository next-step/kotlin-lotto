package lotto

import lotto.domain.LottoConstants
import lotto.domain.LottoMachine
import lotto.dto.LottoMatchResult
import lotto.dto.LottoRevenueCalculator
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine(LottoConstants.TICKET_PRICE)
    // 구입 금액을 입력받습니다.
    val amount = InputView.getAmount()
    // 구입 금액에 해당하는 로또 티켓을 발급합니다.
    val tickets = lottoMachine.generateTickets(amount)
    ResultView.showTickets(tickets)
    // 지난 주 당첨 번호를 입력받습니다.
    val winningNumbers = InputView.getWinningNumbers()
    // 당첨 결과를 계산합니다.
    val matchResult = LottoMatchResult(tickets, winningNumbers)
    ResultView.showStatistics(matchResult)
    // 총 구입 금액을 계산합니다.
    val purchaseAmount = tickets.size * LottoConstants.TICKET_PRICE.toDouble()
    // 수익률을 계산합니다.
    val revenueCalculator = LottoRevenueCalculator(matchResult)
    val returnRate = revenueCalculator.calculateReturnRate(purchaseAmount)
    ResultView.showReturnRate(returnRate)
}
