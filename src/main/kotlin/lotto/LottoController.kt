package lotto

import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun buy() {
        // 금액 입력
        val inputCash = InputView.readCash()

        // 로또 구매
        val (restCash, unusedTickets) = LottoStore.buyLotto(inputCash)

        // 수동으로 티켓 사용
        val ticketCountForManual = InputView.ticketCountForManual()
        val (ticketsForManual, ticketsForAuto) = unusedTickets.divide(ticketCountForManual)
        val manualUsedTickets = InputView.ticketsToManual(ticketsForManual)

        // 나머지 자동
        val autoUsedTickets = ticketsForAuto.toAuto()

        // 티켓 결과 보여주기
        OutputView.displayTickets(manualUsedTickets, autoUsedTickets)

        // 당첨 번호 입력
        val winTicket = InputView.readWinNumber()

        // 당첨 검사
        val rewards = (manualUsedTickets + autoUsedTickets).evaluate(winTicket)
        OutputView.displayRewards(rewards)

        // 당첨 통계
        val rewardCash = rewards.exchange()
        val profitRate = rewardCash.calculateYield(inputCash.subtract(restCash))
        OutputView.displayProfitRate(profitRate)
    }
}
