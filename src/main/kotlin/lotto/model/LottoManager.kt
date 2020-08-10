package lotto.model

import lotto.model.lotto.Lotto
import lotto.model.lotto.WinnerNumbers
import lotto.model.prize.Money
import lotto.model.prize.Winners

class LottoManager(money: Money) {
    private val _lottos: List<Lotto> = (1..money.availableLottoCount()).map { makeLotto() }
    val lottos: List<Lotto>
        get() = _lottos

    fun checkNumbers(winningNumbers: WinnerNumbers): Winners {
        val winners = lottos.map { it.checkNumbers(winningNumbers) }
        return Winners(winners)
    }

    private fun makeLotto() = Lotto.newAutoInstance()
}
