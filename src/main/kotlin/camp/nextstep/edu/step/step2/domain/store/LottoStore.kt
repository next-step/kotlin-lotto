package camp.nextstep.edu.step.step2.domain.store

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.result.LottoResult

object LottoStore {
    /**
     * @description : 로또 장당의 가격은 정부에서 정해진 정책만큼 가격이 달라지듯이 해당 미션에서는 각 Store마다 가격이 다르다고 가정했다.
     */
    private const val LOTTO_TICKET_PRICE = 1000L

    /**
     * @description : 구매금액에 따른 로또 티켓 수량을 구한다.
     */
    fun buyLottoTickets(buyAmount: BuyAmount): LottoTickets {
        val lottoTicketAmount = buyAmount.divideByLotteryPrice(ticketPrice = LOTTO_TICKET_PRICE)
        return LottoTickets(lottoTicketAmount)
    }

    /**
     * @description : 로또의 당첨결과르 확인한다. ( 보통 로또의 경우 구매처에서 용지를 넣고 확인하는 방식을 활용했다. )
     */
    fun checkLottoTicketsWinningResult(winningLotto: WinningLotto): LottoResult {

        val totalPrice =
            winningLotto.getTotalPriceByLottoAmountAndTicketPrice(ticketPrice = LOTTO_TICKET_PRICE)
        val matchResult = winningLotto.getLottoMatchResult()

        return LottoResult(totalPrice, matchResult)
    }

}
