package lotto

import lotto.vo.LottoNumber
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
            .mapNotNull { decidePrize(it, winningNumbers) }
            .groupBy { it }
            .mapValuesTo(defaultMap) { (_, value) -> value.size }
            .toList()
    }

    private fun decidePrize(lotto: Lotto, winningNumbers: WinningNumbers): Prize? {
        val countOfMatchingWinningNumbers = lotto.countMatchingNumbersFrom(winningNumbers.numbers)

        if (countOfMatchingWinningNumbers == 5) {
            return decideWithBonus(lotto, winningNumbers.bonusNumber)
        }

        return when (countOfMatchingWinningNumbers) {
            3 -> Prize.MATCH_3
            4 -> Prize.MATCH_4
            6 -> Prize.MATCH_6
            else -> null
        }
    }

    private fun decideWithBonus(lotto: Lotto, bonusNumber: LottoNumber): Prize {
        val isBonusNumberMatched = lotto.countMatchingNumbersFrom(listOf(bonusNumber)) == 1

        if (isBonusNumberMatched) {
            return Prize.MATCH_5_BONUS
        }

        return Prize.MATCH_5
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
