package lotto.domain

import java.math.BigDecimal

class Lottos constructor(
    val values: List<Lotto>,
) {
    init {
        require(values.isNotEmpty()) {
            "로또 구입을 위한 최소 금액은 ${LOTTO_PRICE.value} 입니다."
        }
    }

    fun totalMatchResults(winning: Winning): Map<WinningAmount, Int> {
        val winningAmountMap = WinningAmount.values()
            .associateWith { 0 }.toMutableMap()

        values.forEach {
            val winningAmount = winning.matchResult(it)
            winningAmountMap[winningAmount] = winningAmountMap[winningAmount]!!.inc()
        }

        return winningAmountMap
    }

    companion object {
        private val LOTTO_PRICE: Money = Money(BigDecimal.valueOf(1_000))

        fun buyLottos(money: Money): Lottos {
            val lottos = mutableListOf<Lotto>()
            repeat(money.divideInt(LOTTO_PRICE)) { lottos.add(Lotto.autoCreate()) }
            return Lottos(values = lottos)
        }
    }
}
