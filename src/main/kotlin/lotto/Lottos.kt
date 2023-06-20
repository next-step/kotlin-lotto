package lotto

import lotto.vo.LottoNumber

data class Lottos(
    private val lottos: List<Lotto>,
) : Iterable<Lotto> {
    private val totalPrice = LottoShop.LOTTO_PRICE * lottos.count()

    val size: Int = lottos.size

    fun playWith(winningNumbers: List<LottoNumber>): GameResult {
        val prizes = aggregateWinningPrizeWith(winningNumbers)

        return GameResult(
            prizes = prizes,
            paidPrice = totalPrice,
        )
    }

    private fun aggregateWinningPrizeWith(winningNumbers: List<LottoNumber>): List<Pair<WinningPrize, Int>> {
        val defaultMap = WinningPrize
            .values()
            .associateWith { 0 }
            .toMutableMap()

        return lottos
            .mapNotNull { WinningPrize.from(it.countMatchingNumbersFrom(winningNumbers)) }
            .groupBy { it }
            .mapValuesTo(defaultMap) { (_, value) -> value.size }
            .toList()
    }

    override fun iterator(): Iterator<Lotto> {
        return lottos.iterator()
    }

    companion object {
        fun from(vararg lottos: Lotto): Lottos {
            return Lottos(lottos.toList())
        }
    }
}
