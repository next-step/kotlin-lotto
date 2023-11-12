package camp.nextstep.edu.step.step2.domain.store

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Numbers
import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import camp.nextstep.edu.step.step2.domain.result.LottoResult

object LottoStore {
    private const val LOTTO_TICKET_PRICE = 1000

    /**
     * @description : 구매금액에 따른 로또 티켓 수량을 구한다.
     */
    fun buyLottoTickets(buyAmount: BuyAmount): LottoTickets {
        val lottoTicketAmount =
            buyAmount.getAmount().divide(LOTTO_TICKET_PRICE.toBigDecimal()).toInt()
        return LottoTickets(lottoTicketAmount)
    }

    /**
     * @description : 로또의 당첨결과르 확인한다. ( 보통 로또의 경우 구매처에서 용지를 넣고 확인하는 방식을 활용했다. )
     */
    fun checkLottoTicketsWinningResult(
        lottoNumbers: List<Numbers>,
        lastWeekNumbers: Numbers
    ): LottoResult {
        val totalPrice = lottoNumbers.size * LOTTO_TICKET_PRICE
        val matchResult = lottoNumbers
            .map { numbers -> numbers.countMatch(lastWeekNumbers) }
            .map { LottoMatch.of(it) }
            .sorted()

        return LottoResult(totalPrice, matchResult)
    }

}
