package lotto.model

import lotto.model.lotto.Lotto
import lotto.model.lotto.Tickets
import lotto.model.lotto.WinnerNumbers
import lotto.model.prize.Money
import lotto.model.prize.Winners

class LottoManager(
    private val money: Money,
    tickets: Tickets = Tickets()
) {
    private val _lottos: MutableList<Lotto> by lazy {
        mutableListOf<Lotto>().apply {
            addAll(buyLottos(tickets))
            addAll(buyLottos(money.availableLottoCount()))
        }
    }
    val lottos: List<Lotto>
        get() = _lottos

    fun checkNumbers(winningNumbers: WinnerNumbers): Winners {
        val winners = lottos.map { it.checkNumbers(winningNumbers) }
        return Winners(winners)
    }

    private fun buyLottos(tickets: Tickets): List<Lotto> {
        money.buyLottos(tickets.size)
        return tickets.toLottos()
    }

    private fun buyLottos(availableLottoCount: Int) = Lotto.newAutoInstances(availableLottoCount)
}
