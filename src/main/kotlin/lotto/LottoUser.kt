package lotto

import kotlin.math.round

class LottoUser {
    val lottos: List<Lotto>
        get() = _lottos
    private val _lottos = arrayListOf<Lotto>()

    fun purchaseLotto(ableLottoPurchaseCount: Int) {
        _lottos.clear()
        _lottos.addAll(LottoSeller.sellLotto(ableLottoPurchaseCount))
    }

    fun calculateWinningMoney(winningNumber: List<Int>): Int {
        return _lottos.sumOf { lotto ->
            val sameCount = lotto.getContainLottoNumberSameCount(winningNumber)
            lotto.exchangeWinningMoney(sameCount)
        }
    }

    fun calculateRateOfReturn(spendMoney: Int, winningMoney: Int): Double {
        return round(winningMoney / spendMoney.toDouble() * 100) / 100
    }
}
