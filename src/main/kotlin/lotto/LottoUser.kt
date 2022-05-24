package lotto

import kotlin.math.round

class LottoUser {
    val lottos: List<Lotto>
        get() = _lottos
    private val _lottos = arrayListOf<Lotto>()

    fun purchaseLotto(money: Int) {
        _lottos.clear()
        _lottos.addAll(LottoSeller.sellLotto(money))
    }

    fun calculateWinningMoney(winningNumber: List<Int>): Int {
        var winningMoney = 0
        _lottos.forEach { lotto ->
            val sameCount = lotto.getContainLottoNumberSameCount(winningNumber)
            winningMoney += lotto.exchangeWinningMoney(sameCount)
        }

        return winningMoney
    }

    fun calculateRateOfReturn(spendMoney: Int, winningMoney: Int): Double {
        return round(winningMoney / spendMoney.toDouble() * 100) / 100
    }
}
