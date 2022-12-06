package lotto.domain.machine

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money

class DefaultLottoMachine(
    var money: Money
) {

    init {
        require(money.isNotChangeLeft(LottoTicket.PRICE)) { "잔돈 ${money.value % LottoTicket.PRICE} 이 남을 수 없어요." }
    }

    fun publishManual(input: List<List<Int>>): LottoTickets {
        money = money.useMoney(input.size * LottoTicket.PRICE)

        return LottoTickets(
            input.map {
                LottoTicket(*it.toIntArray())
            }
        )
    }

    fun publishRandom(range: IntRange): LottoTickets {
        val count = money.value / LottoTicket.PRICE
        money = money.useMoney(count * LottoTicket.PRICE)

        return LottoTickets(
            (0 until count).map {
                createTicket(
                    range.shuffled().subList(0, LottoTicket.NUMBER_SIZE)
                )
            }
        )
    }

    private fun createTicket(numbers: List<Int>): LottoTicket {
        return LottoTicket(numbers.map { LottoNumber.of(it) }.toSet())
    }
}
