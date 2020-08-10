package lotto.model

import lotto.model.lotto.Lotto
import lotto.model.lotto.WinnerNumbers
import lotto.model.prize.Money
import lotto.model.prize.Winners

class LottoManager(money: Money) {
    private val _lottos: List<Lotto>
    val lottos: List<Lotto>
        get() = _lottos

    init {
        _lottos = (1..money.availableLottoCount()).map { _ ->
            makeLotto()
        }
    }

    fun checkNumbers(winningNumbers: WinnerNumbers): Winners {
        val winners = lottos.map { it.checkNumbers(winningNumbers) }
        return Winners(winners)
    }

    private fun makeLotto() = Lotto.newAutoInstance()
}
