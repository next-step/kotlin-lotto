package lotto.domain

import lotto.unsupportedError

object LottoStore {

    private const val LOTTO_PRICE = 1000

    fun buyLotto(cash: Cash): Pair<Cash, LottoUnusedTickets> {
        val (restCash, ticketCount) = cash.buy(LOTTO_PRICE)
        check(ticketCount > 0) {
            unsupportedError("최소 한 장이상의 티켓을 구매할 수 있는 금액이어야합니다.")
        }
        return restCash to LottoUnusedTickets.from(ticketCount)
    }
}
