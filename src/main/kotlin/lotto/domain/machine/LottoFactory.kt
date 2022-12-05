package lotto.domain.machine

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money

class LottoFactory(
    private val money: Money
) {

    init {
        require(money.hasMore(LottoTicket.PRICE)) { "$money 는 티켓 가격보다 낮을 수 없어요." }
        require(money.isNotChangeLeft(LottoTicket.PRICE)) { "잔돈 ${money.value % LottoTicket.PRICE} 이 남을 수 없어요." }
    }

    fun buyTickets(manualNumbers: List<List<Int>>): LottoTickets {
        val manualLottoMachine = ManualLottoMachine(manualNumbers)

        val lottoTickets = manualLottoMachine.publish()
        val useMoney = money.useMoney(manualNumbers.size * LottoTicket.PRICE)

        val randomLottoMachine = RandomLottoMachine(useMoney)
        val randomLottoTickets = randomLottoMachine.publish()


        return lottoTickets.addAll(randomLottoTickets)
    }
}
