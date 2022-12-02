package lotto.domain.machine

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

class LottoFactory(
    private val money: Int
) {

    init {
        require(money >= LottoTicket.PRICE) { "$money 는 티켓 가격보다 낮을 수 없어요." }
        require(money % LottoTicket.PRICE == 0) { "잔돈 ${money % LottoTicket.PRICE} 이 남을 수 없어요." }
    }

    fun isBuyAble(buyCount: Int) = buyCount * LottoTicket.PRICE <= money

    fun buyTickets(manualNumbers: List<List<Int>>): LottoTickets {
        val manualLottoMachine = ManualLottoMachine(manualNumbers)

        val lottoTickets = manualLottoMachine.publish()

        val randomLottoMachine = RandomLottoMachine(money - manualNumbers.useMoney())
        val randomLottoTickets = randomLottoMachine.publish()

        return lottoTickets.addAll(randomLottoTickets)
    }

    private fun List<List<Int>>.useMoney() = this.size * LottoTicket.PRICE

}
