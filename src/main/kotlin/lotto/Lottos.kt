package lotto

import lotto.vo.Money

class Lottos(
    private val lottos: List<Lotto>,
) {
    private val totalPrice = Money(LottoShop.LOTTO_PRICE.amount * lottos.count())

    val size: Int = lottos.size

    fun playWith(winningNumbers: List<Int>): GameResult {
        val prizes = aggregateWinningPrizeWith(winningNumbers)

        return GameResult(
            prizes = prizes,
            paidPrice = totalPrice
        )
    }

    private fun aggregateWinningPrizeWith(winningNumbers: List<Int>): List<Pair<WinningPrize, Int>> {
        val defaultMap = WinningPrize.values().associateWith { 0 }.toMutableMap()

        return lottos
            .mapNotNull { WinningPrize.from(it.countMatchingNumbersFrom(winningNumbers)) }
            .groupBy { it }
            .mapValuesTo(defaultMap) { (_, value) -> value.size }
            .toList()
    }

    companion object {
        fun from(vararg lottos: Lotto): Lottos {
            return Lottos(lottos.toList())
        }
    }
}
