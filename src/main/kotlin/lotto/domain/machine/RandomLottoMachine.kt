package lotto.domain.machine

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money

class RandomLottoMachine(
    private val money: Money
) : LottoMachine {

    private val count
        get() = money.value / LottoTicket.PRICE

    init {
        require(money.isNotChangeLeft(LottoTicket.PRICE)) { "잔돈 ${money.value % LottoTicket.PRICE} 이 남을 수 없어요." }
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
