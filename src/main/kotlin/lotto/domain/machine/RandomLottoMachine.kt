package lotto.domain.machine

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

class RandomLottoMachine(
    private val money: Int
) : LottoMachine {

    private val count
        get() = money / LottoTicket.PRICE

    init {
        require(money >= LottoTicket.PRICE) { "$money 는 티켓 가격보다 낮을 수 없어요." }
        require(money % LottoTicket.PRICE == 0) { "잔돈 ${money % LottoTicket.PRICE} 이 남을 수 없어요." }
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
