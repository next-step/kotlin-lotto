package lotto.domain.machine

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.TICKET_PRICE

class RandomLottoMachine(
    private val money: Int
) : LottoMachine {

    private val count
        get() = money / TICKET_PRICE

    init {
        require(money >= TICKET_PRICE) { "$money 는 티켓 가격보다 낮을 수 없어요." }
        require(money % TICKET_PRICE == 0) { "잔돈 ${money % TICKET_PRICE} 이 남을 수 없어요." }
    }

    override fun publish(): LottoTickets {
        return LottoTickets(
            (0 until count).map {
                createTicket(
                    (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER).shuffled().subList(0, LottoTicket.NUMBER_SIZE)
                )
            }
        )
    }


}
