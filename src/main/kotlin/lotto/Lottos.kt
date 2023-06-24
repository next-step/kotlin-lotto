package lotto

import lotto.prize.Prize
import lotto.vo.WinningNumbers

data class Lottos(
    private val lottos: List<Lotto>,
) : Iterable<Lotto> {
    private val totalPrice = LottoShop.LOTTO_PRICE * lottos.count()

    val size: Int = lottos.size

    fun playWith(winningNumbers: WinningNumbers): GameResult {
        val prizes = aggregatePrizeWith(winningNumbers)

        return GameResult(
            prizes = prizes,
            paidPrice = totalPrice,
        )
    }

    private fun aggregatePrizeWith(winningNumbers: WinningNumbers): List<Pair<Prize, Int>> {
        val defaultMap = Prize
            .values()
            .associateWith { 0 }
            .toMutableMap()

        return lottos
            .mapNotNull { it.matchPrizeFrom(winningNumbers) }
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
